package day18;

import java.sql.*;

public class Eg4 {
	public static void main(String[] args) {

		try {
			Connection con = JDBCUtility.getConnection();
			Statement st = con.createStatement();
			
			st.executeUpdate(" insert into sam values('one1',11)");
			st.executeUpdate(" insert into sam values('two1',21)");
			st.executeUpdate(" insert into sam values('three1',31)");
			st.executeUpdate(" insert into sam values('four1',41)");
			st.executeUpdate(" insert into sam values('five1',51)");
			st.close();
			con.close();
			System.out.println("records successfully  inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
