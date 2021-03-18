package day9;

import java.util.Scanner;

public class Q7ExceptionHandling {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	double  result;
	String numS,denoS;
	
	while(true) {
		System.out.println("Enter the numerator : ");
		numS = scan.next();
		System.out.println("Enter the Denominator : ");
		denoS= scan.next();
		
		if(numS.charAt(0) == 'q' || numS.charAt(0) == 'Q')
			break;
		try {
			result = ((double) Integer.parseInt(numS) )/Integer.parseInt(denoS);
			System.out.println(result);
		}catch(ArithmeticException ae) {
			System.out.println("Numerator shouldn't be 0");
		}catch(NumberFormatException ne) {
			System.out.println("Poor number format");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	scan.close();
}
}
