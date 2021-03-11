package day4;

import java.util.ArrayList;

import java.util.Scanner;

public class Q15 {

	public static void main(String[] args) {
		
		Q15 q15=new Q15();
		q15.primeBtwn1and100();
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter number: ");
		int number=myObj.nextInt();
		
		boolean noneOfThese=true;
		
		if(q15.Amstrong(number)) {
		System.out.println("It is an amstrong number");
		noneOfThese=false;
		}
		
		if(q15.isPerfectNumber(number)) {
			System.out.println("It is an perfect number");
			noneOfThese=false;
		}
		
		if(q15.isPal(number)) {
			System.out.println("It is an palindrome number");
			noneOfThese=false;
		}
		
		if(noneOfThese)
			System.out.println("Neither an amstrong , perfect number or a palindrome");
		
		
	}
	
	public boolean isPal(int number) {
		ArrayList<Integer> num=new ArrayList<Integer>();
		while(number>0) {
			num.add(number%10);
			number=number/10;
		}
		
		for(int i=0;i<num.size();i++) {
			if(num.get(i)!=num.get(num.size()-1-i))
				return false;
		}
		
		return true;
		
	}
	public boolean isPerfectNumber(int number) {
		int sum=0;
		for(int i=1;i<number;i++) {
			if(number%i==0)
				sum+=i;
		}
		
		return (sum==number);
	}
	public void primeBtwn1and100() {
		PrimeNumbers pn=new PrimeNumbers();
		for(int i=1;i<=100;i++) {
			pn.isPrime(i);
		}
		pn.display();
	}
	
	
	public boolean Amstrong(int number) {
		int sum=0,digit;
		int numberSafe=number;
		while(number>0) {
			digit=(number%10);
			number=number/10;
			sum+=digit*digit*digit;
		}
		
		return (sum==numberSafe);
	}
	
}


class PrimeNumbers{
	static ArrayList<Integer> PrimeNumbers=new ArrayList<Integer>();
	
	public void display() {
		for(int i:this.PrimeNumbers)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public void isPrime(int number) {
	
		if(number>=2)
		for(int i=2;i<=Math.sqrt(number);i++) {
			if(number%i==0)
			{
				return;
			}
		}
		
		PrimeNumbers.add(number);
	}
}
