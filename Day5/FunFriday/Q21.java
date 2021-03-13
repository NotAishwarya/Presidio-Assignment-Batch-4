package day5;

public class Q21 {
public static void main(String[] args) {
	boolean a = true, b = false;
	boolean	c,d,e,f,g;
			c = a | b;
			d = a & b;
			e = a ^ b;
			f = (! a & b) | (a &! b);
			g =! a;
			
			// a is : true b is false c is true d is false e is true f is true g is false
			System.out.println(" a is : " + a + " b is " + b + " c is "+ c + " d is " + d + " e is "+ e + " f is "+ f +" g is " + g);
}
}
