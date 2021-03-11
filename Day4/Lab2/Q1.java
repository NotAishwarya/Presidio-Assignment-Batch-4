package lab2;

import java.util.Arrays;

public class Q1 {
public static void main(String[] args) {
	
	int num=5;
	
	int arr[]=new int[] {1,2,3,4};
	
	ByRef byref=new ByRef();
	
	System.out.println("Values before manipulation are:");
	System.out.println(num);
	System.out.println(Arrays.toString(arr));
	System.out.println(byref.value);
	
	Q1 q1=new Q1();
	
	q1.manipulate(num);
	q1.manipulate(arr);
	q1.manipulate(byref);
	
	System.out.println("Respective values after manipulation are:");
	System.out.println(num);
	System.out.println(Arrays.toString(arr));
	System.out.println(byref.value);
}

public void manipulate(int i) {
	i=10;
}

public void manipulate(int arr[]) {
	arr[2]=900;
}

public void manipulate(ByRef byref) {
	byref.value=50;
}

}

class ByRef{
	public int value;
	
	public ByRef() {
		this.value=5;
	}
}
