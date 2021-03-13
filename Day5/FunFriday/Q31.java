package day5;

import java.util.Scanner;

public class Q31 {
public static void main(String[] args) {
	
Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the two numbers");
	int a = myObj.nextInt();
	int b = myObj.nextInt();
	
	System.out.println("Enter \n 1 for addition \n 2 for subtraction \n 3 for division \n 4 for multiplication:");
	int operation = myObj.nextInt();
	
	switch(operation) {
	case 1:
		System.out.println(a+b);
		break;
	case 2:
		System.out.println(a-b);
		break;
	case 3:
		System.out.println(a/b);
		break;
	case 4:
		System.out.println(a*b);
		break;
	default:
		System.out.println("Invalid operation");
	}
	
	myObj.close();
}
}
