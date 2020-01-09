package search;

//class wordAttributes is OK 

public class wordAttributes {

	public int occurence = 1;
	public final int getOccurence()
	{
		return occurence;
	}
	public final void add()
	{
		occurence++;
	}
	public final void setOccurence(int o)
	{
		this.occurence = o;
	}
	public String ToString() {
		Integer o  = (Integer) occurence;
		return o.toString();
	}

}
