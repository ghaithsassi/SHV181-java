package search;

import java.io.IOException;
import java.util.ArrayList;

import java.util.TreeMap;

//class database is NOT OK 

public abstract class database {
	public TreeMap<String, Integer> fileIdList ;
	public TreeMap<Integer, String> fileIdListInverse ;
	public database(){
		TreeMap<String, Integer> a = new TreeMap<String, Integer>();
		TreeMap<Integer, String> b = new TreeMap<Integer, String>();
		this.fileIdList=a;
		this.fileIdListInverse=b;
	}
	

	public int pushfile(String f)
	{
		int fileNbrs = this.fileIdList.size();
		fileIdList.put(f, fileNbrs);
		fileIdListInverse.put(fileNbrs, f);
		return fileNbrs;
	}
	
	public int getfileId(String s)
	{
		
		
		if (fileIdList.containsKey(s))
		{
			return fileIdList.get(s);
		}
		else
		{
			return -1;
		}
	}
	
	public String getfileNameFromID(Integer s)
	{
	
		
		if (fileIdListInverse.containsKey(s))
		{
			return fileIdListInverse.get(s);
		}
		else
		{
			return "";
		}

	}
	
	public abstract void push(String w, String fileName, wordAttributes att);
	public abstract void push(String w, Integer fileId, wordAttributes att);
	public abstract ArrayList<Pair<String,wordAttributes>> searchWord(String s);
	
	public abstract void save() throws IOException;
	public abstract void load() ;
	public abstract void print();
	
}



