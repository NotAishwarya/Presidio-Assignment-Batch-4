package day5;

public class Q45 {
public static void main(String[] args) {
	
	Bank b = new Bank();
	
	b.initalValues("Poirot", "student", 10000, 222222);
	b.depositAmount(200);
	b.display();
}
}


class Bank{
	String nameOfDepositor, accountType;
	int accountNumber, balance;
	
	public void initalValues(String nameOfDepositor, String accountType, int balance, int accountNumber) {
		this.nameOfDepositor = nameOfDepositor;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public void depositAmount(int amount) {
		if(this.balance <= Integer.MAX_VALUE - amount)
			this.balance += amount;
		else
			System.out.println("Maximum capacity reached");
	}
	
	public void display() {
		System.out.println("Name: " + nameOfDepositor + "\nBalance: " + balance);
	}
}