package chess.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess.enums.Colour;
import chess.util.Location;

class BishopTest {
	
	@Test
	void testMoveUpRight() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(0,0);
		Location destination = new Location(7,7);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertTrue(moveIsValid, "bishop should be able to move on diagonal up-right");
	}
	
	@Test
	void testMoveUpLeft() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(0,7);
		Location destination = new Location(7,0);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertTrue(moveIsValid, "bishop should be able to move on diagonal up-left");
	}
	
	@Test
	void testMoveDownRight() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(0,7);
		Location destination = new Location(7,0);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertTrue(moveIsValid, "bishop should be able to move on diagonal down-right");
	}

	@Test
	void testMoveDownLeft() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(7,7);
		Location destination = new Location(0,0);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertTrue(moveIsValid, "bishop should be able to move on diagonal down-left");
	}
	
	@Test
	void testMoveStraightDown() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(0,7);
		Location destination = new Location(0,0);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertFalse(moveIsValid, "bishops can't move straight down");
	}
	
	@Test
	void testMoveStraightUp() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(0,0);
		Location destination = new Location(0,7);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertFalse(moveIsValid, "bishops can't move straight up");
	}
	
	@Test
	void testMoveStraightRight() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(0,0);
		Location destination = new Location(7,0);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertFalse(moveIsValid, "bishops can't move straight right");
	}
	
	@Test
	void testMoveStraightLeft() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(7,0);
		Location destination = new Location(0,0);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertFalse(moveIsValid, "bishops can't move straight left");
	}
	
	@Test
	void testMoveUnevenDiagonal() {
		Bishop bishop = new Bishop(Colour.BLACK);
		Location origin = new Location(0,0);
		Location destination = new Location(2,3);
		boolean moveIsValid = bishop.isMoveValid(origin, destination);
		
		assertFalse(moveIsValid, "bishops can't move in an uneven diagonal");
	}
	

}
