package Day8;

import java.lang.reflect.*;

public class ReflectionDemo2 {
public static void main(String[] args) throws Exception {
	Class.forName("Day8.Demo").getConstructor().newInstance();	
	Class.forName("Day8.Demo").getConstructor(String.class).newInstance("Voldemort");
	Demo d = (Demo) Class.forName("Day8.Demo").getConstructor(int.class).newInstance(150);
	
	String result = d.test("Voldemort", 150);
	System.out.println(result);
	
	Field f[] = d.getClass().getFields();
	for(Field field : f)
		System.out.println(field.getName());
	
	System.out.println();
	
	Method m[] = d.getClass().getMethods();
	for(Method methods : m)
		System.out.println(methods.getName());
	
	System.out.println();
	
	Method testMethod = d.getClass().getMethod("test", String.class, int.class);
	result = (String) testMethod.invoke(d, "Voldemort", 200);
	System.out.println("The result is : " + result);
	
	Method m2 = d.getClass().getSuperclass().getDeclaredMethod("parent");
	m2.setAccessible(true);
	m2.invoke(d);
	
	//If there is no constructor in the parentClass, even the default one, This will throw an error.
	ParentClass p = (ParentClass) Class.forName("Day8.ParentClass").getConstructor().newInstance();
	Method pM = p.getClass().getDeclaredMethod("parent");
	pM.invoke(p);

	
	 ((Demo2) Class.forName("Day8.Demo2").newInstance()).demoTest();
	//d2.demoTest();
}
}

class Demo2{
	public void demoTest() {
		System.out.println("\nTest for Demo2");
	}
}

class ParentClass{
	public ParentClass() {
	
	}
	 void parent() {
		System.out.println("Hi! from the parent method");
	}
}

class Demo extends ParentClass{
	public String a,b,c;
	
	public Demo() {
		// TODO Auto-generated constructor stub
		System.out.println("Cons: No arg:");
	}
	
	public Demo(String name) {
		System.out.println("Cons: Name is : " + name);
	}
	
	public Demo(int age) {
		System.out.println("Cons: Age is : " + age);
	}
	
	public String test(String name, int age) {
		return "\nName is " + name + "\nAge is " + age + "\n";
	}
	
}