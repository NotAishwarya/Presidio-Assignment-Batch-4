package day5;

import java.util.Scanner;

public class Q3 {
public static void main(String[] args) {
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter a string to be reversed : ");
	String str = myObj.nextLine();
	
	for(int i=str.length()-1; i>=0 ;i--)
		System.out.print(str.charAt(i));
	
	myObj.close();
}
}
