package day5;

import java.util.Scanner;

public class Q33 {
public static void main(String[] args) {
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the number upto which even numbers are to be printed");
	int n = myObj.nextInt();
	
	int i = 0;
	
	while(i++ <= n) {
		if(i%2 == 0)
			System.out.print( i + " ");
	}
	
	myObj.close();
}
}
