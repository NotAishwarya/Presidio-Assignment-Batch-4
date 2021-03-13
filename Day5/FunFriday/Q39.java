package day5;

import java.util.Scanner;

public class Q39 {
public static void main(String[] args) {
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the number whose multiplication table is to be printed");
	int num = myObj.nextInt();
	
	int i = 0;
	do {
		System.out.println(num + " X " + i + " = " + num*i);
	}while(++i <= 10);
	
	myObj.close();
}
}
