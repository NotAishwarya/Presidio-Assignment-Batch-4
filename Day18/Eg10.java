package day18;

import java.sql.*;

public class Eg10 {
public static void main(String[] args) {
	try {
		Connection con = JDBCUtility.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from sam where age >= ?");
		ps.setInt(1, 20);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + " \t" + rs.getString(2));
		}
		
		JDBCUtility.closeConnection(null, null);
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
