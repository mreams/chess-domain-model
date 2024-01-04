package chess.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import chess.enums.Colour;
import chess.exceptions.InvalidMoveException;
import chess.exceptions.NoPieceFoundException;
import chess.util.Location;


/**
 * Model for a chess board. Tracks the state of the pieces and their locations. 
 * on the board.
 */
public class Board {
	@SuppressWarnings("unused")
	//this will be used eventually, I swear
	private static final Logger logger = LogManager.getLogger();
	private Piece[][] board;
	
	//future improvement: return stats on how many pieces were captured in the game
	private List<Piece> captured;
	
	public final static int BOARD_WIDTH = 8;
	
	public Board() {		
		board = new Piece[BOARD_WIDTH][BOARD_WIDTH];
		captured = new ArrayList<Piece>();
		
		setTheBoard();
	}
	
	private void setTheBoard() {
		//set up the row of white pawns
		for (int i = 0; i < BOARD_WIDTH; i++) {
			board[1][i] = new Pawn(Colour.WHITE);
		}
		
		//white rooks
		board[0][BOARD_WIDTH - 1] = new Rook(Colour.WHITE);
		board[0][0] = new Rook(Colour.WHITE);
		
		//white bishops
		board[0][BOARD_WIDTH - 3] = new Bishop(Colour.WHITE);
		board[0][2] = new Rook(Colour.WHITE);
		
		//black pawns
		for (int i = 0; i < BOARD_WIDTH; i++) {
			board[BOARD_WIDTH - 2][i] = new Pawn(Colour.BLACK);
		}
		
		//black rooks
		board[BOARD_WIDTH - 1][BOARD_WIDTH - 1] = new Rook(Colour.BLACK);
		board[BOARD_WIDTH - 1][0] = new Rook(Colour.BLACK);
		
		//black bishops
		board[BOARD_WIDTH - 1][BOARD_WIDTH - 3] = new Bishop(Colour.BLACK);
		board[BOARD_WIDTH - 1][2] = new Rook(Colour.BLACK);
	}

	public boolean move(Location origin, Location destination) {
		int xDistance = destination.getX() - origin.getX();
		int yDistance = Math.abs(destination.getY() - origin.getY());
		
		//is the destination on the board?
		if (destination.getX() < 0 || destination.getX() >= BOARD_WIDTH
				|| destination.getY() < 0 || destination.getY() >= BOARD_WIDTH) {
			throw new InvalidMoveException("Destination must be on the board");
		}
		
		//is the move at least one square?
		if (xDistance == 0 && yDistance == 0) {
			throw new InvalidMoveException("Destination must be at least 1 square away from origin. origin: " +
					origin + " dest: " + destination);
		}
		
		//is there a piece at the origin?
		Piece piece = board[origin.getX()][origin.getY()];
		
		if (piece == null) {
			//logger.error("No piece found at x: " + fromX + " y: " + fromY);
			throw new NoPieceFoundException("No piece found at x: " + origin + " y: " + destination);
		}
		
		//can it move to destination?
		if (!piece.isMoveValid(origin, destination)) {
			throw new InvalidMoveException("Invalid move for piece: " + piece.getType() + " from origin: " + origin + " to destination: " + destination);
		}
		
		//is there anything in the way?
		List<Location> movePath = piece.getMovePath(origin, destination);
		//last location in the move path is always the destination, if there's anything at the destination
		//we must be trying to capture it, so it doesn't count as a piece in the way
		for (int i = 0; i < movePath.size() - 1; i++) {
			Location current = movePath.get(i);
			Piece obstruction = board[current.getX()][current.getY()];
			if (obstruction != null) {
				throw new InvalidMoveException("Invalid move, obstructed by piece: " + obstruction.getType() + " at: " + current);
			}
		}
		
		//is there a piece to capture at the destination?
		Piece toCapture = board[destination.getX()][destination.getY()];
		
		if (toCapture != null) {
			if (piece.getColour() == toCapture.getColour()) {
				throw new InvalidMoveException("Attempted to capture piece of same colour");
			}
			
			toCapture.setCaptured();
			this.captured.add(toCapture);
		}
		
		board[origin.getX()][origin.getY()] = null;
		board[destination.getX()][destination.getY()] = piece;
		
		return true;
	}

	public List<Piece> getCapturedPieces() {
		return this.captured;
	}
}
