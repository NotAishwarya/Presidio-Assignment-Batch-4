package day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q18 {
public static void main(String[] args) {
	
	HashMap<Integer,String> numToWord = new HashMap<Integer,String>();

	numToWord.put(1, "one");
	numToWord.put(2, "two");
	numToWord.put(3, "three");
	numToWord.put(4, "four");
	numToWord.put(5, "five");
	numToWord.put(6, "six");
	numToWord.put(7, "seven");
	numToWord.put(8, "eight");
	numToWord.put(9, "nine");
	numToWord.put(0, "zero");
	
	Scanner myObj=new Scanner(System.in);
	
	System.out.println("Enter number");
	int num=myObj.nextInt();
	
	int tempNum=num,digit;
	
	ArrayList<String> words=new ArrayList<String>();
	while(tempNum>0) {
		
		digit=tempNum%10;
		words.add(numToWord.get(digit));
		tempNum/=10;
	}
	
	System.out.print("The value of "+ num+" in words is: ");
	
	for(int i=words.size()-1;i>=0;i--) {
		System.out.print(words.get(i)+" ");
	}

}
}
