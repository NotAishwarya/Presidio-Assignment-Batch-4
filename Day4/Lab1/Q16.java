package day4;

import java.util.Scanner;

public class Q16 {
public static void main(String[] args) {
	
	Scanner myObj=new Scanner(System.in);
	System.out.println("Enter the length of the array");
	
	int n=myObj.nextInt();
	int arr[]=new int[n];
	
	System.out.println("Enter the elements of the array");
	
	for(int i=0;i<n;i++)
		arr[i]=myObj.nextInt();
	
	System.out.println("Enter the number to be searched in the array");
	int numberToBeSearched=myObj.nextInt();
	
	int numberOfFounds=0;
	
	for(int i=0;i<n;i++) {
		if(arr[i]==numberToBeSearched)
		{
			System.out.println("Found at " + i);
			numberOfFounds++;
		}
	}
	
	if(numberOfFounds==0) {
		System.out.println("number not found in the array");
	}
	else
		System.out.println("Number of times it was found in the array is "+ numberOfFounds);
	
		
	
}
}
