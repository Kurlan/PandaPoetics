package pandapoetics.tile;

import java.io.PrintStream;

public class LetterTile extends Tile {
	private LetterValueTuple tuple;
	
	public LetterTile(LetterValueTuple tuple) {
		super();
		this.tuple = tuple;
		this.state = TileState.LETTER;
	}
	
	@Override
	public String draw() {
		return "["+this.tuple.getLetter() + "," + this.tuple.getValue().toString() + "]";
	}
	
	public Integer getValue() {
		return this.tuple.getValue();
	}
	
	public void setValue(Integer value) {
		this.tuple.setValue(value);
	}

	public String getLetter() {
		return this.tuple.getLetter();
	}

	@Override
	public void printXML(PrintStream out, int x, int y) {

		out.println( "<tile state='OPEN' x='" + x + "' y='"+y+"' letter='"+getLetter()+"' score='"+getValue()+"' />");
		
	}
	
	
}
