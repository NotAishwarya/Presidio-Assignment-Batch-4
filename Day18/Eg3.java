package day18;

import java.sql.Connection;
import java.sql.Statement;

public class Eg3 {
	public static void main(String[] args) {
		Connection con = JDBCUtility.getConnection();

		try {
			Statement st = con.createStatement();
			st.executeUpdate("create table sam(name varchar(15),age int)");
			st.close();
			con.close();
			System.out.println("table created");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
