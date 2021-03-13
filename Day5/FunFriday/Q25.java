package day5;

public class Q25 {
public static void main(String[] args) {
	int a,b,c;
	
	a=10;
	b=20;
	c=19;
	
	if(a>b && a>c)
		System.out.println("A is the largest");
	else if(b>c && b>a)
		System.out.println("B is the largest");
	else
		System.out.println("C is the largest");
	
}

}
