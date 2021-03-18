package day9;

public class Q1 {
public static void main(String[] args) {
	Employee e = new SalesPerson("Tom", 34, 123);
	e.payCheck();
	
	Employee e2 = new SalesTerritoryManager("Jerry" , 23, 234234);
	e2.payCheck();
	
	Employee e3 = new Worker("Snuggles", 234, 35345);
	e3.payCheck();
}
}

abstract class Employee{
	String name;
	int id;
	int payCheck;
	
	public abstract void payCheck();
}

abstract class Sales extends Employee{ 
	int salesID;
}

abstract class Prod extends Employee{
	int ProdID;
}

class SalesPerson extends Sales{

	public SalesPerson(String name, int id, int salesID) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.salesID = salesID;
		payCheck = 50;
	}
	@Override
	public void payCheck() {
		// TODO Auto-generated method stub
		System.out.println("Salary of : " + this.name + " with employee id : " + this.id + " and sales id of : " 
							+ this.salesID + " is " + this.payCheck);	
	}
	
}

class SalesManager extends Sales{

	public SalesManager(String name, int id, int salesID) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.salesID = salesID;
		payCheck = 60;
	}
	@Override
	public void payCheck() {
		// TODO Auto-generated method stub
		System.out.println("Salary of : " + this.name + " with employee id : " + this.id + " and sales id of : " 
							+ this.salesID + " is " + this.payCheck);	
	}
	
}

class SalesTerritoryManager extends Sales{

	public SalesTerritoryManager(String name, int id, int salesID) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.salesID = salesID;
		payCheck = 70;
	}
	@Override
	public void payCheck() {
		// TODO Auto-generated method stub
		System.out.println("Salary of : " + this.name + " with employee id : " + this.id + " and sales id of : " 
							+ this.salesID + " is " + this.payCheck);	
	}
	
}

class Worker extends Prod{

	public Worker(String name, int id, int prodID) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.ProdID = prodID;
		payCheck = 90;
	}
	@Override
	public void payCheck() {
		// TODO Auto-generated method stub
		System.out.println("Salary of : " + this.name + " with employee id : " + this.id + " and sales id of : " 
							+ this.ProdID + " is " + this.payCheck);	
	}
	
}

