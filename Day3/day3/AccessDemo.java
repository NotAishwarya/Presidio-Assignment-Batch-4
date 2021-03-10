package day3;

public class AccessDemo {

	public int pub;
	private int pri;
	protected int pro;
	int noMod;
	
	public void display() {
		System.out.println(pub);
		System.out.println(pri);
		System.out.println(pro);
		System.out.println(noMod);
	}	
}

class AccessDemoSub extends AccessDemo{
	public void display() {
		System.out.println(pub);
		//System.out.println(pri);
		System.out.println(pro);
		System.out.println(noMod);
	}
}

class AccessDemoNonSub{
	AccessDemo obj=new AccessDemo();
	public void display() {
		System.out.println(obj.pub);
		//System.out.println(obj.pri);
		System.out.println(obj.pro);
		System.out.println(obj.noMod);
	}
}
