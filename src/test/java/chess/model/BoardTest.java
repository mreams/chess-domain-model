package test.java.chess.model;


import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.chess.exceptions.NoPieceFoundException;
import main.java.chess.model.Board;

public class BoardTest {
	
	public BoardTest() {
		
	}

	@Test
	public void testMove() {
		Board board = new Board();
		assertTrue("just seeing if the test will run", board.move(0, 0, 1, 1));
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void shouldThrowNoPieceFoundException() throws Exception {
	    expectedEx.expect(NoPieceFoundException.class);

	    //attempt a move where there is no piece at the origin to force a NoPieceFoundException
	    Board board = new Board();
	    board.move(4, 4, 4, 5);
	}

}
