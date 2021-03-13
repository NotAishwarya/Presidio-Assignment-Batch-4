package day5;

import java.util.Scanner;

public class Q28 {
public static void main(String[] args) {
	
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter month as number");
	int month = myObj.nextInt();
	
	if(month <= 0 || month > 12)
		System.out.println("Invalid month");
	else if( (month == 11 || month ==12 )|| month == 1)
		System.out.println("Winter Season");
	else if(month >= 2 && month <= 7)
		System.out.println("Summer Season");
	else
		System.out.println("Rainy season");
	
	myObj.close();
}
}
