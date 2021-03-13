package day5;

public class Q43 {
public static void main(String[] args) {
	
	int arr[] = {1,34,546,8,9};
	
	Q43 q43 = new Q43();
	
	System.out.println("Lowest vaue = " + q43.lowest(arr) );
	System.out.println("Greates value = " + q43.biggest(arr));
}

public int lowest(int arr[]) {
	
	int lowest = Integer.MAX_VALUE;	
	for(int i: arr) {
		if(i < lowest)
			lowest = i;
	}
	return lowest;
}

public int biggest(int arr[]) {
	
	int largest = Integer.MIN_VALUE;
	for(int i: arr) {
		if(i > largest)
			largest = i;
	}
	return largest;
}


}
