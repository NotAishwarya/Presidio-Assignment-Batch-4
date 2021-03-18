package day9;

public class Q4 {
public static void main(String[] args) {
	C c = new C();

	c.testI1(c);
	c.testI2(c);
	c.testI3(c);
	c.testI4(c);
	
}
}

interface I1{
	public void i1m1();
	public void i1m2();
}

interface I2{
	public void i2m1();
	public void i2m2();
}

interface I3{
	public void i3m1();
	public void i3m2();
}

interface I4 extends I1, I2, I3{
	public void i4m1();
}

class C1{
	
}

class C extends C1 implements I4{

	public void testI1(I1 i1) {
		System.out.println("First Interface passed as the argument.");
	}
	
	public void testI2(I2 i2) {
		System.out.println("Second Interface passed as the argument.");
	}
	
	public void testI3(I3 i3) {
		System.out.println("Third Interface passed as the argument.");
	}
	
	public void testI4(I4 i4) {
		System.out.println("Fourth Interface passed as the argument.");
	}
	
	@Override
	public void i1m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void i1m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void i2m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void i2m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void i3m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void i3m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void i4m1() {
		// TODO Auto-generated method stub
		
	}

	
	
}