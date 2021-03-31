package day18;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCDemon4 {
public static void main(String[] args) {
	Connection con = JDBCUtility.getConnection();
	Savepoint first = null;
	
	try {
		Statement stmt = con.createStatement();
		//int i = stmt.executeUpdate("create table users(uid int(5), uname varchar(20), upassword varchar(20), flag int(1))");
		//System.out.println(i + "tables created");
		first =con.setSavepoint("second");
		
		int i=stmt.executeUpdate("insert into users values (2,'somu','spider',0)");
		System.out.println(i +" rows inserted....");
		
		i=stmt.executeUpdate("insert into users values (3,'monu','spider',0)");
		System.out.println(i +" rows inserted....");
				
		first =con.setSavepoint("first");
		
		i=stmt.executeUpdate("insert into user values (4,'monu','spider')");
		System.out.println(i +" rows inserted....");
		
		JDBCUtility.closeConnection(null,null);
		
	}catch (Exception e) {
		// TODO: handle exception
		JDBCUtility.closeConnection(e,first);
		e.printStackTrace();
	}
	}
}
