package lab2;

public class Q7 {
public static void main(String[] args) {
	finalDemo fd = new finalDemo();
	
	
	//Error - remove final modifier of i
	fd.i=15;
}
}

class finalDemo{
	public final int i = 10;
}