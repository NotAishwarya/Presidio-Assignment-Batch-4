package day5;

import java.util.Scanner;

public class Q4 {
	int numLetters;
	int numChars;
	int numSpaces;
	int numNumbers;
	
public static void main(String[] args) {
	Q4 q4 = new Q4();
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter the string :");
	String s = myObj.nextLine();
	
	q4.count(s);
	q4.display();
	
}

public void count(String s) {
	
	for(int i=0;i<s.length();i++) {
		 char temp = s.charAt(i);
		 
		 if(Character.isDigit(temp))
			 numNumbers++;
		 else if(Character.isSpaceChar(temp))
			 numSpaces++;
		 else if(Character.isAlphabetic(temp))
			 numLetters++;
		 else
			 numChars++;
		 
		
	}
	
	
}

public void display() {
	System.out.println("Number of letters in the String : " + numLetters);
	System.out.println("Number of Chars in the String : " + numChars);
	System.out.println("Number of spaces in the String : " + numSpaces);
	System.out.println("Number of Integers in the String : " + numNumbers);
}
}
