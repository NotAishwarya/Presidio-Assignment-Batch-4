package day4;

public class Q2 {
int i;
char a;
long l;
float f;
double d;
byte b;
boolean bool;
short s;
public static void main(String[] args) {
	Q2 q2=new Q2();
	q2.displayDefault();
}
public void displayDefault() {
	System.out.println(" int is "+ i);
	System.out.println(" char is "+ a);
	System.out.println(" long is "+ l);
	System.out.println(" float is "+ f);
	System.out.println(" double is "+ d);
	System.out.println(" byte is "+ b);
	System.out.println(" boolean is "+ bool);
	System.out.println(" short is "+ s);
	
}
}
