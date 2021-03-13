package day5;

public class Q49 {
public static void main(String[] args) {
	
	Box b = new Box( 2, 3, 4);
	System.out.println("Volume of the box is : " + b.volume());
}
}

class Box{
	int l, b, h;
	
	public Box(int l, int b, int h) {
		this.l = l;
		this.b = b;
		this.h = h;
	}
	
	public int volume() {
		return l*b*h;
	}
}
