package pandapoetics.engine;

import java.util.Arrays;

public class StringHelper {

	public static String sortString(String s) {
	
		  char[] letters = s.toCharArray();
		  Arrays.sort(letters);
		  return new String(letters);
	  }

}
