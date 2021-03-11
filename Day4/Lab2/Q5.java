package lab2;

public class Q5 {

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
	}
}

class A{
	static int count;
	
	public A() {
		System.out.println("Constructor called");
		System.out.println("Number of objects created until now: " + ++count);
	}
}