package day18;

import java.sql.Connection;
import java.sql.*;

public class Eg8 {
	public static void main(String[] args) {
		try {
			Connection con = JDBCUtility.getConnection();

			Statement st = con.createStatement();
			st.executeUpdate("update sam set name = 'Aishu' where age = 41");

			ResultSet rs = st.executeQuery("select * from sam");
			System.out.println("name " + "\t\t age");
			while (rs.next()) {
				String e1 = rs.getString(1);
				int e = rs.getInt(2);
				System.out.println("name = " + e1 + "\t age = " + e);
			}
			
			st.close();
			con.close();
			System.out.println("records successfully  updatedd");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
