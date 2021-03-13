package day5;

public class Q47 {
public static void main(String[] args) {
	
	int a, b, c;
	
	a = 10;
	b = 5;
	c = 25;
	
	Q47 q47 = new Q47();
	
	System.out.println("Sum of a and b is : " + q47.add(a, b));
	System.out.println("Sum of a, b and c is : " + q47.add(a, b,c));
	
}

public int add(int a, int b) {
	return a + b;
}

public int add(int a, int b, int c) {
	return a + b + c;
}
}
