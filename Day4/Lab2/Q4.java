package lab2;

public class Q4 {
public static void main(String[] args) {
	stack s = new stack(4);
	s.push(1);
	s.push(2);
	s.push(5);
	s.push(10);
	s.push(11);
	
	s.display();
	
	s.pop();
	s.pop();
	s.pop();
	
	s.display();
}
}


class stack{
	
	private int arr[];
	private int size;
	private int top=-1;
	
	public stack(int size) {
		this.size=size;
		arr = new int[size];
	}
	
	private boolean isEmpty() {
		if(top==-1)
			return true;
		return false;
	}
	
	private boolean isFul() {
		if(top==size-1)
			return true;
		return false;
	}
	
	public void push(int num) {
		if(this.isFul())
			System.out.println("Stack Overflow");
		else
			arr[++top]=num;
	}
	
	public int pop() {
		if(this.isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		
			return arr[top--];
	}
	
	public void display() {
		for(int i=0;i<=top;i++)
			System.out.println(arr[i]+" ");
		System.out.println();
	}
	
	
}
