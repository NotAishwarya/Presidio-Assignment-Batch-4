package day4;

public class Q27 {
public static void main(String[] args) {
	Bank bankObj = new Bank();
	System.out.println("The initial amount is "+ bankObj.getAmount());
	
	//First year passes
	bankObj.firstYear();
	System.out.println("The Amount after First year is "+ bankObj.getAmount());
	
	//Second year passes
	bankObj.secondYear();
	System.out.println("The Amount after Second year is "+ bankObj.getAmount());
	
	//After third year
	bankObj.thirdYear();
	System.out.println("The Amount after Third year is "+ bankObj.getAmount());
	

}
}


class Bank{
	private int investment;
	private int currentAmount;
	
	public Bank(){
		this.investment=14000;
		this.currentAmount=this.investment;
	}
	
	public int getAmount() {
		return currentAmount;
	}
	
	public void firstYear() {
		currentAmount+=(currentAmount*40)/100;
	}
	
	public void secondYear() {
		currentAmount-=1500;
	}
	
	public void thirdYear() {
		currentAmount+=(currentAmount*12)/100;
	}
	
}
