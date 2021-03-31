package day18;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtility {
private JDBCUtility(){
	
}

private static String driver, url, username, password;
private static ThreadLocal<Connection> tlocal = new ThreadLocal<Connection>();
private static Connection con;

static {
	try {
		Properties prop = new Properties();
		prop.load(new FileInputStream("C:\\Users\\AISHWARYA\\eclipse-workspace\\basic\\dbConfig.properties"));
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		password = prop.getProperty("password");
		username = prop.getProperty("username");
		Class.forName(driver);
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public static Connection getConnection() {
	con = tlocal.get();
	
	if(con == null) {
		try {
			con = DriverManager.getConnection(url, username, password);
			tlocal.set(con);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	return con;
}

public static void closeConnection(Exception ex, Savepoint s) {
	con = tlocal.get();
	
	if(con != null) {
		try {
			if(ex == null) {
				con.commit();
			}
			else {
				if(s == null)
					con.rollback();
				else {
					con.rollback(s);
					con.commit();
				}
			}
			con.close();
			tlocal.remove();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}


}
