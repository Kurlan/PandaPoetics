package pandapoetics.board;

import java.awt.Point;
import java.io.PrintStream;

import pandapoetics.tile.LetterTile;
import pandapoetics.tile.Tile;

public class Spot implements Comparable<Spot>{
	private Point p;
	private Tile tile;
	
	public Spot(Tile tile, Point p) {
		this.tile = tile;
		this.p = p;
	}
	
	public Integer getX() {
		return p.x;
	}

	public Integer getY() {
		return p.y;
	}

	public Tile getTile() {
		return tile;
	}
	public void setTile(Tile tile) {
		this.tile = tile;
	}

	@Override
	public int compareTo(Spot o) {
		LetterTile a = (LetterTile) this.tile;
		LetterTile b = (LetterTile) o.getTile();
		return a.getLetter().compareTo(b.getLetter());
	}

	public void printXML(PrintStream out) {
		tile.printXML(out, p.x, p.y);
	}
	
	
	
	
}
