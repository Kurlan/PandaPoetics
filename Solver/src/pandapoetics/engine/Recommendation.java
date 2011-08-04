package pandapoetics.engine;

import java.io.PrintStream;
import java.util.List;

import pandapoetics.board.Spot;

public class Recommendation implements Comparable<Recommendation>{
	private Integer id;
	private String word;
	private List<Spot> spots;
	private Integer score;
	private Integer wordScore;
	private Integer pandaScore;
	private Integer ranking;
	private Integer oneValues;
	
	public Recommendation(Integer id, String word, List<Spot> spots) {
		this.id = id;
		this.word = word;
		this.spots = spots;
		this.setPandaScore(PandaProcessor.computePandaScore(spots));
		this.setWordScore(PandaProcessor.computeWordScore(spots));
		this.setScore(this.pandaScore + this.wordScore);
		this.setOneValues(PandaProcessor.numOnevalue(spots));
	}
	
	private void setOneValues(Integer numOnevalue) {
		this.oneValues = numOnevalue;
	}
	
	public Integer getOneValues() {
		return this.oneValues;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public List<Spot> getSpots() {
		return spots;
	}
	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getWordScore() {
		return wordScore;
	}
	public void setWordScore(Integer score) {
		this.wordScore = score;
	}
	public Integer getPandaScore() {
		return pandaScore;
	}
	public void setPandaScore(Integer score) {
		this.pandaScore = score;
	}
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	@Override
	public int compareTo(Recommendation arg0) {
		if (!this.getOneValues().equals(arg0.getOneValues())) {
			return -1 * (this.getOneValues().compareTo(arg0.getOneValues()));
		}
		
		
		if (this.score == arg0.score) {
			Integer a = this.getWord().length();
			Integer b = arg0.getWord().length();
			return a.compareTo(b);
		}
		
		return this.score.compareTo(arg0.score) * -1;
	}

	public void printXML(PrintStream out) {
		
		out.println("<rec id='"+getId() + "' word='"+getWord()+"' rank='"+getRanking()+"'>");
		Integer sequence = 0;
		for (Spot s: getSpots()) {
			out.println("<spot sequence='"+sequence+"' x='"+s.getX()+"' y='"+s.getY()+"'>");
			out.println("</spot>");
			sequence++;
		}
		out.println("<score total='"+getScore()+"' panda='"+getPandaScore()+"' word='"+getWordScore()+"'></score>");
		out.println("</rec>");
	}
}
