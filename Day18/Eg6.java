package day18;

import java.sql.*;

public class Eg6 {
	public static void main(String[] args) {
		try {
			Connection con = JDBCUtility.getConnection();

			Statement st = con.createStatement();

			st.executeUpdate("delete from sam where age = 51");
			
			ResultSet rs = st.executeQuery("select * from sam");
			
			while (rs.next()) {
				String e1 = rs.getString(1);
				int e = rs.getInt(2);
				System.out.println("name = " + e1 + "\t age = " + e);
			}
			
			st.close();
			con.close();
			System.out.println("records successfully  deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
