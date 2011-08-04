package pandapoetics.board;

import java.awt.Point;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import pandapoetics.tile.HiddenTile;
import pandapoetics.tile.Tile;
import pandapoetics.tile.TileState;

public class Board {

	public static final Integer BOARD_SIZE = 9;
	public List<String> turns;
	
	public Board() {
		boardState = new ArrayList<List<Spot>>();
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			List<Spot> newCol = new ArrayList<Spot>();
			for (int j = 0; j < BOARD_SIZE; j++) {
				newCol.add(new Spot(new HiddenTile(), new Point(i,j)));
			}
			boardState.add(newCol);
		}
		
	}
	
	private ArrayList<List<Spot>> boardState;

	public Spot getSpot(int x, int y) {
		List<Spot> col = boardState.get(x);
		return col.get(y);
	}
	
	public List<Spot> getAllSpots() {
		List<Spot> spots = new ArrayList<Spot>();
		for (int i=0; i< BOARD_SIZE; i++) {
			spots.addAll(boardState.get(i));
		}
		return spots;
	}
	
	public void setSpot(int x, int y, Tile tile) {
		List<Spot> col = boardState.get(x);
		col.get(y).setTile(tile);
	}

	public void draw() {
		System.out.println("------");
		System.out.println("   ( 0 )( 1 )( 2 )( 3 )( 4 )( 5 )( 6 )( 7 )( 8 )");
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print("("+i+")");
			for (int j = 0; j < BOARD_SIZE; j++) {

				//System.out.print("("+j+")");
				System.out.print(getSpot(i,j).getTile().draw());
			}
			System.out.println();
		}
	}
	
	public List<Spot> getAdjacentSpots(int x, int y) {
		List<Spot> returnList = new ArrayList<Spot>();
		if (x > 0) {
			returnList.add(getSpot(x-1, y));
		}
		if (x < BOARD_SIZE-1) {
			returnList.add(getSpot(x+1, y));
		}
		
		if (y > 0) {
			returnList.add(getSpot(x, y-1));
		}
		if (y < BOARD_SIZE-1) {
			returnList.add(getSpot(x, y+1));
		}
		return returnList;
	}
	
	public List<Spot> getPandaSpots() {
		List<Spot> returnList = new ArrayList<Spot>();
		for (Spot s: getAllSpots()) {
			if (s.getTile().getState().equals(TileState.PANDA)) {
				returnList.add(s);
			}
		}
		
		return returnList;
	}

	public List<Spot> getLetterSpots() {
		List<Spot> letterSpots = new ArrayList<Spot>();
		
		for (Spot s: getAllSpots()) {
			if (s.getTile().getState().equals(TileState.LETTER)) {
				letterSpots.add(s);
			}
		}
		
		return letterSpots;
		
	}

	public void addTurns(List<String> turns) {
		this.turns = turns;
	}

	public void printXML(PrintStream out) {
		out.println("<board><tiles>");
		for (int i =0 ; i < Board.BOARD_SIZE; i++ ){
			for (int j = 0; j< Board.BOARD_SIZE; j++) {
				Spot s = getSpot(i, j);
				s.printXML(out);
				
			}
		}
		out.println("</tiles></board>");
		
	}
}

