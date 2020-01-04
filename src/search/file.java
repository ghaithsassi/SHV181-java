package search;

import java.util.ArrayList;

//class file is OK 


public abstract class file {
	protected String fileName;
	public void setFilename(String filename)
	{
		this.fileName = filename;
	}
	public file(String filename)
	{
		setFilename(filename);
	}
	public String getFileName()
	{
		return fileName;
	}
	
	public abstract ArrayList<String> getContents(String filename) throws Exception;

}

