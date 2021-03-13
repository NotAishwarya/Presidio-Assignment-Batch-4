package day5;

import java.util.Scanner;

public class Q40 {
public static void main(String[] args) {
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the number whose multiplication table is to be printed");
	int num = myObj.nextInt();
	
	boolean prime = true;
	
	if(num==1||num==0) {
		System.out.println("Neither prime nor composite");
		myObj.close();
		return;
	}
	if(num <= 2) {
		System.out.println("Number is prime");
		myObj.close();
		return;
	}
	
	for(int i = 2; i< num ;i++) {
		if(num%i == 0) {
			prime=false;
			break;
		}
	}
	
	if(prime)
		System.out.println("The Number is prime");
	else
		System.out.println("Number is composite");
	
	myObj.close();
		
	
}
}
