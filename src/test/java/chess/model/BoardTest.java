package chess.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import chess.exceptions.InvalidMoveException;
import chess.exceptions.NoPieceFoundException;

public class BoardTest {

	@Test
	public void testMove() {
		Board board = new Board();
		assertTrue(board.move(0, 0, 1, 1), "just seeing if the test will run");
	}
	
	@Test
	public void testZeroDistanceMove() {
		 InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
	    	//attempt a move where there is no piece at the origin to force a NoPieceFoundException
			Board board = new Board();
			board.move(0, 0, 0, 0);
	    });

	    assertTrue(thrown.getMessage().startsWith("Destination must be at least 1 square"), "exception message should start with 'Destination should be at least 1 square");
	}
	
	@Test
	public void shouldThrowNoPieceFoundException() throws Exception {
	    
	    NoPieceFoundException thrown = Assertions.assertThrows(NoPieceFoundException.class, () -> {
	    	//attempt a move where there is no piece at the origin to force a NoPieceFoundException
		    Board board = new Board();
		    board.move(4, 4, 4, 5);
	    });

	    assertTrue(thrown.getMessage().startsWith("No piece found at x:"), "exception message should include 'No piece found at'");
	}

}
