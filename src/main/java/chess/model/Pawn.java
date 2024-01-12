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
	//TODO: FFS pawns can move forward or they can capture, never both at once!

	@Override
	public boolean isMoveValid(Location origin, Location destination) {
		int xDistance = Math.abs(destination.getX() - origin.getX());
		int yDistance = Math.abs(destination.getY() - origin.getY());
		
		//if a pawn is white, it can only move to higher X values
		if (this.colour == Colour.WHITE && destination.getX() < origin.getX()) {
			return false;
		} else if (this.colour == Colour.BLACK && destination.getX() > origin.getX()) {
			return false;
		}
		
		//pawns can move 2 spaces forward 
		if (this.firstMove) {
			if (xDistance <= 2 && yDistance == 0) {
				return true;
			} 
		} 
		
		if (xDistance == 1) {
			if (yDistance <= 1) {
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
