package day18;

import java.sql.*;

public class Eg5 {
	public static void main(String[] args) {
		try {
			Connection con = JDBCUtility.getConnection();
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from SAM");
			while (rs.next()) {
				String e1 = rs.getString(1);
				int e = rs.getInt(2);
				System.out.println("name = " + e1 + " age = " + e);
			}
			
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
