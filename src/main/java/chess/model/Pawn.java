package chess.model;

import java.util.ArrayList;
import java.util.List;

import chess.enums.Colour;
import chess.enums.PieceType;
import chess.enums.Status;
import chess.util.Location;

public class Pawn extends Piece {
	boolean firstMove;
	
	public Pawn(Colour colour) {
		super.colour = colour;
		super.pieceType = PieceType.PAWN;
		super.status = Status.UNCAPTURED;
		this.firstMove = true;
	}
	
	//TODO: movement methods don't handle pawn promotion or en passant captures

	@Override
	public boolean isMoveValid(Location origin, Location destination) {
		int xDistance = Math.abs(destination.getX() - origin.getX());
		//pawns can move diagonally right or left to capture, so we only care about the absolute distance
		int yDistance = Math.abs(destination.getY() - origin.getY());
		
		//pawns can never move more than 3 spaces forward even if it's their first move and they're capturing a piece
		if (xDistance > 3) {
			return false;
		}
		
		//if a pawn is white, it can only move to higher X values
		if (this.colour == Colour.WHITE && destination.getX() < origin.getX()) {
			return false;
		} else if (this.colour == Colour.BLACK && destination.getX() > origin.getX()) {
			return false;
		}
		
		//pawns can never move more than one space up or down even if they're capturing another piece 
		if (yDistance > 1) {
			return false;
		}
		
		//pawns can move 2 spaces forward and then capture on the diagonal only if it's the first move
		if (this.firstMove) {
			//if pawn is moving 3 spaces forward it must be attempting to capture another piece
			if (xDistance == 3 && yDistance == 1) {
				return true;
			} else if (xDistance <= 2 && yDistance < 2) {
				return true;
			}
		} else {
			//if it's not the first move then the pawn can only move a maximum of 2 spaces forward including the
			//capture
			if (xDistance == 2 && yDistance == 1) {
				return true;
			} else if (xDistance == 1 && yDistance == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean move(Location origin, Location destination) {
		if (isMoveValid(origin, destination)) {
			this.firstMove = false;
			return true;
		} 
		
		return false;
	}

	@Override
	public List<Location> getMovePath(Location origin, Location destination) {
		int xDistance = destination.getX() - origin.getX();
		List<Location> movePath = new ArrayList<Location>();
		
		if (xDistance > 1) {
			for (int i = 1; i < xDistance; i++) {
				movePath.add(new Location(origin.getX() + i, origin.getY()));
			}
		}
		
		movePath.add(destination);
		return movePath;
	}

}
