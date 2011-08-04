package pandapoetics.tile;

public class LetterValueTuple {
	private String letter;
	private Integer value;
	public LetterValueTuple(String letter, Integer value) {
		this.letter = letter.toUpperCase();
		this.value = value;
	}
	
	public String getLetter() {
		return this.letter;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
}
