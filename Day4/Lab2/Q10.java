package lab2;

public class Q10 {
public static void main(String[] args) {
	C10 c = new C10();
}
}

class A10{
	public A10() {
	System.out.println("Object of type A was created");	
	}
}

class B10{
	public B10() {
	System.out.println("Object of type B was created");	
	}
}

class C10 extends A10{
	B10 b = new B10();
}