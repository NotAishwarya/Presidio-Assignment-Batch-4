package day13;

import java.util.*;

/*
 * The output will contain a –1 (Binary search doesn't know that we have sorted the array in descending order)
 * The output will contain "pen marble map key"
 * 
 */
 public class Q24 {
	 public static void main(String[] args) {
		 String[] s = {"map", "pen", "marble", "key"};
		 Othello o = new Othello();
		 Arrays.sort(s,o);
		 for(String s2: s) System.out.print(s2 + " ");
		 System.out.println(Arrays.binarySearch(s, "map"));
	 }
 
	 static class Othello implements Comparator<String> {
		 public int compare(String a, String b) { 
			 return b.compareTo(a);
			 }
	 }
 }