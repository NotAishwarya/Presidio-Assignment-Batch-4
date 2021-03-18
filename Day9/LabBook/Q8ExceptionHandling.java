package day9;

import java.util.Scanner;

public class Q8ExceptionHandling {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int i = 0, total = 0, temp;
	
	System.out.println("Enter the marks of the student in 10 subjects");
	while(i++ < 10) {
		String mark = scan.next(); 
		try {
			temp =  Integer.parseInt(mark);
			total += temp;
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Please Renter an integer value :");
			i--;
		}
	}
	
	System.out.println("Average is : " + ((double) total)/10);
}
}
