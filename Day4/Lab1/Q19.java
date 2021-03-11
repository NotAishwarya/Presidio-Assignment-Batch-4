package day4;

public class Q19 {
public static void main(String[] args) {
	int arr[][]= {
			{1,2,3,4,5},
			{1,4,5,6},
			{7,8,9}
	};
	
Q19 q19=new Q19();

q19.reverseRows(arr);

q19.display(arr);
}

public void reverseRows(int arr[][]) {
	for(int i=0;i<arr.length;i++) {
		for(int j=0;j<(arr[i].length)/2;j++) {
			swap(arr,i,j,arr[i].length-j-1);
		}
	}
}

public void display(int[][] arr) {
	for(int i=0;i<arr.length;i++) {
		for(int j=0;j<(arr[i].length);j++) {
			System.out.print(arr[i][j]+"\t");
		}
		System.out.println();
		}
}


public void swap(int[][] arr,int row,int i,int j) {
	//System.out.println(arr[row][i]+" "+arr[row][j]);
	int temp=arr[row][i];
	arr[row][i]=arr[row][j];
	arr[row][j]=temp;
}



}
