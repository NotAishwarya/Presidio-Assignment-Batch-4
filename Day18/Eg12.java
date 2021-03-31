package day18;

import java.sql.*;

public class Eg12 {
public static void main(String[] args) {
	try {
		Connection con = JDBCUtility.getConnection();
		
		CallableStatement cs = con.prepareCall("{call proc(?)}");
		cs.setInt(1, 31);
		cs.executeUpdate();
		
		System.out.println("done");
		JDBCUtility.closeConnection(null, null);
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
