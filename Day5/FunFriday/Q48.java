package day5;

public class Q48 {
public static void main(String[] args) {
	
	AddClass aC = new AddClass(30, 40);
	aC.addResult();
	
	AddClass aC2 = new AddClass(4, 5, 8);
	aC2.addResult();
}
}

class AddClass{
	int a, b, c;
	
	{
		a = 0;
		b = 0;
		c = 0;
	}
	
	public AddClass(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public AddClass(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void addResult() {
		System.out.println(a + b + c);
	}
}