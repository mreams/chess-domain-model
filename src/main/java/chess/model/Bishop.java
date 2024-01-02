package chess.model;

import java.util.List;

import chess.enums.Colour;
import chess.enums.PieceType;
import chess.enums.Status;
import chess.util.Location;

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

	@Override
	public List<Location> getMovePath(Location origin, Location destination) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
