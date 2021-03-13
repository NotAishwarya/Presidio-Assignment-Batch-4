package day5;

import java.util.Scanner;

public class Q38 {
public static void main(String[] args) {
Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the number");
	int num = myObj.nextInt();
	int a = 0, b = 1, temp;
	
	int i = 1;
	while(i++ <= num) {
		
		System.out.print(a + " ");
		temp = b;
		b = a + b;
		a = temp;
	}
	
	myObj.close();
}
}
