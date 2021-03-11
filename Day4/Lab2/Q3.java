package lab2;

public class Q3 {
public static void main(String[] args) {
	SalesPerson sp = new SalesPerson(30);
	
	Worker w = new Worker(8);
	
	SalesTerritoryManager stm = new SalesTerritoryManager(5);
}
}

class Employee{
	
	int dateOfJoining;
	
	public Employee(int doj) {
		this.dateOfJoining=doj;
		System.out.println("Employee Constructor");
	}
}

class SalesPerson extends Employee{
	public SalesPerson(int doj) {
		super(doj);
		System.out.println("Sales Person Constructor");
	}
}


class SalesManager extends SalesPerson{
	public SalesManager(int doj) {
		super(doj);
		System.out.println("Sales Manager Constructor");
	}
}


class SalesTerritoryManager extends SalesManager{
	public SalesTerritoryManager(int doj) {
		super(doj);
		System.out.println("Sales T M Constructor");
	}
}


class Worker extends Employee{
	public Worker(int doj) {
		super(doj);
		System.out.println("Worker Constructor");
	}
}