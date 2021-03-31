package day18;

import java.sql.*;

public class Eg11 {
public static void main(String[] args) {
	try {
		Connection con = JDBCUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into sam values( ?, ?)");
		ps.setInt(2, 2000);
		ps.setString(1, "Bob the builder");
		
		 ps.executeUpdate();
		
		 System.out.println("done");
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
