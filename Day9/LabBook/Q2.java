package day9;

import java.lang.reflect.*;

public class Q2 {
public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
	
	Shape3D sphere = new Sphere(30);
	sphere.volume();
	sphere.area();
	sphere.surfaceArea();
	
	Shape3D cuboid = new Cuboid(4);
	cuboid.area();
	cuboid.volume();
	
	Shape2D triangle = new Triangle(5, 6, 7);
	triangle.area();
	triangle.perimeter();
	
	
}
}

abstract class Shape2D implements CalcAreaAndPerimenter { }
abstract class Shape3D implements CalcAreaAndPerimenter , CalcVolume, CalcSurfaceArea { }

interface CalcAreaAndPerimenter{
	public void area();
	public void perimeter();
}

interface CalcSurfaceArea{
public void surfaceArea();	
}

interface CalcVolume{
	public void volume();
}

class Circle extends Shape2D{

	private double r;
	
	public Circle(double r) {
		// TODO Auto-generated constructor stub
		this.r = r;
	}
	public double getRadius() {
		return this.r;
	}
	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("Area is : " + (Math.PI)*r*r );
	}

	@Override
	public void perimeter() {
		// TODO Auto-generated method stub
		System.out.println("Perimeter is : " + (Math.PI)*2*r);	
	}
}

class Triangle extends Shape2D{
	
	private double a1, a2, a3, s;
	
	public Triangle(double a1, double a2, double a3) {
	// TODO Auto-generated constructor stub
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		
		this.s = (a1 + a2 + a3)/2;
		
		
	}
	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("The area of the triangle is : " + Math.sqrt(s*(s - a1)*(s - a2)*(s - a3)));
	}

	@Override
	public void perimeter() {
		// TODO Auto-generated method stub
		System.out.println("The perimeter of the triangle is : " + (s*2));
		
	}
	
}


class Square extends Shape2D{

	private double a;
	
	public Square(double a) {
		// TODO Auto-generated constructor stub
		this.a = a;
	}
	public double getSide() {
		return a;
	}
	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("Area is : " + a*a );
	}

	@Override
	public void perimeter() {
		// TODO Auto-generated method stub
		System.out.println("Perimeter is : " + 4*a);	
	}
}

class Sphere extends Shape3D{
	
	Circle c;
	public Sphere(double r) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated constructor stub
		c = new Circle(r);
		
	}

	@Override
	public void volume() {
		// TODO Auto-generated method stub
		System.out.println("Volume is : " + (4/3)*Math.PI*c.getRadius()*c.getRadius()*c.getRadius());
		
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		c.area();
		
	}

	@Override
	public void perimeter() {
		// TODO Auto-generated method stub
		c.perimeter();
		
	}

	@Override
	public void surfaceArea() {
		// TODO Auto-generated method stub
		System.out.println("Surface Area is : " + 4*Math.PI*c.getRadius()*c.getRadius());
	}	
}

class Cuboid extends Shape3D{
	private Square s;
	
	public Cuboid(double a) {
		// TODO Auto-generated constructor stub
		s = new Square(a);
	}
	@Override
	public void area() {
		// TODO Auto-generated method stub
		s.area();
		
	}

	@Override
	public void perimeter() {
		// TODO Auto-generated method stub
		s.perimeter();
		
	}

	@Override
	public void volume() {
		// TODO Auto-generated method stub
		System.out.println("Volume is : " + s.getSide()*s.getSide()*s.getSide());
		
	}

	@Override
	public void surfaceArea() {
		// TODO Auto-generated method stub
		System.out.println("Surface Area is : " + 6*s.getSide()*s.getSide());
		
		
	}
	
}


