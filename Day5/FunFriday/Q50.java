package day5;

public class Q50 {
public static void main(String[] args) {
	C c = new C();
	c.methodB();
	c.methodC();
	c.methodA();
}
}

class A{
	
	public A() {
		System.out.println("I'm the constructor of A");
	}
	
	public void methodA() {
		System.out.println("Hi! This is A");
	}
}

class B extends A {
	
	public B() {
		System.out.println("I'm the constructor of B");
	}
	
	public void methodB() {
		System.out.println("Hi! This is B");
	}
}

class C extends B{
	
	public C() {
		System.out.println("I'm the constructor of C");
	}
	
	public void methodC() {
		System.out.println("Hi! This is C");
	}
}


