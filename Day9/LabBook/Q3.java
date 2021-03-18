package day9;


public class Q3 {
public static void main(String[] args) {
	
	FixedStack fs = new FixedStack();
	DynamicStack ds = new DynamicStack();
}
}

interface Stack{
	public void push();
	public void pop();
}

class DynamicStack implements Stack{

	@Override
	public void push() {
		// TODO Auto-generated method stub
		System.out.println("Push logic for Dynamic Stack");
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		System.out.println("Pop logic for Dynamic Stack");
	}
	
}

class FixedStack implements Stack{

	@Override
	public void push() {
		// TODO Auto-generated method stub
		System.out.println("Push logic for Fixed Stack");
		
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		System.out.println("Pop logic for Fixed Stack");
	}
	
}