package day4;

public class Q12 {
public static void main(String[] args) {
	if(args.length>=1) {
		System.out.println("The command line aruments are ");
		for(int i=0;i<args.length;i++) {
			System.out.print(args[i]+" ");
		}
	}
	else
		System.out.println("No Command line arguments");
}
}
