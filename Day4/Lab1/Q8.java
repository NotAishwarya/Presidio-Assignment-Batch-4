package day4;

public class Q8 {
public static void main(String[] args) {
	int arr[]=new int[] {1,2,3,4,5,6};
	
	int locationOfVariable=5;
	
	boolean found=false;
	
	for(int i=0;i<arr.length;i++) {
		if(arr[i]==locationOfVariable) {
			System.out.println("Index of the variable is "+i);
			found=true;
			break;
		}
	}
	if(!found)
		System.out.println("Not found");
}

}
