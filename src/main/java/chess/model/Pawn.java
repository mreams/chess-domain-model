package main.java.chess.model;

import main.java.chess.enums.Colour;
import main.java.chess.enums.PieceType;
import main.java.chess.enums.Status;
import main.java.chess.util.Location;

public class Pawn extends Piece {
	boolean firstMove;
	
	public Pawn(Colour colour) {
		super.colour = colour;
		super.pieceType = PieceType.PAWN;
		super.status = Status.UNCAPTURED;
		this.firstMove = true;
	}

	@Override
	public boolean isMoveValid(Location origin, Location destination) {
		int xDistance = destination.getX() - origin.getX();
		//pawns can move diagonally right or left to capture, so we only care about the absolute distance
		int yDistance = Math.abs(destination.getY() - origin.getY());
		
		//pawns can never move move than 3 spaces forward even if it's their first move and they're capturing a piece
		if (xDistance > 3) {
			return false;
		} else if (xDistance < 1) {
			//pawns can never move backward
			return false;
		}
		
		//pawns can never move more than one space up or down even if they're capturing another piece 
		if (yDistance > 1) {
			return false;
		}
		
		//pawns can move 2 spaces forward and then capture on the diagonal only if it's the first move
		if (this.firstMove) {
			if (xDistance <= 3 && yDistance == 1) {
				return true;
			} else if (xDistance <= 2 && yDistance == 0) {
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

}
