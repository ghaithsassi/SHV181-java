package search;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class mapContainer extends Container {
    private Map  myContainer;
    mapContainer(){
        myContainer = new TreeMap();
    }
    mapContainer(mapContainer other){
        myContainer = new TreeMap();
    }
    public Object get(Object key){
        return myContainer.get(key);
    }
    public void insert(Object key,Object value){
        myContainer.put(key,value);
    }
    public String toString(){
        return myContainer.toString();
    }
    public boolean find(Object Value){
        return myContainer.containsValue(Value);

    }
    public int size(){
        return myContainer.size();
    }
    public Iterator iterator(){
        return myContainer.entrySet().iterator();
    }
    public Set KeySet(){
        return myContainer.keySet();
    }
}

