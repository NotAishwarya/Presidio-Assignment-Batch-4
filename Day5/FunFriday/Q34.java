package day5;

import java.util.Scanner;

public class Q34 {
public static void main(String[] args) {
	
Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the number upto which the average of odd numbers are to be calculated");
	int n = myObj.nextInt();
	
	int i = 0;
	int sum = 0;
	int total = 0;
	
	while(++i <= n) {
		if(i%2 != 0)
		{
			sum+= i;
			total++;
		}
	}
	
	if(total!=0)
		System.out.println("Average is : " + ((float)sum)/total);
	else
		System.out.println("Average is : 0");
	
	myObj.close();
}
}
