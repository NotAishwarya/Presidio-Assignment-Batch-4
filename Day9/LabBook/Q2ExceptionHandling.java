package day9;

public class Q2ExceptionHandling {
public static void main(String[] args) {
	Sample s = new Sample();
	s.method1();
}
}

class Sample {
public void method1() {
	method2();
	System.out.println("Caller");
	
}
public void method2() {
	try {
	 int i = 1/0;
	 return;
	}
	catch(Exception e){ 
		System.out.println("Catch method2");
	}finally{
		System.out.println("Finally method2");
	}
}
}


/*
* Finally block is always called. 
* Even if there is a return statement. 
*
*/