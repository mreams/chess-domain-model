package main.java.chess.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.chess.enums.Colour;
import main.java.chess.exceptions.NoPieceFoundException;

/**
 * Model for a chess board. Tracks the state of the pieces and their locations. 
 * on the board.
 */
public class Board {
	private static final Logger logger = LogManager.getLogger();
	 
	private Piece[][] board;
	
	//might not need these two
	private List<Piece> uncaptured;
	private List<Piece> captured;
	
	private final int BOARD_WIDTH = 8;
	
	public Board() {
		//initialize 2d array for board
		//create the lists of pieces - uncaptured and captured
		//set their locations on the board
		
		board = new Piece[BOARD_WIDTH][BOARD_WIDTH];
		uncaptured = new ArrayList<Piece>();
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

	public boolean move(int fromX, int fromY, int toX, int toY) {
		//is there a piece at the origin?
		Piece piece = board[fromX][fromY];
		
		if (piece == null) {
			logger.error("No piece found at x: " + fromX + " y: " + fromY);
			throw new NoPieceFoundException("No piece found at x: " + fromX + " y: " + fromY);
		}
		
		//can it move to destination?
		
		//is there anything in the way?
		
		//is there a piece to capture at the destination?
		
		//if there's a piece to capture, is it the other colour?
		
		return true;
	}
}
