package main.java.chess.model;

import main.java.chess.enums.Colour;
import main.java.chess.enums.PieceType;
import main.java.chess.enums.Status;
import main.java.chess.util.Location;

public class Rook extends Piece {
	
	public Rook(Colour colour) {
		super.colour = colour;
		this.pieceType = PieceType.ROOK;
		this.status = Status.UNCAPTURED;
	}

	@Override
	public boolean isMoveValid(Location origin, Location destination) {
		// TODO Auto-generated method stub
		return false;
	}
}
