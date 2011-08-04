package pandapoetics.tile;

import java.util.List;

import pandapoetics.data.BoardFromFile;
import pandapoetics.data.SampleBoards;

public class LetterFactory {
	
	public LetterFactory() {
		newLetterMap = SampleBoards.getSampleBoardFromFile(1);
	}
	public LetterFactory(String fileName) {
		
		BoardFromFile file = SampleBoards.getSampleBoardFromFile(fileName);
		newLetterMap = file.tuples;
		turns = file.turns;
	}
	
	public List<String> turns;
	public LetterValueTuple[][]newLetterMap;
	
	public LetterTile getLetter(Integer x, Integer y) {
		if (newLetterMap[x][y].getLetter().equals(" ")){
			return new LetterTile(new LetterValueTuple("X",getScore()));
		}
		return new LetterTile(new LetterValueTuple(newLetterMap[x][y].getLetter(),newLetterMap[x][y].getValue()));
	}
	
	public LetterTile getLetter() {
		return new LetterTile(new LetterValueTuple(getRandomLetter(), getScore()));
	}
	
	private String getRandomLetter() {
		return "a";
	}
	
	private Integer getScore() {
		return 5;
	}
}
