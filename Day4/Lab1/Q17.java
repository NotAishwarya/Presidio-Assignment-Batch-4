package day4;

public class Q17 {

public static void main(String[] args) {
	
	//Compile Time error: Final field cannot be assigned. 
	//Aa.a=60;
	
	
	//To Access a static member in a non static method - Works fine.
	Q17 q17=new Q17();
	q17.imANonStaticMethod();
	
	
	//17 C) compile time error - Bb() constructor is not defined
	//Bb bb=new Bb();
	
}

public void imANonStaticMethod() {
	System.out.println("I am a non static method");
	imAStaticMethod();
}

public static void imAStaticMethod() {
	
	System.out.println("I am a static method");
}
}

//To modify const member
class Aa{
	static final int a=20;
}

class Bb{
	public Bb(int num) {
		System.out.println("I'm a one argument constructor");
	}
}
