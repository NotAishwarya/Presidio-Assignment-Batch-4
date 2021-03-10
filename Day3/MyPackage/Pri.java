package MyPackage;

private class Base1{
	Base1(){
	     int i = 100;     
	     System.out.println(i);
	     }

}

public class Pri extends Base1 {
	static int i = 200;
	public static void main(String argv[]){
	        Pri p = new Pri();
	        System.out.println(i);
	        }

}
