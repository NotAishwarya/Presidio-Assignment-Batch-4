package day5;

import java.util.Scanner;

public class Q29 {
public static void main(String[] args) {
	
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Enter a character: ");
	char c = myObj.next().charAt(0);
	
	boolean isVowel = false;
	
	switch(c) {
	case 'a':
		isVowel = true;
		break;
	case 'e':
		isVowel = true;
		break;
	case 'i':
		isVowel = true;
		break;
	case 'o':
		isVowel = true;
		break;
	case 'u':
		isVowel = true;
		break;
	}
	
	if(isVowel)
		System.out.println("It is a vowel");
	else
		System.out.println("Not a vowel");
	
	myObj.close();
}
}
