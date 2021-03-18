package Q5Package;

import day9.Q5;

public class Q5Check {
public static void main(String[] args) {
InterfaceImplementation i = new InterfaceImplementation();
i.ip1();
i.ip2();
}
}

class InterfaceImplementation implements Q5{

	@Override
	public void ip1() {
		// TODO Auto-generated method stub
		System.out.println("ip1 called");
		
	}

	@Override
	public void ip2() {
		// TODO Auto-generated method stub
		System.out.println("ip2 called");
		
	}
	
}
