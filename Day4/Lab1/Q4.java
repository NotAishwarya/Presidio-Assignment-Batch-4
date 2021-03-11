package day4;

import java.lang.Math; 

public class Q4 {
public static void main(String[] args) {
	primeCheck pc=new primeCheck(13);
	if(pc.isPrime()) {
		System.out.println("Prime Number");
	}
	else {
		System.out.println("Not a prime Number");
	}
	
}
}

class primeCheck{
	int number;
	public primeCheck(int number) {
		this.number=number;
	}
	
	public boolean isPrime() {
		if(this.number<=2)
			return true;
		for(int i=2;i<=Math.sqrt(this.number);i++) {
			if(this.number%i==0)
				return false;
		}
		
		return true;
	}
}
