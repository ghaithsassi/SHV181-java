package search;

import java.util.Iterator;
import java.util.Set;

public abstract class Container{
    public abstract boolean find(Object value);
    public abstract Object get(Object Key);
    public abstract void insert(Object Key,Object Value);
    public void insert(Object Value){}
    public abstract String toString();
    public abstract int size();
    public abstract Iterator iterator();
    public abstract Set KeySet();

}