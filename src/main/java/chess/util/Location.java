package chess.util;

public class Location {
	private int x, y;
	
	public Location (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	@Override
	public boolean equals(Object o) {
		Location other = (Location) o;
		
		return this.x == other.x && this.y == other.y;
	}

}
