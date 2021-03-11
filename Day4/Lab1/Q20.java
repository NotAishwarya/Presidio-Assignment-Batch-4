package day4;

public class Q20 {
public static void main(String[] args) {
	int arr[][]= {
			{1,2,3,4,5,6},
			{4,5,6,11,43},
			{56,34,25,666}
	};
	
	for(int i=0;i<arr.length;i++) {
		int largest=Integer.MIN_VALUE;
		for(int j=0;j<arr[i].length;j++) {
			if(arr[i][j]>largest)
				largest=arr[i][j];
		}
		
		System.out.println("The largest number of row "+ i +" is "+ largest);
	}
}
}
