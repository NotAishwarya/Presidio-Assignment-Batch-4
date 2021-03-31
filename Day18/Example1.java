package day18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Example1 {
	
	public Example1() {
		// TODO Auto-generated constructor stub
		try {
			Connection con = JDBCUtility.getConnection();
			Statement stmt = con.createStatement();			
			ResultSet rs = stmt.executeQuery("select * from users");
			
			while(rs.next()){
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
public static void main(String[] args) {
	new Example1();
}
}
