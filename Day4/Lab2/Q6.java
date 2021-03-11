package lab2;

public class Q6 {

	public static void main(String[] args) {
	//	StaticBlockDemo.i=0;
		
		StaticBlockDemo.method();
		
	}
	
}

class StaticBlockDemo{
	
	static int i;
	
	static {
		System.out.println("I'm the static Block");
	}
	
	public StaticBlockDemo() {
		System.out.println("I'm the constructor");
	}
	
	public static void method() {
		System.out.println("I'm a method");
	}
}
