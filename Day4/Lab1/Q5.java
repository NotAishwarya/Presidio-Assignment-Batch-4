package day4;

public class Q5 {
public static void main(String[] args) {
	int arr[]=new int[] {1,2,3,4,5};
	int copy[]=new int[5];
	System.arraycopy(arr,0,copy,0,arr.length);
	Q5 q5=new Q5();
	System.out.println("The average of the numbers is: "+ q5.getAvg(copy) );
}

public int getAvg(int arr[]) {
	int avg=0;
	
	for(int i=0;i<arr.length;i++)
		avg+=arr[i];
	
	return avg;
}
}
