package search;
import com.sun.tools.javac.util.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Index{
    protected static Container index;
    protected static Container subContainer;
    private static TreeMap<String, Integer> fileIdList = new TreeMap<String, Integer>();
    private static TreeMap<Integer, String> fileIdListInverse = new TreeMap<Integer, String>();

    public static int pushfile(String f){
        int fileNbs = (int)(Index.fileIdList).size();
        fileIdList.put(f, fileNbs);
        fileIdListInverse.put(fileNbs, f);
        return fileNbs;
    }
    public static int getfileId(String s){
        if (fileIdList.containsKey(s))
        {
            return fileIdList.get(s);
        }
        else
        {
            return -1;
        }

    }
    public final String getfileNameFromID(Integer fileId){
        if (fileIdListInverse.containsKey(fileId))
        {
            return fileIdListInverse.get(fileId);
        }
        else
        {
            return "";
        }

    }
    public static void push(String w, int fileId,wordAttributes att){
        if(index.contains(w)){
            //overwrite if file existed
            ((Container) index.get(w)).insert(fileId,subContainer);
        }
        else {
            Container x = subContainer;
            x.insert(fileId,att);
            index.insert(w,x);
        }

    }
    public void push(String w, String fileName, wordAttributes att){
        int fileId = getfileId(fileName);
        if(fileId == -1)fileId = pushfile(fileName);
        push(w,fileId,att);
    }
    
    
    
    public  ArrayList<Pair<String,wordAttributes>> searchWord(String searchWord){
        ArrayList<Pair<String,wordAttributes>> response = new ArrayList<>();
        if(index.contains(searchWord)){
            Container filesContainWord = ((Container)index.get(searchWord));
            for(Object i:filesContainWord.KeySet()){
                int fileId = ((Integer) i);
                String s = getfileNameFromID(fileId);
                response.add(new Pair<String, wordAttributes> (s, ((wordAttributes) filesContainWord.get(i)) )  );
            }
        }
        return response;
    }
    public void push(String w, int fileId){
        w = word.pipeline(w);
        if(word.isOK(w))return;
        if(index.contains(w)){
            Container subC = ((Container) index.get(w));
            if(subC.contains(fileId)){
                ((wordAttributes) subC.get(fileId)).add();
            }else {
                wordAttributes att = new wordAttributes();
                subC.insert(fileId,att);
            }

        }
        else{
            Container subC = subContainer;
            wordAttributes att = new wordAttributes();
            subC.insert(fileId,att);
            index.insert(w,subC);

        }
    }
    public void push(String w,String fileName){
        int fileId = getfileId(fileName);
        if(fileId == -1)fileId = pushfile(fileName);
        push(w,fileId);
    }
    public void save() throws IOException {
        FileWriter mainIndexFile = new FileWriter("mainIndex");
        FileWriter fileIdsFile = new FileWriter("fileIds");

        PrintWriter printmainIndex = new PrintWriter(mainIndexFile);
        PrintWriter printfileIds = new PrintWriter(fileIdsFile);


        for(Object i : index.KeySet()){
            String s = ((String) i);
            Container subC = ((Container) index.get(s));
            int n  = subC.size();
            printmainIndex.print(s);
            printmainIndex.print('\t');
            printmainIndex.print(n);
            printmainIndex.print('\t');

            for(Object j: subC.KeySet()){
                int fileId = ((Integer) j);
                wordAttributes att = ((wordAttributes) subC.get(j));
                printmainIndex.print(fileId);
                printmainIndex.print('\t');
                printmainIndex.print(att);
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
    public void load(){

    }
    

}
