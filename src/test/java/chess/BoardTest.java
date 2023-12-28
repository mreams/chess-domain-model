package test.java.chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.chess.*;

class BoardTest {

	@Test
	void testMove() {
		Board board = new Board();
		assertTrue(board.move(0, 0, 0, 0));
	}
	
	

}
