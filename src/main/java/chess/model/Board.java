package main.java.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for a chess board. Tracks the state of the pieces and their locations. 
 * on the board.
 */
public class Board {
	int[][] board;
	List<IPiece> uncaptured;
	List<IPiece> captured;
	
	public Board() {
		//initialize 2d array for board
		//create the lists of pieces - uncaptured and captured
		//set their locations on the board
		
		board = new int[8][8];
		uncaptured = new ArrayList<IPiece>();
		captured = new ArrayList<IPiece>();
		
		setTheBoard();
	}
	
	private void setTheBoard() {
		
		
	}

	public boolean move(int fromX, int fromY, int toX, int toY) {
		return true;
	}
}
