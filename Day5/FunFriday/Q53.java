package day5;

import Q53Package.Q52;

public class Q53 {
public static void main(String[] args) {
	
	BankClassForQ52 b[] = { new BankClassForQ52("Jeeves", 200000), new BankClassForQ52(" Bertie Wooster", 303030),
							new BankClassForQ52("Gussie", 40) };
	
	Q52 q52 = new Q52();
	
	q52.displayNameAndAccount(b);
}
}
