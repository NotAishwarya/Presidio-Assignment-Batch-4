package day9;

public class Q4ExceptionHandling {
public static void main(String[] args) throws Exception {
	try {
		throw new MyException("This is my exception");
	}catch (MyException e) {
		// TODO: handle exception
		//e.printStackTrace();
		System.out.println(e);
	}
}
}

class MyException extends Exception{
	String msg;
	
	public MyException(String msg) {
		this.msg = msg;
	}
	public String toString() {
		return this.msg;
	}
}
