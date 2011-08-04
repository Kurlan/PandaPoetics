package pandapoetics.tile;

import java.io.PrintStream;

public class HiddenTile extends Tile {

	public HiddenTile() {
		super();
		this.state = TileState.HIDDEN;
	}
	
	@Override
	public String draw() {
		return "[   ]";
	}

	@Override
	public void printXML(PrintStream out, int x, int y) {
		out.println( "<tile state='HIDDEN' x='" + x + "' y='"+y+"' letter='?' />");
	}
	
}
