package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* class text is not OK */

public class text extends file {
	public text(String s)
	{
		super(s);
	}

	public void close() {
		
	}
	public void open() {
		
	}

	public ArrayList<String> getContents(String filename) throws IOException 
	{
		
		BufferedReader bufReader = new BufferedReader(new FileReader(filename));
	    ArrayList<String> listOfLines = new ArrayList<>();

	    String line = bufReader.readLine();
	    while (line != null) {
	      listOfLines.add(line);
	      line = bufReader.readLine();
	    }

	    bufReader.close();
	    
	  
		
		return listOfLines ;
		
	}



	
}