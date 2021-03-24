package day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionDemo2 {
public static void main(String[] args) {
	Vector<String> v = new Vector<>();
	
	v.add("Aishu");
	v.add("Nalli");
	v.add("Potter");
	
	Iterator<String> it = v.iterator();
	//v.add("Lily");
	
	System.out.println(it);
	
	while(it.hasNext())
		System.out.println(it.next());
	
	Enumeration<String> e = v.elements();
	
	v.add("Lily");
	
	while(e.hasMoreElements())
		System.out.println(e.nextElement());
	
	LinkedList<String> l = new LinkedList<String>();
	l.add("AAA");
	l.add("BBBB");
	l.add("CCC");
	
	Iterator<String> it2 = l.iterator();
	
	while(it2.hasNext())
		System.out.println(it2.next());
}
}
