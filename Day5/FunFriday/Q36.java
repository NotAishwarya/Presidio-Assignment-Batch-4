package day5;

import java.util.Scanner;

public class Q36 {
public static void main(String[] args) {
	Scanner myObj = new Scanner(System.in);
	
	System.out.println("Input the number or the string : ");
	String s = myObj.next();
	
	Q36 q36 = new Q36();
	
	if(q36.isPal(s))
		System.out.println(s + "is a palindrome");
	else
		System.out.println(s + "is not a palindrome");
	
	System.out.print("Reverse is ");
	for(int i = s.length() -1 ; i>=0 ;i--)
		System.out.print(s.charAt(i) + "");
	
	myObj.close();
	
}

public boolean isPal(String s) {
	int i =0;
	while((i<s.length()/2) && s.charAt(i) == s.charAt(s.length()-i-1)) {
		i++;
	}
	if(i==s.length()/2)
		return true;
	return false;
}
}
