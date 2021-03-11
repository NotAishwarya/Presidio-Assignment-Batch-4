package lab2;

public class Q11 {
public static void main(String[] args) {
	C11 c = new C11();
}
}
class A11{
	int a;
	public A11(int i) {
	System.out.println("Object of type A was created");	
	}
}

class B11{
	int b;
	public B11(int i) {
	System.out.println("Object of type B was created");	
	}
}

class C11 extends A11{
	public C11() {
		super(5);
		B11 b = new B11(5);
	}
}