package pandapoetics.engine;

import java.io.PrintStream;
import java.util.List;

import pandapoetics.board.Board;
import pandapoetics.board.Spot;
import pandapoetics.data.Dictionary;


public class PandaRecommender {
	protected Board board;
	
	public PandaRecommender(Board b) {
		this.board = b;
	}
	  
	  public Recommendations getRecommendation() {
		  List<Spot> letters = board.getLetterSpots();
		  Recommendations r = new Recommendations();
		  SpotIterator i = new SpotIterator(letters);
		  while	 (i.hasNext()) {
			  Recommendation next = i.next();
			  if (next.getWord().length() < 2) {
				continue;
			  }
			  if (Dictionary.dict.containsKey(next.getWord())) {
				  for (String s: Dictionary.dict.get(next.getWord())) {
					  next.setWord(s);
					  r.add(next);
				  }
			  }
		  }
		  return r;
	  }

	public void printXML(PrintStream out) {
		Integer rank = 0;
		out.println("<recs>");
		for (Recommendation s: getRecommendation().getRecs()) {
			s.setRanking(rank);
			s.printXML(out);
			rank++;
		}
		board.printXML(out);
		
		out.println("</recs>");
		
	}
}
