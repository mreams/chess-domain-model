package chess.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import chess.enums.Colour;
import chess.util.Location;

public class PawnTest {

	@Test
	public void testMoveOneForward() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(1, 0), new Location(2, 0));
		assertTrue(isValid, "pawns can move forward one space");
	}
	
	@Test
	public void testMoveTooFarNoCapture() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(1, 0), new Location(4, 0));
		assertFalse(isValid, "pawns can't move forward 3 spaces without trying to capture");
	}
	
	@Test
	public void testMoveMaximumCapture() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(1, 0), new Location(4, 1));
		assertTrue(isValid, "pawns can move forward 3 spaces to capture");
	}
	
	@Test
	public void testMoveBackward() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(3, 0), new Location(2, 0));
		assertFalse(isValid, "pawns can't move backward");
	}
	
	@Test
	public void testMoveTwoSpacesAfterFirstMove() {
		Piece piece = new Pawn(Colour.WHITE);
		Location firstOrigin = new Location(1, 0);
		Location firstDestination = new Location(3, 0);
		boolean firstMoveValid = piece.isMoveValid(firstOrigin, firstDestination);
		assertTrue(firstMoveValid, "pawns can move forward two spaces on their first move");
		
		piece.move(firstOrigin, firstDestination);
		
		Location secondOrigin = firstDestination;
		Location secondDestination = new Location(5,0);
		boolean secondMoveValid = piece.isMoveValid(secondOrigin, secondDestination);
		assertFalse(secondMoveValid, "pawns can only move 2 spaces on the first move");
	}
	
	@Test
	public void testCaptureRightDiagonal() {
		Piece piece = new Pawn(Colour.WHITE);
		boolean isValid = piece.isMoveValid(new Location(1, 1), new Location(2, 0));
		assertTrue(isValid, "pawns can move diagonally to the right to capture");
	}
	
	@Test
	public void testMovePathOneForward() {
		Piece piece = new Pawn(Colour.WHITE);
		List<Location> movePath = piece.getMovePath(new Location(1, 0), new Location(2, 0));
		
		assertTrue(movePath.size() == 1, "movePath should contain 1 element when the piece moves 1 square, actually " + movePath.size());
	}
	
	@Test
	public void testMovePathOneForwardCapture() {
		Piece piece = new Pawn(Colour.WHITE);
		Location origin = new Location(1, 1);
		Location destination = new Location(3,0);
		List<Location> movePath = piece.getMovePath(origin, destination);
		
		Location first = new Location(2,1);
		
		assertTrue(movePath.size() == 2, "movePath should be 2 locations long, actually " + movePath.size());
		assertTrue(movePath.get(0).equals(first), "first location in move path should be 2,1");
		assertTrue(movePath.get(1).equals(destination), "second location should be 2,0");
	}
	
	@Test
	public void testMovePathOneForwardCaptureLeft() {
		Piece piece = new Pawn(Colour.WHITE);
		Location origin = new Location(1, 0);
		Location destination = new Location(3,1);
		List<Location> movePath = piece.getMovePath(origin, destination);
		
		Location first = new Location(2,0);
		
		assertTrue(movePath.size() == 2, "movePath should be 2 locations long, actually " + movePath.size());
		assertTrue(movePath.get(0).equals(first), "first location in move path should be 2,1");
		assertTrue(movePath.get(1).equals(destination), "second location should be 2,0");
	}
	
	@Test
	public void testMovePathMaximumCapture() {
		Piece piece = new Pawn(Colour.WHITE);
		Location destination = new Location(4, 1);
		List<Location> movePath = piece.getMovePath(new Location(1, 0), destination);
		assertTrue(movePath.size() == 3, "pawns can move 3 spaces to capture if it's the first move, actually " + movePath.size());
		
		Location first = new Location(2,0);
		Location second = new Location(3,0);
		
		assertTrue(movePath.get(0).equals(first), "first location in move path should be 2,0");
		assertTrue(movePath.get(1).equals(second), "second location in move path should be 3,0");
		assertTrue(movePath.get(2).equals(destination), "third location in move path should be 4,1");
	}
	
	
}
