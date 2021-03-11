package day4;

import java.util.Scanner;

public class Q24 {
public static void main(String[] args) {
	
	Scanner myObj=new Scanner(System.in);
	
	QuadraticEquation eq1=new QuadraticEquation();
	
	System.out.println("The value of a is "+ eq1.getA());
	System.out.println("The value of b is "+ eq1.getB());
	System.out.println("The value of c is "+ eq1.getC());
	System.out.println();
	
	eq1.modifyValues(5, 7, 8);
	
	System.out.println("The value of a is "+ eq1.getA());
	System.out.println("The value of b is "+ eq1.getB());
	System.out.println("The value of c is "+ eq1.getC());
	System.out.println();
	
	
	QuadraticEquation eq2=new QuadraticEquation(3,4,5);
	
	System.out.println("The value of a is "+ eq2.getA());
	System.out.println("The value of b is "+ eq2.getB());
	System.out.println("The value of c is "+ eq2.getC());
	System.out.println();
	
	System.out.println("Enter the value of x: ");
	int x=myObj.nextInt();
	System.out.println("Value of F(x) is "+ eq2.Evaluate(x)); 
	
	
	
	
}
}

class QuadraticEquation{
	private int a;
	private int b;
	private int c;
	public QuadraticEquation() {
		a=1;
		b=1;
		c=1;		
	}
	
	public QuadraticEquation(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
	
	public void modifyValues(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public int Evaluate(int x) {
		return a*x*x+b*x+c;
	}
}
