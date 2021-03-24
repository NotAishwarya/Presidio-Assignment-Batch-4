package day13;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionDemoMaps {
public static void main(String[] args) {
	
	Map<Emp, String> map = new TreeMap<Emp, String>((o1,o2)->{return o1.compareTo(o2);});
	map.put(new Emp(300), "aaaa");
	map.put(new Emp(200), "bbbb");
	map.put(new Emp(500), "cccc");
	
	System.out.println(map);
	
	Set<Map.Entry<Emp, String>> s =map.entrySet();
	System.out.println(s);
	
	Iterator<Map.Entry<Emp, String>> it = s.iterator();
	while(it.hasNext()) {
		Map.Entry<Emp, String> me = it.next();
		System.out.println(me.getKey() + ": " + me.getValue());
	}
	
}
}

class Emp implements Comparable<Emp>{
	Integer empId;
	public Emp(Integer empId) {
		// TODO Auto-generated constructor stub
		this.empId = empId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + empId;
	}

	@Override
	public int compareTo(Emp o) {
		// TODO Auto-generated method stub
		return o.empId.compareTo(empId);
	}
}
