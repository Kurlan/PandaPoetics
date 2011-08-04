package pandapoetics.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pandapoetics.board.Board;
import pandapoetics.tile.LetterValueTuple;

public class SampleBoards {
	private static Map<Integer, String[][]> boards;
	private static Map<Integer, LetterValueTuple[][]> newBoards;
	
	static {
		boards = new HashMap<Integer, String[][]>();
		newBoards = new HashMap<Integer, LetterValueTuple[][]>();
		String[][] foo = {
				{"g", "e", "m", "t", "i" ,"n", "n", "d", "e"},
				{"t", "x", "o", "w", "i" ,"h", "h", "x", "e"},
				{"e", "r", "i", "o", "o" ,"l", "g", "t", "o"},
				{"r", "a", "i", "r", "e" ,"s", "o", "p", "e"},
				{"y", "r", "r", "l", " " ,"d", "r", "m", "n"},
				{"o", "a", "r", "c", "i" ,"w", "n", "h", "d"},
				{"r", "n", "i", "s", "o" ,"e", "t", "o", "n"},
				{"y", "n", "i", "i", "e" ,"z", "i", "a", "e"},
				{"a", "o", "s", "qu", "u" ,"r", "l", "s", "a"},
	};
		boards.put(0, foo);
		
		String[][] foo2 = {
				{"g", "e", "m", "t", "i" ,"n", "n", "d", "e"},
				{"t", "x", "o", "w", "i" ,"h", "h", "x", "e"},
				{"e", "r", "i", "o", "o" ,"l", "g", "t", "o"},
				{"r", "a", "i", "r", "e" ,"s", "o", "p", "e"},
				{"y", "r", "r", "l", " " ,"d", "r", "m", "n"},
				{"o", "a", "r", "c", "i" ,"w", "n", "h", "d"},
				{"r", "n", "i", "s", "o" ,"e", "t", "o", "n"},
				{"y", "n", "i", "i", "e" ,"z", "i", "a", "e"},
				{"a", "o", "s", "qu", "u" ,"r", "l", "s", "a"},
	};
		boards.put(1, foo2);
		
		LetterValueTuple[][] foobar = {
				{new LetterValueTuple("o",4), new LetterValueTuple("d",4), new LetterValueTuple("a",4), new LetterValueTuple("o",4), new LetterValueTuple("e",4), new LetterValueTuple("g",4), new LetterValueTuple("h",4), new LetterValueTuple("l",4),  new LetterValueTuple("r",4), },
				{new LetterValueTuple("a",4), new LetterValueTuple("d",4), new LetterValueTuple("n",4), new LetterValueTuple("c",4), new LetterValueTuple("i",4), new LetterValueTuple("i",4), new LetterValueTuple("i",4), new LetterValueTuple("c",4),  new LetterValueTuple("b",4), },
				{new LetterValueTuple("c",4), new LetterValueTuple("h",4), new LetterValueTuple("s",4), new LetterValueTuple("f",4), new LetterValueTuple("e",4), new LetterValueTuple("o",4), new LetterValueTuple("t",4), new LetterValueTuple("f",4),  new LetterValueTuple("n",4), },
				{new LetterValueTuple("e",4), new LetterValueTuple("o",4), new LetterValueTuple("o",4), new LetterValueTuple("a",10), new LetterValueTuple("a",5), new LetterValueTuple("s",5), new LetterValueTuple("o",4), new LetterValueTuple("l",4),  new LetterValueTuple("n",4), },
				{new LetterValueTuple("l",4), new LetterValueTuple("t",4), new LetterValueTuple("p",4), new LetterValueTuple("h",5), new LetterValueTuple(" ",4), new LetterValueTuple("b",15), new LetterValueTuple("s",4), new LetterValueTuple("t",4),  new LetterValueTuple("t",4), },
				{new LetterValueTuple("l",4), new LetterValueTuple("g",4), new LetterValueTuple("y",9), new LetterValueTuple("n",5), new LetterValueTuple("o",5), new LetterValueTuple("n",5), new LetterValueTuple("n",4), new LetterValueTuple("n",4),  new LetterValueTuple("a",4), },
				{new LetterValueTuple("u",4), new LetterValueTuple("a",4), new LetterValueTuple("m",4), new LetterValueTuple("l",4), new LetterValueTuple("o",4), new LetterValueTuple("e",4), new LetterValueTuple("o",4), new LetterValueTuple("s",4),  new LetterValueTuple("g",4), },
				{new LetterValueTuple("e",4), new LetterValueTuple("u",4), new LetterValueTuple("a",4), new LetterValueTuple("i",4), new LetterValueTuple("o",4), new LetterValueTuple("w",4), new LetterValueTuple("t",4), new LetterValueTuple("l",4),  new LetterValueTuple("l",4), },
				{new LetterValueTuple("p",4), new LetterValueTuple("a",4), new LetterValueTuple("r",4), new LetterValueTuple("o",4), new LetterValueTuple("e",4), new LetterValueTuple("e",4), new LetterValueTuple("c",4), new LetterValueTuple("s",4),  new LetterValueTuple("y",4), },
				
		};
		
		newBoards.put(0, foobar);
		
		LetterValueTuple[][] foobar1 = {
				{new LetterValueTuple("t",4), new LetterValueTuple("e",9), new LetterValueTuple("b",4), new LetterValueTuple("b",4), new LetterValueTuple("i",4), new LetterValueTuple("m",4), new LetterValueTuple("e",4), new LetterValueTuple("c",4),  new LetterValueTuple("r",4), },
				{new LetterValueTuple("r",4), new LetterValueTuple("d",4), new LetterValueTuple("o",4), new LetterValueTuple("e",4), new LetterValueTuple("o",4), new LetterValueTuple("p",4), new LetterValueTuple("o",4), new LetterValueTuple("r",4),  new LetterValueTuple("t",4), },
				{new LetterValueTuple("a",4), new LetterValueTuple("o",4), new LetterValueTuple("i",4), new LetterValueTuple("a",4), new LetterValueTuple("e",4), new LetterValueTuple("d",4), new LetterValueTuple("u",14), new LetterValueTuple("w",4),  new LetterValueTuple("i",4), },
				{new LetterValueTuple("i",4), new LetterValueTuple("e",4), new LetterValueTuple("g",4), new LetterValueTuple("e",5), new LetterValueTuple("o",5), new LetterValueTuple("u",5), new LetterValueTuple("m",4), new LetterValueTuple("h",4),  new LetterValueTuple("r",4), },
				{new LetterValueTuple("t",4), new LetterValueTuple("n",4), new LetterValueTuple("l",4), new LetterValueTuple("t",5), new LetterValueTuple(" ",4), new LetterValueTuple("f",5), new LetterValueTuple("k",4), new LetterValueTuple("n",4),  new LetterValueTuple("t",4), },
				{new LetterValueTuple("a",4), new LetterValueTuple("b",4), new LetterValueTuple("r",4), new LetterValueTuple("l",5), new LetterValueTuple("u",5), new LetterValueTuple("a",5), new LetterValueTuple("h",4), new LetterValueTuple("o",4),  new LetterValueTuple("n",4), },
				{new LetterValueTuple("e",4), new LetterValueTuple("h",4), new LetterValueTuple("d",4), new LetterValueTuple("h",4), new LetterValueTuple("a",4), new LetterValueTuple("p",4), new LetterValueTuple("e",4), new LetterValueTuple("h",4),  new LetterValueTuple("e",9), },
				{new LetterValueTuple("r",4), new LetterValueTuple("p",4), new LetterValueTuple("y",4), new LetterValueTuple("e",4), new LetterValueTuple("e",4), new LetterValueTuple("y",4), new LetterValueTuple("a",4), new LetterValueTuple("i",4),  new LetterValueTuple("f",4), },
				{new LetterValueTuple("a",4), new LetterValueTuple("f",4), new LetterValueTuple("h",4), new LetterValueTuple("m",4), new LetterValueTuple("o",4), new LetterValueTuple("o",4), new LetterValueTuple("v",4), new LetterValueTuple("e",4),  new LetterValueTuple("f",4), },
				
		};
		newBoards.put(1, foobar1);
		
		LetterValueTuple[][] foobar2 = {
				{new LetterValueTuple("?",4), new LetterValueTuple("x",4), new LetterValueTuple("a",4), new LetterValueTuple("e",4), new LetterValueTuple("a",4), new LetterValueTuple("e",4), new LetterValueTuple("d",4), new LetterValueTuple("h",4),  new LetterValueTuple("t",4), },
				{new LetterValueTuple("t",4), new LetterValueTuple("s",4), new LetterValueTuple("c",4), new LetterValueTuple("c",4), new LetterValueTuple("e",4), new LetterValueTuple("a",4), new LetterValueTuple("c",4), new LetterValueTuple("i",4),  new LetterValueTuple("s",4), },
				{new LetterValueTuple("e",4), new LetterValueTuple("r",9), new LetterValueTuple("i",4), new LetterValueTuple("r",4), new LetterValueTuple("i",4), new LetterValueTuple("n",4), new LetterValueTuple("r",4), new LetterValueTuple("i",14),  new LetterValueTuple("i",4), },
				{new LetterValueTuple("v",4), new LetterValueTuple("l",4), new LetterValueTuple("l",4), new LetterValueTuple("m",5), new LetterValueTuple("i",5), new LetterValueTuple("j",5), new LetterValueTuple("t",4), new LetterValueTuple("w",4),  new LetterValueTuple("p",4), },
				{new LetterValueTuple("t",4), new LetterValueTuple("l",4), new LetterValueTuple("s",4), new LetterValueTuple("c",5), new LetterValueTuple(" ",4), new LetterValueTuple("l",5), new LetterValueTuple("h",4), new LetterValueTuple("f",4),  new LetterValueTuple("b",4), },
				{new LetterValueTuple("c",4), new LetterValueTuple("d",4), new LetterValueTuple("o",9), new LetterValueTuple("o",5), new LetterValueTuple("a",5), new LetterValueTuple("e",5), new LetterValueTuple("d",4), new LetterValueTuple("t",4),  new LetterValueTuple("o",4), },
				{new LetterValueTuple("g",4), new LetterValueTuple("c",4), new LetterValueTuple("j",4), new LetterValueTuple("u",4), new LetterValueTuple("e",4), new LetterValueTuple("l",4), new LetterValueTuple("t",4), new LetterValueTuple("m",4),  new LetterValueTuple("o",4), },
				{new LetterValueTuple("e",4), new LetterValueTuple("n",4), new LetterValueTuple("a",4), new LetterValueTuple("h",4), new LetterValueTuple("a",4), new LetterValueTuple("r",4), new LetterValueTuple("b",4), new LetterValueTuple("e",4),  new LetterValueTuple("h",4), },
				{new LetterValueTuple("i",4), new LetterValueTuple("g",4), new LetterValueTuple("e",4), new LetterValueTuple("t",4), new LetterValueTuple("e",4), new LetterValueTuple("a",4), new LetterValueTuple("s",4), new LetterValueTuple("o",4),  new LetterValueTuple("?",4), },
				
		};
		newBoards.put(2, foobar2);
		
	}
	
	public static String [][] getSampleBoard(Integer index) {
		return boards.get(index);
	}
	
	public static LetterValueTuple[][] getNewSampleBoard(Integer index) {
		return newBoards.get(index);
	}
	
	public static LetterValueTuple[][] getSampleBoardFromFile(Integer index) {
		File boardFile = new File("data/Boards");
		LetterValueTuple[][] returnBoard = new LetterValueTuple[Board.BOARD_SIZE][Board.BOARD_SIZE];
		try {
			BufferedReader input =  new BufferedReader(new FileReader(boardFile));
			String line = null;
			int row = 0;
			while (( line = input.readLine()) != null){
				String[] tiles = line.split(" ");
				for (int i = 0; i < tiles.length;i++) {
					String[] tokens = tiles[i].split(",");
					returnBoard[row][i] = new LetterValueTuple(tokens[0], new Integer(tokens[1]));
				}
				row++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return returnBoard;
	}

	public static BoardFromFile getSampleBoardFromFile(String fileName) {
		File boardFile = new File(fileName);
		BoardFromFile returnBoard = new BoardFromFile();
		returnBoard.tuples = new LetterValueTuple[Board.BOARD_SIZE][Board.BOARD_SIZE];
		try {
			BufferedReader input =  new BufferedReader(new FileReader(boardFile));
			String line = null;
			int row = 0;
			while (( line = input.readLine()) != null && row != 8){
				String[] tiles = line.split(" ");
				for (int i = 0; i < tiles.length;i++) {
					String[] tokens = tiles[i].split(",");
					returnBoard.tuples[row][i] = new LetterValueTuple(tokens[0], new Integer(tokens[1]));
				}
				row++;
			}
			List<String> turns = new ArrayList<String>();
			while (( line = input.readLine()) != null) {
				if (line.contains("|")) {
					String []t = line.split("|");
					for (String someTurns : t) {
						turns.add(someTurns);
					}
				}
				else{
					turns.add(line);
				}
			}
			returnBoard.turns = turns;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return returnBoard;
	}
}
