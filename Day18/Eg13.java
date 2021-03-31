package day18;

import java.sql.*;
import java.util.Enumeration;

public class Eg13 {
public static void main(String[] args) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Enumeration e=DriverManager.getDrivers();
	
	System.out.println(" " +DriverManager.getLoginTimeout());
	while(e.hasMoreElements())
	{
		System.out.println(e.nextElement());
	}
}
}
