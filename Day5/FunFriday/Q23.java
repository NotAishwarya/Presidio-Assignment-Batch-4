package day5;

public class Q23 {
public static void main(String[] args) {
	
	double  r,h,area;
	double energy,mass,acceleration,height,velocity;
	
	r=5;
	h=10;
	
	mass=80;
	acceleration = 10;
	height = 5;
	velocity = 20;
	
	area = (Math.PI)*r*r + 2*r*h;
	energy = mass*(acceleration*height + (velocity*velocity)/2);

	System.out.println("Area : " + area + " Energy : " + energy );
	
}
}
