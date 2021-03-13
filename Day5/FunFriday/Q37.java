package day5;

import java.util.Scanner;

public class Q37 {
public static void main(String[] args) {
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the number");
	int num = myObj.nextInt();
	
	int sum = 0;
	
	while(num>0) {
		sum+=num%10;
		num/=10;
	}
	
	System.out.println(sum);
	
	myObj.close();
}
}
