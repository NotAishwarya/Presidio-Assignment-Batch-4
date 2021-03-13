package Q53Package;

import day5.BankClassForQ52;

public class Q52 {

	public void displayNameAndAccount(BankClassForQ52 b[]) {
		for(BankClassForQ52 bankObj : b) 
			System.out.println("Name is : " + bankObj.getName() + "\nBalance is :" + bankObj.getBalance() + "\n");
	}
}
