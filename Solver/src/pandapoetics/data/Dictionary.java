package pandapoetics.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pandapoetics.engine.StringHelper;

public class Dictionary {
  public static Map<String, List<String>>dict;
  
  static {
	  dict = new HashMap<String, List<String>>();
	  try {
		  BufferedReader in = new BufferedReader(new FileReader("data/dictionary"));
		  String str;
		  String sortedStr;
		  while ((str = in.readLine()) != null) {
		       sortedStr = StringHelper.sortString(str);
		       if (dict.containsKey(sortedStr)) {
		    	   dict.get(sortedStr).add(str);
		       } else {
		    	   dict.put(sortedStr, new ArrayList<String>());
		    	   dict.get(sortedStr).add(str);
		       }
		  }
		  
		  in.close();

	  }
	  catch (IOException e) {
		  e.printStackTrace();
	  }
  }
  

}
