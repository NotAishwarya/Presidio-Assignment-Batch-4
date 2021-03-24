package day13;

import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
public static void main(String[] args) {
	Set<Student> s = new TreeSet<Student>((o1, o2)->{return o2.compareTo(o1);});
	
	s.add(new Student(345));
	s.add(new Student(500));
	s.add(new Student(600));
	s.add(new Student(200));
	
	System.out.println(s);
	
}
}

class Student implements Comparable<Student>{
	Integer marks;
	public Student(Integer marks) {
		// TODO Auto-generated constructor stub
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + this.marks;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.marks.compareTo(marks);
	}
}
