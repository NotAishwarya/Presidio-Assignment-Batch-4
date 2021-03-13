package day5;

public class Q51 {
public static void main(String[] args) {
	
	Child c = new Child();
	c.print(121005005);
	
}
}

class Parent{
	public void print(int n) {
		System.out.println(n);
	}
}

class Child extends Parent{
	public void print(int n) {
		super.print(n);
	}
}