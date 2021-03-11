package day4;

import java.util.Scanner;

public class Q21 {
	
public static void main(String[] args) {
	Scanner myObj=new Scanner(System.in);
	
	System.out.println("Enter the month as a number");
	int month=myObj.nextInt();
	System.out.println("Enter the year");
	int year=myObj.nextInt();
	
	int numberOfDaysInTheMonth=0;
	switch(month) {
		case 1:
			numberOfDaysInTheMonth=31;
			break;
		case 2:
			numberOfDaysInTheMonth=28;
			if(year%4==0)
				numberOfDaysInTheMonth=29;
			break;
		case 3:
			numberOfDaysInTheMonth=31;
			break;
		case 4:
			numberOfDaysInTheMonth=30;
			break;
		case 5:
			numberOfDaysInTheMonth=31;
			break;
		case 6:
			numberOfDaysInTheMonth=30;
			break;
		case 7:
			numberOfDaysInTheMonth=31;
			break;
		case 8:
			numberOfDaysInTheMonth=31;
			break;
		case 9:
			numberOfDaysInTheMonth=30;
			break;
		case 10:
			numberOfDaysInTheMonth=31;
			break;
		case 11:
			numberOfDaysInTheMonth=30;
			break;
		case 12:
			numberOfDaysInTheMonth=31;
			break;
			
	}
	
	if(numberOfDaysInTheMonth==0)
		System.out.println("You have inputed a wrong month");
	else
		System.out.println("Number of Days in the month is "+ numberOfDaysInTheMonth);
}
}
