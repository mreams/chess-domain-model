package main.java.chess.model;

import main.java.chess.enums.Colour;
import main.java.chess.enums.Status;
import main.java.chess.util.Location;

/**
 * Inteface for common elements of a chess piece. The implementations of each piece will handle the details 
 * of their moves.
 */
public interface IPiece {
	
	public Colour getColour();
	
	public Status getStatus();
	
	public Location getLocation();
	
	public boolean move(Location destination);
	
	public boolean setCaptured();
	
	
}
