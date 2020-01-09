package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Class engine is OK, but we must code database and ranking before

public class engine {

	protected static mapDatabase myindex = new mapDatabase();
	

	
	//private rankingAlgorithm myRanker;
	
	public engine()
	{
		//myRanker = new aLitleBitSmarterAlgorithm();
	}
	public engine(database db)
	{
		myindex = (mapDatabase) db;
		//myRanker = new notVerySmartRankingAlgorithm();
	}

	//end of constructors 
	public int id(String s) {
		int n = myindex.getfileId(s);
		return n ;
	}
		public static ArrayList<Pair<String,wordAttributes>> analyze(file myfile) throws Exception
		{
				
				ArrayList<String> vec = myfile.getContents(myfile.fileName);
				
				TreeMap<String,Integer> occTemp = new TreeMap<String,Integer>();

				ArrayList<Pair<String,wordAttributes>> ans = new ArrayList<Pair<String,wordAttributes>>();

				String s;
				int n = vec.size();
				for (int i = 0;i < n;i++)
				{
					s = word.pipeline(vec.get(i));
					if (word.isOK(s))
					{
						if (occTemp.containsKey(s)) occTemp.put(s,occTemp.get(s)+1);
						else occTemp.put(s,1);
					};
				}
				
				for(Map.Entry<String,Integer> entry : occTemp.entrySet()) {
					  String key = entry.getKey();
					  Integer value = entry.getValue();
					  wordAttributes att = new wordAttributes();
					  att.setOccurence(value);
					  Pair<String,wordAttributes> pair = new Pair<String,wordAttributes>(key,att); 
					  ans.add(pair);
					}

				return ans ;
		}
		

	public static void indexFile(file fileToBeIndexed) throws Exception
	{
			ArrayList<Pair<String,wordAttributes>> stat = new ArrayList<Pair<String,wordAttributes>>();
			stat = engine.analyze(fileToBeIndexed);
			String name = fileToBeIndexed.getFileName();
			
			int fileId = myindex.getfileId(name);
			if (fileId != -1)
			{
				return;
			}
			else
			{
				fileId = myindex.pushfile(name);
			}
				
			for (int i = 0;i<stat.size();i++)
			{
				myindex.push((stat.get(i)).getL(),fileId,(stat.get(i)).getR());
			}
	}
	
	public static void indexPath(String path) throws Exception 
	{
		try (Stream<Path> walk = Files.walk(Paths.get(path)))
		{
		ArrayList<String> result = (ArrayList<String>) walk.map(x -> x.toString())
				.filter(f -> f.endsWith(".txt")).collect(Collectors.toList());
		
		for(int i=0; i<result.size();i++) {
			text txt= new text(result.get(i));
			txt.setFilename(result.get(i));
			engine.indexFile(txt);
			}
		} 
	
		catch (IOException e) {
			e.printStackTrace();	
		}
	
	}
	
	public static ArrayList<Pair<String,wordAttributes>> findWordInIndex(String s)
	{
	String w = word.pipeline(s);
	ArrayList<Pair<String,wordAttributes>> l = new ArrayList<Pair<String,wordAttributes>> (myindex.searchWord(w));
	return l ;
	}
	
	/*public void searchnew(String s) 
	{	
		String w = word.pipeline(s);
		ArrayList<Pair<Integer,wordAttributes>> ls= new ArrayList<Pair<Integer,wordAttributes>> (myindex.searchWord(w));
		for(int j =0;j<ls.size();j++)
		{	String ch = new String();
				ch =    myindex.getfileNameFromID(ls.get(j).getL());
	
			 System.out.println(ch);
		}
		}*/
	
	
	
	
	
	//search for a phrase
	public void search(String phrase) 
	{	
	
		TreeMap<String,ArrayList<Pair<String,wordAttributes>>> searchResault
		= new TreeMap<String,ArrayList<Pair<String,wordAttributes>>>(); 
		
		
		ArrayList<String> listOfWords = new ArrayList<String>();
		StringTokenizer multiTokenizer = new StringTokenizer(phrase, " ://.-%+()[]$<>*'!?\\#;~,€{}") ;
		 while (multiTokenizer.hasMoreTokens())
		 {	
			 	String words = new String(multiTokenizer.nextToken());
			 	if (word.isOK(words)) {
			 	words=word.pipeline(words);
		        listOfWords.add(words);
		        }
		 }
		
		for(int i=0; i<listOfWords.size();i++)
		{	String w = new String();
			w=listOfWords.get(i);
			ArrayList<Pair<String,wordAttributes>> vec = new ArrayList<Pair<String,wordAttributes>>();
			vec= engine.findWordInIndex(w);
			searchResault.put(w, vec);
		}
		
		
		System.out.println("------result------");
		System.out.println("----search for---- : "+phrase);
		//ArrayList<String> result = new ArrayList<String>();
		//result = myRanker.search(s,searchResault);
	

		   for (Map.Entry<String,ArrayList<Pair<String,wordAttributes>>> entry : searchResault.entrySet()) {
		        String k = entry.getKey();
		        ArrayList<Pair<String,wordAttributes>> v = entry.getValue();
		  	  
				  for(int i=0; i<v.size();i++) {
					  System.out.print (k + " => ");
					  System.out.println(v.get(i).getL());
					}
		   }
		
		
	}

	
	public final void saveIndex() throws IOException
	{
		myindex.save();
	}
	public final void loadIndex()
	{
		myindex.load();
	}

}
