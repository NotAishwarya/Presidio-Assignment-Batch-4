package day18;

import java.sql.*;

public class Eg7 {
	public static void main(String[] args) {
		try {
			Connection con = JDBCUtility.getConnection();
			Statement st = con.createStatement();
			
			st.execute("insert into sam values('hapa',111)");
			st.execute("delete from sam where age=21");
			
			st.close();
			con.close();
			System.out.println(" success….. ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
