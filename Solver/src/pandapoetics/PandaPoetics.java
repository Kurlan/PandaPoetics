package pandapoetics;

import pandapoetics.engine.PandaProcessor;
import pandapoetics.engine.PandaRecommender;

public class PandaPoetics {
	
	static Integer MAX_RECS = 300;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Please pass in xml");
			System.exit(1);
		}
		String boardFile = args[0];
		
		
		PandaProcessor game = new PandaProcessor(boardFile);
		PandaRecommender ai = new PandaRecommender(game.getBoard());
		ai.printXML(System.out);
		
//		game.useSpots(ai.getRecommendation().getRecommendation(223).getSpots());
//		game.getBoard().draw();
//		game.useSpots(ai.getRecommendation().getRecommendation(2558).getSpots());
//		game.getBoard().draw();
//		game.useSpots(ai.getRecommendation().getRecommendation(19263).getSpots());
//		game.getBoard().draw();
//		game.useSpots(ai.getRecommendation().getRecommendation(2837159).getSpots());
//		game.getBoard().draw();
//
//		int a = 0;
//		for (Recommendation s: ai.getRecommendation().getRecs()) {
//			if (a > MAX_RECS) break;
//			a++;
//			System.out.print(s.getId() + "\t" + s.getWord() + " " + s.getScore() + "(" + s.getWordScore() + "+" + s.getPandaScore() +")\t" + s.getOneValues() + "\t");
//			for (Spot spot: s.getSpots()) {
//				LetterTile letter = (LetterTile)spot.getTile();
//				System.out.print(letter.getLetter() + letter.getValue() + "(" + spot.getX() + ", " +spot.getY() + ") ");
//			}
//			System.out.println("");
//		}
//		
	}

}
