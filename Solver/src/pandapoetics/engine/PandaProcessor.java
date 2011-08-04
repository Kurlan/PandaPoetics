package pandapoetics.engine;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import pandapoetics.board.Board;
import pandapoetics.board.BoardFactory;
import pandapoetics.board.Spot;
import pandapoetics.tile.DeadTile;
import pandapoetics.tile.HiddenTile;
import pandapoetics.tile.LetterFactory;
import pandapoetics.tile.LetterTile;
import pandapoetics.tile.LetterValueTuple;
import pandapoetics.tile.PandaTile;
import pandapoetics.tile.Tile;
import pandapoetics.tile.TileState;

public class PandaProcessor {
	public Board board;
	public Integer totalScore;
	public String filename;
	
	public PandaProcessor(String fileName) {
		BoardFactory factory = new BoardFactory();
		this.filename = fileName;
		this.board = factory.getBoardFromFile(fileName);
		totalScore = 0;
		fastForward();
	}
	
	private void fastForward() {
		for(String t: board.turns) {
			List<Spot> tempWord = new ArrayList<Spot>();
			String[] tokens = t.split("-");
			for (int i = 0; i< tokens.length - 2; i++) {
				String spot = tokens[i];
				int x = Integer.parseInt(spot.substring(0,1));
				int y = Integer.parseInt(spot.substring(1,2));
				LetterTile tile = (LetterTile)board.getSpot(x, y).getTile();
				Spot s = new Spot(tile, new Point(x, y) );
				tempWord.add(s);
				
			}
			useSpots(tempWord);
		}
	}

	public Board getBoard() {
		return board;
	}
	
	public void useSpots(List<Spot> newWord) {
		List<Spot>letterSpots = board.getLetterSpots();
		LetterFactory letterFactory = new LetterFactory(filename);
		for (Spot spot : newWord) {
			for (Spot adjacentSpot : board.getAdjacentSpots(spot.getX(), spot.getY())) {
				if (adjacentSpot.getTile().getState().equals(TileState.HIDDEN)) {
					board.setSpot(adjacentSpot.getX(), adjacentSpot.getY(), letterFactory.getLetter(adjacentSpot.getX(), adjacentSpot.getY()));
				}
			}
		}
		Integer thisWordScore = computeWordScore(newWord);
		totalScore += thisWordScore;
		// calc word score
		
		for (Spot s: letterSpots) {
			LetterTile tile = (LetterTile)s.getTile();
			Integer value = tile.getValue();
			if (value.equals(1)) {
				board.setSpot(s.getX(), s.getY(), new DeadTile());
			} else {
				tile.setValue(value-1);
			}
			
		}

		for (Spot spot : newWord) {
			LetterTile tile = (LetterTile)spot.getTile();
			board.setSpot(spot.getX(), spot.getY(), new PandaTile(tile.getLetter()));
		}
		
		Integer thisPandaScore = computePandaScore(board.getPandaSpots());
		totalScore += thisPandaScore;
	}
	
	public static Integer computeWordScore(List<Spot> word) {
		Integer score = 0;
		for (Spot spot : word) {
			try {
				score += ((LetterTile)spot.getTile()).getValue();
			}
			catch (ClassCastException e)
			{
				System.out.println(spot.getX() +" " + spot.getY());
				throw e;
			}
		}
		
		score *= word.size() * word.size() * word.size() * word.size();
		return score;
	}
	
	public static Integer numOnevalue(List<Spot> word) {
		Integer oneValues = 0;
		for (Spot spot : word) {
			try {
				if (((LetterTile)spot.getTile()).getValue().equals(1)) {
					oneValues++;
				}
			}
			catch (ClassCastException e)
			{
				System.out.println(spot.getX() +" " + spot.getY());
				throw e;
			}
		}
		
		return oneValues;
	}
	
	public Integer getTotalScore() {
		return totalScore;
	}
	
	public static Integer computePandaScore(List<Spot> pandaList) {
		//board.draw();
		if (pandaList.size() == 0) return 0;
		Board tempBoard = new Board();
		
		for (Spot a : pandaList) {
				tempBoard.setSpot(a.getX(), a.getY(), new PandaTile());
		}
		
		
		
		return computePanda(tempBoard);
	}
	
	public static Integer computePanda(Board b) {
		Point max1 = new Point();
		Point max2 = new Point();
		Integer maxArea = 0;
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			for (int j =0; j < Board.BOARD_SIZE; j++) {
				if (b.getSpot(i, j).getTile().getState().equals(TileState.PANDA)) {
					int currentLength = getRowSize(i, j, b);
					
					for (int variableLength = 1; variableLength <= currentLength; variableLength++){
						Integer localSize = variableLength;
						Integer width = 0;
						for (int k = 1; k < Board.BOARD_SIZE - i; k++) {
							int newRowSize = getRowSize(i+k, j, b);
							if (newRowSize < variableLength) {
								break;
							}
							localSize += variableLength;
							width = k;
						}
						if (localSize > maxArea) {
							maxArea = localSize;
							max1.x = i;
							max1.y = j;
							max2.x = max1.x + width;
							if (max2.x >= Board.BOARD_SIZE) {
								max2.x -= 1;
							}
							max2.y = max1.y + variableLength-1;
						}
					}
				}

			}
		}
		if (maxArea == 0) {
			return 0;
		}

		for (int i = max1.x; i <= max2.x; i++) {
			for (int j = max1.y;  j <= max2.y; j++) {
				b.setSpot(i, j, new HiddenTile());
			}
		}
		return maxArea * maxArea * 50 + (computePanda(b));
	}
	
	public static Integer getRowSize(Integer x, Integer y, Board b) {
		int size = 0;
		for (int i = 0; i < Board.BOARD_SIZE - y; i++) {
			if (!b.getSpot(x, y + i).getTile().getState().equals(TileState.PANDA)) {
				break;
			}
			size++;
		}
		return size;
	}
}
