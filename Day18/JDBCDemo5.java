package day18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo5 {
public static void main(String[] args) {
	Connection con = JDBCUtility.getConnection();
	
	try {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users");
		
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		
		for(int i = 1; i < columnCount; i++)
			System.out.print(rsmd.getColumnName(i) + "\t");
		
		
		System.out.println("\n-------------------------------------------");
		while(rs.next()) {
			
			for(int i = 1;i <= columnCount ;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
