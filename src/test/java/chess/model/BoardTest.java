package test.java.chess.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.java.chess.model.Board;

class BoardTest {

	@Test
	void testMove() {
		Board board = new Board();
		assertTrue(board.move(0, 0, 0, 0));
	}
	
	

}
