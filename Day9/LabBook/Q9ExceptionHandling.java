package day9;

import java.util.Scanner;

public class Q9ExceptionHandling {
public static void main(String[] args) throws NegativeMarkException {
	Scanner scan = new Scanner(System.in);
	int i = 0, total = 0, temp;
	
	System.out.println("Enter the marks of the student in 10 subjects");
	
	while(i < 10) {
		String mark = scan.next(); 
		try {
			temp =  Integer.parseInt(mark);
			
			if(temp < 0)
				throw new NegativeMarkException("This is an invalid mark");
			else if(temp > 100)
				throw new OutOfRangeMarkException("This is an invalid mark");
			
			total += temp;
			i++;
			
		}catch (NumberFormatException e) {
			System.out.println("Please Renter an integer value :");
		}catch(NegativeMarkException ngm) {
			ngm.visit(new HandlerImpl());
		}catch(OutOfRangeMarkException orm) {
			orm.visit(new HandlerImpl());
		}
	}
	
	System.out.println("Average is : " + ((double) total)/10);
}
}
abstract class MarkExceptions extends Exception{
	abstract public void visit(Handler handler);
}

class NegativeMarkException extends MarkExceptions{
	String msg;
	
	public NegativeMarkException(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}
	
	public String toString() {
		return this.msg;
	}
	
	public void visit(Handler negativeHandler) {
		negativeHandler.handle(this);
	}
}

class OutOfRangeMarkException extends MarkExceptions{
	String msg;
	
	public OutOfRangeMarkException(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}
	
	public String toString() {
		return this.msg;
	}
	
	public void visit(Handler markRangeOut) {
		markRangeOut.handle(this);
	}
}


interface Handler{
	public void handle(NegativeMarkException negativeMarkException);
	public void handle(OutOfRangeMarkException outOfRangeMark);
}

class HandlerImpl implements Handler{

	@Override
	public void handle(NegativeMarkException negativeMarkException) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a positive number");
		
	}

	@Override
	public void handle(OutOfRangeMarkException outOfRangeMark) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a mark in between 0 and 100");
		
	}
	
}
