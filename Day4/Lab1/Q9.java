package day4;

public class Q9 {
public static void main(String[] args) {
	int arr[]=new int[]{1,2,3,4,5,6,7};
	
	for(int i=0;i<(arr.length)/2;i++) {
		swap(arr,i,arr.length-i-1);
	}
	
	Q9 q9=new Q9();
	q9.display(arr);
}

public static void swap(int[] arr,int i,int j) {
	int temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
}


public void display(int[] arr) {
	for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+"\t");
	}
	System.out.println();
}
}



