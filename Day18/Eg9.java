package day18;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

public class Eg9 {
	public static void main(String[] args) {
		try {
			Connection con = JDBCUtility.getConnection();

			Statement st = con.createStatement();
			st.execute("drop table sam");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
