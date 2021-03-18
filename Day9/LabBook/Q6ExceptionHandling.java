package day9;

public class Q6ExceptionHandling {
public static void main(String[] args) throws MyException {
	Derived d = new Derived(5);
}
}

class Base{
	public Base(int i ) throws MyException {
		// TODO Auto-generated constructor stub
		throw new MyException("Base class Exception");
	}
}

class Derived extends Base{
	public Derived(int i) throws MyException {
		// TODO Auto-generated constructor stub
		try{
			super(i); //This should be in the first line. Hence we cannot use try catch here.
		}
		
	}
}