package pandapoetics.tile;

import java.io.PrintStream;

public abstract class Tile {
	protected TileState state;
	
	public Tile() {
		state = TileState.NEW;
	}
	
	public TileState getState() {
		return state;
	}
	
	
	
	public String draw() {
		return "";
	}

	public abstract void printXML(PrintStream out, int x, int y);
	
	
}
