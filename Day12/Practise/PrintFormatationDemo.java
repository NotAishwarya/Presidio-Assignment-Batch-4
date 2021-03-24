package day12;

/*
 * %- denoting the start of the formating instructions
 * [flag]- - pad on right + pad on left
 * [width] - size of padding
 * [.precision]-this if for floating numbers.
 * d/s/f - denoting integer,string and float
 *
 */


public class PrintFormatationDemo {
public static void main(String[] args) {
	System.out.printf("%d %s" ,20 ,"coda" );
	
	System.out.printf("\nAverage mark is %.2f", 90.4535435);
	
	System.out.printf("\n%-10s %-10s %s", "column1", "coulmn2", "column3" );
}
}
