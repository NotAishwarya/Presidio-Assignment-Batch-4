package lab2;

public class Q9 {

}

class A{
	public int aPub;
	private int aPri;
	protected int aPro;
	
	public void aPubMet() {
		
	}
	
	private void aPriMet() {
		
	}
	
	protected void aProMet() {
		
	}
}


class B extends A{
	public int bPub;
	private int bPri;
	
	public void Observe() {
		
		System.out.println(aPub);
		//Error
		//System.out.println(aPri);
		System.out.println(aPro);
		
		
		aPubMet();
		// Error: aPriMet();
		aProMet();
		
	}
	
}