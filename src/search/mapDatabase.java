package search;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;



public class mapDatabase extends database {
	
	public mapDatabase(){
		super();
	}
	
	
    public TreeMap<String,ArrayList<Pair<Integer,wordAttributes>>> index =
    		new TreeMap<String,ArrayList<Pair<Integer,wordAttributes>>>();
    public TreeMap<String,ArrayList<Pair<String,wordAttributes>>> subContainer =
    		new TreeMap<String,ArrayList<Pair<String,wordAttributes>>>();
	
    

    public void push(String w, String fileName, wordAttributes att){
        int fileId = getfileId(fileName);
        if(fileId == -1)fileId = pushfile(fileName);
        push(w,fileId,att);
    }

    public void push(String w, Integer fileId,wordAttributes att){
        if(index.containsKey(w)){
        	
        	Pair<Integer,wordAttributes> pair = new Pair<Integer,wordAttributes> (fileId,att);
            index.get(w).add(pair);
       
        }
        else {
        	Pair<Integer,wordAttributes> pair = new Pair<Integer,wordAttributes> (fileId,att);
        	ArrayList<Pair<Integer,wordAttributes>> a = new ArrayList<Pair<Integer,wordAttributes>>();
        	a.add(pair);
            index.put(w,a);
        }

    }
	
	

    public void save() throws IOException {
        FileWriter mainIndexFile = new FileWriter("mainIndex.txt");
        FileWriter fileIdsFile = new FileWriter("fileIds.txt");

        PrintWriter printmainIndex = new PrintWriter(mainIndexFile);
        PrintWriter printfileIds = new PrintWriter(fileIdsFile);


        for(Object i : index.keySet()){
            String s = ((String) i);
            ArrayList<Pair<Integer,wordAttributes>> subC = new ArrayList<Pair<Integer,wordAttributes>>() ;
            subC=(index.get(s));
            int n  = subC.size();
            
            printmainIndex.print(s);
            printmainIndex.print('\t');
            printmainIndex.print(n);
            printmainIndex.print('\t');

           
       
            	for(int k =0;k<subC.size();k++) {
        	  int f = (subC.get(k)).getL();
        	  wordAttributes att= new wordAttributes();
        	  att=(subC.get(k)).getR();
        	     printmainIndex.print(f);
                 printmainIndex.print('\t');
                 printmainIndex.print(att.occurence);
                 printmainIndex.print('\t');
          }
            
          printmainIndex.print('\n');
            
           
        }
        for(Map.Entry<String,Integer> entry : fileIdList.entrySet()) {
            String filename = entry.getKey();
            Integer fileId = entry.getValue();
            printfileIds.print(filename);
            printfileIds.print('\t');
            printfileIds.print(fileId);
            printfileIds.print('\t');

        }

        printfileIds.close();
        printmainIndex.close();

    };

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	

    public  ArrayList<Pair<String,wordAttributes>> searchWord(String s){
        ArrayList<Pair<String,wordAttributes>> response = new ArrayList<Pair<String,wordAttributes>>();
        
        if(index.containsKey(s)){
        	ArrayList<Pair<Integer,wordAttributes>> listOfFiles = new ArrayList<Pair<Integer,wordAttributes>>();
        	listOfFiles=index.get(s);
            for(int i=0;i<listOfFiles.size();i++){
            	
                int fileId = listOfFiles.get(i).getL();
                String name = new String(getfileNameFromID(fileId));
                Pair<String, wordAttributes> res = new Pair<String, wordAttributes>(name,listOfFiles.get(i).getR());
            
                response.add(res);
            }
        }
        return response;
    }

}
