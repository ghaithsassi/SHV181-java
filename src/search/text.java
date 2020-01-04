package search;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* class text is OK */

public class text extends file {
	public text(String s)
	{
		super(s);
	}
	 public ArrayList<String> getContents(String filename) throws Exception 
		{
		 ArrayList<String> list = new ArrayList<String>();
		 String data = ""; 
		 data = new String(Files.readAllBytes(Paths.get(filename)));
		 StringTokenizer multiTokenizer = new StringTokenizer(data, " ://.-%+()[]$<>*'!?\\#;~,€{}") ;
		 while (multiTokenizer.hasMoreTokens())
		 {
		        list.add(multiTokenizer.nextToken());
		 }
		 return list ;
		 
		}






	
}