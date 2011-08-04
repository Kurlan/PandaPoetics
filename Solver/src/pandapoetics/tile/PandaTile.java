package pandapoetics.tile;

import java.io.PrintStream;

public class PandaTile extends Tile  {
	private String formerString;
	public PandaTile() {
		super();
		this.state = TileState.PANDA;
		formerString = "?";
	}
	
	public PandaTile(String s) {
		formerString = s;
	}
	
	@Override
	public String draw() {
		return "[+++]";
	}

	@Override
	public void printXML(PrintStream out, int x, int y) {

		out.println( "<tile state='PANDA' x='" + x + "' y='"+y+"' letter='"+formerString+"' />");
		
	}

}
