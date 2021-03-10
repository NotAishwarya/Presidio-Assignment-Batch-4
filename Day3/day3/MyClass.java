package day3;

public class MyClass {
	//Q8 answer=0;
	 static int i;
	 public static void main(String arguments[]) { 
		 //error Can't make static reference to void amethod
         amethod(arguments);
        
         //corrected:
         /*
          *MyClass obj=new Myclass();
          *obj.amethod();
          *
          */
         
         System.out.println(i);
         } 
 public void amethod(String[] arguments) { 
         System.out.println(arguments); 
         System.out.println(arguments[1]); 
 } 
}
