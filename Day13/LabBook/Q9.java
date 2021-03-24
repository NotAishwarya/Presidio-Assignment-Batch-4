package day13;

import java.util.*;
/*
 * Answer - A, D, C, F;
 * 
 */
public class Q9 {
	public static void main(String[] args) {
		Object o = new Object();
		// insert code here
		LinkedHashSet s = new LinkedHashSet();
		s.add("o");
		s.add(o);
		
		Iterator it = s.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}