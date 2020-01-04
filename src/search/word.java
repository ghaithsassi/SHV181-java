package search;

// class word is OK 

public class word {
	public String name;
	
	public word() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getWord(String s)
	{
		return s;
	}
	public static String pipeline(String s)
	{
		return s.toLowerCase();
	}
	public final boolean compare(word s)
	{
		return false;
	}
	public final boolean compare(String s)
	{
		return (name.equals(s));
	}
	public static boolean isOK(String s)
	{
		return ((int)s.length() > 2);
	}
}
