package main.java.chess.model;

import main.java.chess.enums.Colour;
import main.java.chess.enums.PieceType;
import main.java.chess.enums.Status;
import main.java.chess.util.Location;

public class Bishop extends Piece {
	
	public Bishop(Colour colour) {
		super.colour = colour;
		super.pieceType = PieceType.ROOK;
		super.status = Status.UNCAPTURED;
	}

	@Override
	public boolean isMoveValid(Location origin, Location destination) {
		// TODO Auto-generated method stub
		return false;
	}

}
