package day4;



public class Q7 {
public static void main(String[] args) {
	int arr[]=new int[] {1,35,2,54,13,43};
	Q7 q7=new Q7();
	
	int copy[]=new int[arr.length];
	System.arraycopy(arr,0,copy,0,arr.length);
	
	q7.ascending(copy);
	q7.display(copy);
	
	
	System.arraycopy(arr,0,copy,0,arr.length);
	
	q7.descending(copy);
	q7.display(copy);
	
	
}

public void ascending(int[] arr) {
	for(int i=0;i< arr.length-1;i++) {
		for(int j=i+1;j<arr.length;j++) {
			if(arr[i]>arr[j]) {
				swap(arr,i,j);
			}
		}
	
	}
}

public void descending(int[] arr) {
	for(int i=0;i< arr.length-1;i++) {
		for(int j=i+1;j<arr.length;j++) {
			if(arr[i]<arr[j]) {
				swap(arr,i,j);
			}
		}
	
	}
}


public void swap(int[] arr,int i,int j) {
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
