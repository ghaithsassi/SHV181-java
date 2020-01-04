package search;

import java.util.ArrayList;

/* class file is OK */
//import java.util.ArrayList;

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
	public abstract void close();
	public String getFileName()
	{
		return fileName;
	}
	public abstract void open();

	public abstract ArrayList<String> getContents(String filename);

}

