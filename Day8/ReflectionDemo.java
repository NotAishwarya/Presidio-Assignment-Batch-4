package Day8;

import java.lang.reflect.*;

public class ReflectionDemo {
public static void main(String[] args) throws Exception {
	Paitent poirot = new Paitent();
	Therapist Bouc = new Therapist();
	
	Bouc.introspect(poirot);
}
}

class Therapist{
	public void introspect (Object p) throws Exception{
		
		//public property access.
		Class c = p.getClass();
		Field f = c.getField("name");
		System.out.println(f.get(p));
		
		//Public method access
		Method m = c.getMethod("talkGeneralStuffs");
		m.invoke(p);
		
		//Access secrets:
		f = c.getDeclaredField("secret");
		f.setAccessible(true);
		System.out.println(f.get(p));
		
		m = c.getDeclaredMethod("talkSecrets");
		m.setAccessible(true);
		m.invoke(p);
		
	}
}


class Paitent{
	public String name="Hercule Poirot";
	private String secret="Not telling you!";
	
	public void talkGeneralStuffs() {
		System.out.println("Talks about general things....");
	}
	
	private void talkSecrets() {
		System.out.println("Talks secrets......");
	}
}