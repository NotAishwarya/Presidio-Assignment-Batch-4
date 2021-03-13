package day5;

public class Q26 {
public static void main(String[] args) {
	int a,b;
	
	a = 2;
	b = 5;
	
	b = b^a;
	a = b^a;
	b = b^a;
	
	System.out.println("Now a is " + a + " b is " + b);
}
}
