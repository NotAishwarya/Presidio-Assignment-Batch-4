package day4;

public class Q23 {
public static void main(String[] args) {
	Q23 q23=new Q23();
	q23.proDataClassNumManipulator();
}

public void proDataClassNumManipulator() {
	ProDataClass p=new ProDataClass();
	p.displayNum();
	
	p.num=5;
	
	p.displayNum();
	
}

}

class ProDataClass{
	protected int num;
	
	public ProDataClass() {
		num=10;
	}
	
	public void displayNum() {
		System.out.println(num);
	}
}
