package day18;

import java.sql.Connection;
import java.sql.Statement;

public class Example2 {
	public Example2() {
		// TODO Auto-generated constructor stub
		try {
			Connection con = JDBCUtility.getConnection();
			
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("create table pradeep(empno integer, ename varchar(20), deptno integer)");
			System.out.println("Table created " + i);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Example2();
		}
}
