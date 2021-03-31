package day18;

import java.sql.Connection;
import java.sql.DatabaseMetaData;


public class JDBCDemo3 {
public static void main(String[] args) {
	try {
		Connection con = JDBCUtility.getConnection();
		
		con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		
		DatabaseMetaData dmd = con.getMetaData();
		
		System.out.println("Version is ..........." + dmd.getDatabaseProductVersion());
		System.out.println("Database name is .................." + dmd.getDatabaseProductName());
		System.out.println("Default isolation is ............" + dmd.getDefaultTransactionIsolation());
		System.out.println("Connection isolation is .........." + con.getTransactionIsolation());
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
