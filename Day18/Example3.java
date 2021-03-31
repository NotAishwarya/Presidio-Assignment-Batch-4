package day18;

import java.sql.Connection;
import java.sql.Statement;

public class Example3 {
public static void main(String[] args) {
	try {
		Connection con = JDBCUtility.getConnection();
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate("insert into pradeep values(1,'hey', 3)");
		stmt.executeUpdate("insert into pradeep values(1, 'hello', 4)");
		
		System.out.println("Done");
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
