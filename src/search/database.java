package search;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

//class database is NOT OK 

public abstract class database {

	public TreeMap<String,Integer> fileIdList = new TreeMap<String,Integer>(); 
	public TreeMap<Integer,String> fileIdListInverse = new TreeMap<Integer,String>(); 
	Collection<?> index;
	
	public final int pushfile(String f)
	{
		int fileNbrs = this.fileIdList.size();
		fileIdList.put(f, fileNbrs);
		fileIdListInverse.put(fileNbrs, f);
		return fileNbrs;
	}
	
	public final int getfileId(String s)
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
	
	public final String getfileNameFromID(Integer s)
	{
		String it = fileIdListInverse.get(s);
		
		if (it != fileIdListInverse.get(fileIdListInverse.lastKey()))
		{
			return (fileIdListInverse.get(fileIdListInverse.lastKey()));
		}
		else
		{
			return "";
		}
	}
	public abstract void push(String UnnamedParameter, String UnnamedParameter2);
	public abstract void push(String UnnamedParameter, int UnnamedParameter2);
	public abstract void push(String UnnamedParameter, String UnnamedParameter2, wordAttributes UnnamedParameter3);

	public abstract ArrayList<Pair<String,wordAttributes>> searchWord(String UnnamedParameter);
	
	public abstract void push(String w, int fileId, wordAttributes att);
	public abstract void save();
	public abstract void load() ;
	public abstract void print();
	
}



