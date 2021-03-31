package day18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Example4 {
public static void main(String[] args) {
	try {
		Connection con = JDBCUtility.getConnection();
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from pradeep");
		
		while(rs.next())
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
		
		JDBCUtility.closeConnection(null, null);
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
