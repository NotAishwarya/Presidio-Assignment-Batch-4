package day18;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cod4", "root", "root");
	System.out.println(con);
}
}
