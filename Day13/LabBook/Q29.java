package day13;

import java.util.*;

/*
 * Replace line 13 with private Map<String, Integer> accountTotals = new HashMap<String, Integer>();
 */

public class Q29{
	public static void main(String[] args) {
		
	}
}

class AccountManager2 {
	Map<String, Integer> accountTotals = new HashMap<String, Integer>();
	private int retirementFund;

	public int getBalance(String accountName) {
		Integer total = (Integer) accountTotals.get(accountName);
		if (total == null)
			total = Integer.valueOf(0);
		return total.intValue();
	}
	public void setBalance(String accountName, int amount) {
		accountTotals.put(accountName, Integer.valueOf(amount));
	}
}
