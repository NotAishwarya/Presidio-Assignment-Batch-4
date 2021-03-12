package lab2;

public class Q8 {
public static void main(String[] args) {
	Singleton singleton = Singleton.getInstance();
	singleton.display();
}
}


class Singleton{
	private static Singleton singleton;
	static {
		singleton = new Singleton();
		}
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void display() {
		System.out.println("This is the display method");
	}
	
}
