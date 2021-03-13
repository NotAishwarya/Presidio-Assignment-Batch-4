package day5;

import java.util.Scanner;

public class Q24 {
public static void main(String[] args) {
	Scanner obj = new Scanner(System.in);
	
	System.out.println("Enter the side of the square");
	int side = obj.nextInt();
	
	System.out.println("Enter the lenght and breadth of the rectangle");
	int len = obj.nextInt();
	int breadth = obj.nextInt();
	
	Square s = new Square(side);
	Rectangle r = new Rectangle(len,breadth);
	
	System.out.println("Area and perimeter of the Square are respectively: " + s.area()+ " " + s.perimeter());
	System.out.println("Area and perimeter of the Rectangle are respectively: " + r.area()+ " " + r.perimeter());
}
}

abstract class Quadrilateral{
abstract public int area();
abstract public int perimeter();

}

class Square extends Quadrilateral{
	int side;
	
	public Square(int side){
		this.side = side;
	}
	
	public int area() {
		return side*side;
	}
	
	public int perimeter() {
		return 4*side;
	}
	
}


class Rectangle extends Quadrilateral{
	int len, breadth;
	public Rectangle(int len, int breadth) {
		this.len = len;
		this.breadth = breadth;
	}
	
	public int area() {
		return len*breadth;
	}
	
	public int perimeter() {
		return 2*(len+breadth);
	}
	
}