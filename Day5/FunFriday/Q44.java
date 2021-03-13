package day5;

import java.util.Arrays;

public class Q44 {
public static void main(String[] args) {
	
	int a[] = {1,2,3,4};
	int b[] = {6,7,8,9};
	
	for(int i = 0; i < a.length; i++) {
		b[i] = b[i]^a[i];
		a[i] = b[i]^a[i];
		b[i] = b[i]^a[i];
	}
	
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(b));
}


}
