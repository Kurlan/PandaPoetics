package pandapoetics.tile;

import java.io.PrintStream;

public class DeadTile extends Tile {

	public DeadTile() {
		super();
		this.state = TileState.DEAD_PANDA;
	}
	
	@Override
	public String draw() {
		return "[xxx]";
	}

	@Override
	public void printXML(PrintStream out, int x, int y) {

		out.println( "<tile state='DEAD' x='" + x + "' y='"+y+"' letter='?' />");
		
	}

}
