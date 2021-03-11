package lab2;

public class Q12 {
public static void main(String[] args) {
	WiproTechnologies wT = new WiproTechnologies();
	WiproInfoTech wIT = new WiproInfoTech();
	WiproBPO wBPO = new WiproBPO();
	
	Wipro wiproArr[]=new Wipro[] {wT,wIT,wBPO};
	
	for(int i =0;i<wiproArr.length;i++)
		wiproArr[i].displayCEO();
	
}
}

class Wipro{
	public void displayCEO() {
		System.out.println("CEO of wipro is : x");
	}
}

class WiproTechnologies extends Wipro{
	public void display() {
		System.out.println("CEO of wipro tech is : y");
	}
}

class WiproInfoTech extends Wipro{
	public void display() {
		System.out.println("CEO of wipro Info Tech is : z");
	}
}

class WiproBPO extends Wipro{
	public void display() {
		System.out.println("CEO of wipro BPO is : l");
	}
}

