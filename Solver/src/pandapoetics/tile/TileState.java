package pandapoetics.tile;

public enum TileState {
	NEW(0), LETTER(1), PANDA(2), DEAD_PANDA(4), HIDDEN(5);
	
	
	private Integer id;
	TileState(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
}
