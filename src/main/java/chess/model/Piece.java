package chess.model;

import java.util.List;

import chess.enums.Colour;
import chess.enums.PieceType;
import chess.enums.Status;
import chess.util.Location;

/**
 * Inteface for common elements of a chess piece. The implementations of each piece will handle the details 
 * of their moves.
 */
public abstract class Piece {
	protected Colour colour;
	protected PieceType pieceType;
	protected Status status;
	
	public Colour getColour() {
		return this.colour;
	}
	
	public PieceType getType() {
		return this.pieceType;
	}

	public Status getStatus() {
		return this.status;
	}
	
	public boolean setCaptured() {
		this.status = Status.CAPTURED;
		return true;
	}
	
	/**
	 * Checks if move from origin to to destination is valid for the piece type. Note that this method does not check 
	 * if there is anything in the way or if this move would go beyond the edges of the board, it only checks if it's 
	 * possible for the piece to move to the given location
	 * @param origin start location to move from. used to calculate whether the move is possible for the piece type.
	 * @param destination location to move to. used to calculate whether the move is possible for the piece type.
	 * @return true if move is valid for the piece type
	 */
	public abstract boolean isMoveValid(Location origin, Location destination);
	
	/**
	 * Handles the move to the given location. This is effectively a hook to add any piece-specific move logic, like
	 * pawns being able to move 2 spaces forward only on their first move.
	 * @param origin start location to move from. used to calculate whether the move is possible for the piece type.
	 * @param destination location to move to. used to calculate whether the move is possible for the piece type.
	 * @return true if move can be done successfully
	 */
	public boolean move(Location origin, Location destination) {
		return isMoveValid(origin, destination);
	}
	
	/**
	 * Returns a list of the Locations the piece will move through on its way from origin to destination
	 * @param origin start location to move from
	 * @param destination location to move to
	 * @return List<Location> of all the locations the piece will move through on the way to the destination, not including the origin
	 */
	public abstract List<Location> getMovePath(Location origin, Location destination);
	
}
