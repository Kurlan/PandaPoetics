package pandapoetics.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pandapoetics.board.Spot;
import pandapoetics.tile.LetterTile;

public class SpotIterator {
	Integer counter;
	Integer maskStart;
	List<Spot> originalLetters;
	List<Spot> sortedLetters;
	
	public SpotIterator(List<Spot> letters) {
		originalLetters = new ArrayList<Spot>(letters);
		sortedLetters = new ArrayList<Spot>(letters);
		
		Collections.sort(sortedLetters);
		counter = (int) (java.lang.Math.pow(2, letters.size())-1);
		maskStart = counter+1;
	}
	
	public String getString(List<Spot> letters) {
		StringBuilder builder = new StringBuilder();
		for (Spot s: letters) {
			builder.append(((LetterTile)s.getTile()).getLetter());
		}
		return builder.toString();
	}


	public Boolean hasNext() {
		return (counter >= 0);
	}
	
	public Recommendation next() {
		StringBuilder returnString = new StringBuilder();
		List<Spot> wordListing = new ArrayList<Spot>();
		Integer mask = maskStart;
		Integer index = 0;
		while (index < originalLetters.size()) {
			mask = mask >> 1;
			Integer test = mask & counter;
			if (test != 0) {
				LetterTile lt = (LetterTile)sortedLetters.get(index).getTile();
				returnString.append(lt.getLetter());
				wordListing.add(sortedLetters.get(index));
			}
			index++;
		}
		Recommendation r = new Recommendation(counter,returnString.toString(), wordListing);
		counter--;
		return r;
	}
}
