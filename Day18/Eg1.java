package day18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Eg1 {
public static void main(String[] args) {
	try {
		Connection con = JDBCUtility.getConnection();
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from coffees");
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println("No. of Cols = " + rsmd.getColumnCount());
		
		for(int i = 1; i<=rsmd.getColumnCount(); i++)
		{	
			String c = rsmd.getColumnName(i);
			String c1 = rsmd.getColumnTypeName(i);
			
			String c2 = rsmd.getColumnLabel(i);
			System.out.println("columne name " + c +" type name " + c1 + " label " + c2);
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
