package search;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class test {

	public test() {
		
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		   engine search = new engine();
		   System.out.println("                  Welcome to SVH181 search engine               ");
	       System.out.println("---------------------------------------------------------------");
	       System.out.println("[1] :search\t[2] :index\t[3] :index a file\t\t[0] :exit");
	       System.out.println("[4] :index a path\t[5] :load index\t\t[6] :save index");
	       int i;
	       Scanner s = new Scanner(System.in);  
	       i = s.nextInt(); 
	       
	       
	       String path = new String("C:/Users/Ahmed Yassine/Desktop/corpus/test10000");
	       switch(i) {
	       case 1:
	    	  System.out.print("Enter phrase  ");
	    	  Scanner scanner = new Scanner(System. in);
	          String inputString = scanner. nextLine();
	    	  search.indexPath(path);
	    	  System.out.println("Searching...");
	 	      search.search(inputString);
	 	      break;
	       case 2:
	    	   System.out.println("Indexing...");
	    	   search.indexPath(path);
	    	   System.out.println("----------------All files in index are indexed----------------------");
	    	   search.saveIndex();
	    	   
	    	   break;
	       case 3:
	    	   System.out.print("Enter path of a file  ");
	    	   Scanner scan = new Scanner(System. in);
	           String input = scan. nextLine();
	           text ff = new text(input);
	           ff.fileName=input;
	           System.out.println("Indexing...");
	    	   search.indexFile(ff);
	    	   System.out.println("----------------File is indexed----------------------");
	    	   break;
	       case 4:
	    	  System.out.println("Indexing...");
	    	  search.indexPath(path);
	    	  System.out.println("----------------All files in index are indexed----------------------");
	    	  search.saveIndex();
	    	  
	 	      break;
	       case 6:
	    	  search.saveIndex();
	    	  System.out.println("Index in saved");
	 	      break;
	       default:
	    	   break;
	       
	     }
	      
	      
	     
	      
	      
	      
	      
	}

}

