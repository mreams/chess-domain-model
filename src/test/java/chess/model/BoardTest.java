package chess.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import chess.enums.Colour;
import chess.exceptions.InvalidMoveException;
import chess.exceptions.NoPieceFoundException;
import chess.util.Location;

public class BoardTest {
	@Test
	public void testMove() {
		Board board = new Board();
		Location origin = new Location(1,0);
		Location destination = new Location(2,0);
		assertTrue(board.move(origin, destination), "basic valid move test");
	}
	
	@Test
	public void testZeroDistanceMove() {
		InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
			Location origin = new Location(1,0);
			Board board = new Board();
			board.move(origin, origin);
		});

	    assertTrue(thrown.getMessage().startsWith("Destination must be at least 1 square"), "exception message should start with 'Destination should be at least 1 square");
	}
	
	@Test
	public void testNoPieceAtOrigin() throws Exception {
	    
	    NoPieceFoundException thrown = Assertions.assertThrows(NoPieceFoundException.class, () -> {
	    	//attempt a move where there is no piece at the origin to force a NoPieceFoundException
		    Board board = new Board();
		    Location origin = new Location(4,4);
			Location destination = new Location(5,4);
		    board.move(origin, destination);
	    });

	    assertTrue(thrown.getMessage().startsWith("No piece found at x:"), "exception message should include 'No piece found at'");
	}
	
	@Test
	public void testMoveOffBoard() {
		InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
			Location origin = new Location(1,0);
			Location destination = new Location(1,-1);
			Board board = new Board();
			board.move(origin, destination);
		});

	    assertTrue(thrown.getMessage().startsWith("Destination must be on the board"), "exception message should include 'Destination must be on the board'");
	}
	
	@Test
	public void testCapture() {
		Board board = new Board();
		
		//the other side's pawns are at BOARD_WIDTH - 2 so we want to stop before we get there
		for (int i = 1; i < Board.BOARD_WIDTH - 3; i ++) {
			Location origin = new Location(i,0);
			Location destination = new Location(i + 1,0);
			board.move(origin, destination);
		}
		
		//now the white pawn can capture a black pawn
		Location origin = new Location(5,0);
		Location destination = new Location(6,1);
		board.move(origin, destination);
		
		List<Piece> capturedPieces = board.getCapturedPieces();
		
		assertTrue(capturedPieces.size() == 1, "1 piece should be captured");
	}
	
	@Test
	public void testCaptureSameColour() {
		Board board = new Board();
		Location origin = new Location(1,0);
		Location destination = new Location(2,0);
		
		board.move(origin, destination);
		
		Location origin2 = new Location(1,1);
		Location destination2 = new Location(2,0);
		
		InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
			board.move(origin2, destination2);
		});
		
		assertTrue(thrown.getMessage().startsWith("Attempted to capture piece of same colour"), "attempted to capture piece of same colour");
	}
	
	@Test
	public void testMoveWithPieceInWay() {
		//this takes some setup, we need to move a black piece across the board so we can have a white pawn capture it
		//that gets it in the way of the other white pawn trying to move 2 spaces on its first move
		Board board = new Board();
		
		//stop looping at i == 2 to put the black pawn right in front of the row of white pawns
		for (int i = Board.BOARD_WIDTH - 2; i > 2; i--) {
			Location origin = new Location(i, 3);
			Location destination = new Location(i - 1, 3);
			board.move(origin, destination);
		}
		
		//now capture the black pawn with a white one
		Location origin = new Location(1,2);
		Location destination = new Location(2,3);
		board.move(origin, destination);
		
		List<Piece> captured = board.getCapturedPieces();
		assertTrue(captured.size() == 1, "1 piece captured");
		assertTrue(captured.get(0).getColour() == Colour.BLACK, "black pawn should be captured");
		
		//now we finally have a piece in the way at 2,3!
		Location origin2 = new Location(1,3);
		Location destination2 = new Location(3,3);
		
		InvalidMoveException thrown = Assertions.assertThrows(InvalidMoveException.class, () -> {
			board.move(origin2, destination2);
		});
		
		assertTrue(thrown.getMessage().startsWith("Invalid move, obstructed by piece"), "Invalid move, obstructed by piece");
	}

	//TODO: test trying to move a pawn diagonally without trying to capture another piece
	//TODO: add tests for black pawn moves
	//TODO: edge case tests: capture that moves capturing piece to top, bottom, left, right edges of board - will require pieces to capture at edges

}
