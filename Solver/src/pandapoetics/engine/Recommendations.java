package pandapoetics.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import pandapoetics.board.Spot;

public class Recommendations {

	public HashMap<Integer, Recommendation> recs;
	public Integer sequence;
	public List<Spot> letters;
	
	public Recommendations() {
		recs = new HashMap<Integer, Recommendation>();
	}

	public void add(Recommendation rec) {
		recs.put(rec.getId(), rec);
	}
	
	public Recommendation getRecommendation(Integer id) {
		return recs.get(id);
	}
	
	public List<Recommendation> getRecs() {
		List<Recommendation> keys = new ArrayList<Recommendation>(recs.values());
		Collections.sort(keys);
		return keys;
	}

}
