package day4;

public class Q22 {
public static void main(String[] args) {
	AB a=new AB();
	
	System.out.println(a.pub);
	
	//error a.pri is not visible
	//System.out.println(a.pri);
	
	System.out.println(a.pro);
	
	System.out.println(a.noMod);
	
	a.pubDisplay();
	
	//error a.priDisplay() is not visible
	//a.priDisplay();
	
	a.proDisplay();
	
	a.noModDisplay();
	
	
}
}

class AB{
	public int pub;
	private int pri;
	protected int pro;
	int noMod;

	public void pubDisplay() {
		System.out.println("Public display");
	}
	
	private void priDisplay() {
		System.out.println("Public display");
	}
	
	protected void proDisplay() {
		System.out.println("Public display");
	}
	
	 void noModDisplay() {
		System.out.println("Public display");
	}
	
}