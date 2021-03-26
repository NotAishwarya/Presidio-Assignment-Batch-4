package day15;

import java.io.*;

public class ObjectSetDemo {
public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
	
	Employee emp = new Employee(1000);
	
	System.out.println(emp.getSalary());
	
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.dat"));
	oos.writeObject(emp);
	
	emp.setSalary(2000);
	
	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.dat"));
	Employee empcopy = (Employee)ois.readObject();
	
	System.out.println("Old one .......... " + empcopy.getSalary());
	System.out.println("New one .......... " + emp.getSalary());
}
}


class Employee implements Serializable{
	int salary;
	public Employee(int salary) {
		// TODO Auto-generated constructor stub
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}