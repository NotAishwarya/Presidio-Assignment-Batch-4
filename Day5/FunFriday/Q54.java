package day5;

public class Q54 {
public static void main(String[] args) {
	X x = new X();
	x.printInt(5);
}
}

interface InterfaceDemo{
	public void printInt(int n);
}

class X implements InterfaceDemo{
	public void printInt(int n) {
		System.out.println(n);
	}
}