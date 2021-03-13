package day5;

public class Q46 {
public static void main(String[] args) {
	Bank46 b1 = new Bank46("Jeeves", "Savings", 30000,839390);
	b1.depositAmount(30);
	b1.display();
}
}

class Bank46{
	String nameOfDepositor, accountType;
	int accountNumber, balance;
	
	public Bank46(String nameOfDepositor, String accountType, int balance, int accountNumber) {
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
