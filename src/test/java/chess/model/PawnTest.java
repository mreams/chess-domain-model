package test.java.chess.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.chess.enums.Colour;
import main.java.chess.model.Piece;
import main.java.chess.model.Pawn;
import main.java.chess.util.Location;


public class PawnTest {
	
	public PawnTest() {
		
	}

	@Test
	public void testMoveOneForward() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(1, 0), new Location(2, 0));
		assertTrue("pawns can move forward one space", isValid);
	}
	
	@Test
	public void testMoveTooFarNoCapture() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(1, 0), new Location(4, 0));
		assertFalse("pawns can't move forward 3 spaces without trying to capture", isValid);
	}
	
	@Test
	public void testMoveMaximumCapture() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(1, 0), new Location(4, 1));
		assertTrue("pawns can move forward 3 spaces to capture", isValid);
	}
	
	@Test
	public void testMoveBackward() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(3, 0), new Location(2, 0));
		assertFalse("pawns can't move backward", isValid);
	}
	
	@Test
	public void testMoveTwoSpacesAfterFirstMove() {
		Piece piece = new Pawn(Colour.WHITE);
		Location firstOrigin = new Location(1, 0);
		Location firstDestination = new Location(3, 0);
		boolean firstMoveValid = piece.isMoveValid(firstOrigin, firstDestination);
		assertTrue("pawns can move forward two spaces on their first move", firstMoveValid);
		
		piece.move(firstOrigin, firstDestination);
		
		Location secondOrigin = firstDestination;
		Location secondDestination = new Location(5,0);
		boolean secondMoveValid = piece.isMoveValid(secondOrigin, secondDestination);
		assertFalse("pawns can only move 2 spaces on the first move", secondMoveValid);
	}
	
	@Test
	public void testCaptureRightDiagonal() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(1, 1), new Location(2, 0));
		assertTrue("pawns can move diagonally to the right to capture", isValid);
	}
}
