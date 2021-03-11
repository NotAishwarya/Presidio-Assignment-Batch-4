package day4;

public class Q25 {

}
//Illegeal modifier for the class base. only public, abstract and final are permitted.
protected class base {
	String Method() {
		return "Wow";
	}
}

class dervied {
	
public void useD() {
base z = new base();
System.out.println("base says, " + z.Method());
}

}