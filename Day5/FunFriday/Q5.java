package day5;



public class Q5 {
public static void main(String[] args) {

	int total =0;
	
	for(int i=1;i<=4;i++) {
		for(int j=1;j<=4;j++) {
			for(int k=1;k<=4;k++) {
				if(k!=i && k!=j && j!=i) {
					System.out.println(i + "" + j + "" + k);
					total++;
				}
			}
		}
	}
	
	System.out.println("Total number of Unique elements : " + total);
}
}
