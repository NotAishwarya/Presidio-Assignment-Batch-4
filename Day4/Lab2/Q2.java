package lab2;

public class Q2 {
public static void main(String[] args) {
	
	ComplexNumber c1=new ComplexNumber(3,4);
	ComplexNumber c2=new ComplexNumber(5,6);
	
	ComplexNumber c3 = c1.complexAdd(c2);
	
	c3.display();
	
}
}


class ComplexNumber{
	int real, img;
	
	public ComplexNumber() {
		this.real=0;
		this.img=0;
	}
	
	public ComplexNumber(int real, int img) {
		this.real=real;
		this.img=img;
	}
	
	public ComplexNumber complexAdd(ComplexNumber c2) {
		
		ComplexNumber c3 = new ComplexNumber();
		
		c3.real=this.real+c2.real;
		c3.img=this.img+c2.img;
		
		return c3;
	}
	
	public void display() {
		System.out.println(this.real + " + i" + this.img);
	}
}
