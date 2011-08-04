package pandapoetics.board;

import pandapoetics.tile.LetterFactory;
import pandapoetics.tile.PandaTile;

public class BoardFactory {
	public Board getDefaultBoard() {
		Board board = new Board();
		board.setSpot(4, 4, new PandaTile());
		
		LetterFactory letters = new LetterFactory();
		board.setSpot(3, 3, letters.getLetter(3,3));
		board.setSpot(4, 3, letters.getLetter(4,3));
		board.setSpot(5, 3, letters.getLetter(5,3));
		board.setSpot(3, 4, letters.getLetter(3,4));
		board.setSpot(5, 4, letters.getLetter(5,4));
		board.setSpot(3, 5, letters.getLetter(3,5));
		board.setSpot(4, 5, letters.getLetter(4,5));
		board.setSpot(5, 5, letters.getLetter(5,5));
		return board;
	}

	public Board getBoardFromFile(String fileName) {
		Board board = new Board();
		board.setSpot(4, 4, new PandaTile());
		LetterFactory letters = new LetterFactory(fileName);
		board.setSpot(3, 3, letters.getLetter(3,3));
		board.setSpot(4, 3, letters.getLetter(4,3));
		board.setSpot(5, 3, letters.getLetter(5,3));
		board.setSpot(3, 4, letters.getLetter(3,4));
		board.setSpot(5, 4, letters.getLetter(5,4));
		board.setSpot(3, 5, letters.getLetter(3,5));
		board.setSpot(4, 5, letters.getLetter(4,5));
		board.setSpot(5, 5, letters.getLetter(5,5));
		
		board.addTurns(letters.turns);
		
		return board;
	}
}
