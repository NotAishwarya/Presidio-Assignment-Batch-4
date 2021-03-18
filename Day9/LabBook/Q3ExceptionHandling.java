package day9;

public class Q3ExceptionHandling {
	public static void main(String[] args) {
		SampleQ3 s = new SampleQ3();
		s.method1();
	}
}


class SampleQ3 {
public void method1() {
	method2();
	System.out.println("Caller");
	
}
public void method2() {
	try {
	 int i = 1/0;
	 System.out.println("YAY!");
	 System.exit(0);
	}
	catch(Exception e){ 
		System.out.println("Catch method2");
	}finally{
		System.out.println("Finally method2");
	}
}
}

/*
* If there is an exception inside the try block,
* the code below the line producing the exception is not executed.
* 
* In case 2:
* system.exit(0), exits the system. 
* Finally block is not executed in this case.
*/