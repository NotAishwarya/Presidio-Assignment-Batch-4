package day18;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class Eg2 {
	public static void main(String[] args) {
		Connection con = JDBCUtility.getConnection();

		try {
			DatabaseMetaData dbmd = con.getMetaData();

			System.out.println("DatabaseProductName     :  " + dbmd.getDatabaseProductName());
			System.out.println("DatabaseProductVersion  : " + dbmd.getDatabaseProductVersion());
			System.out.println("getStringFunctions            : " + dbmd.getStringFunctions());
			System.out.println("DriverMajorVersion          : " + dbmd.getDriverMajorVersion());
			System.out.println("DriverMinorVersion          :" + dbmd.getDriverMinorVersion());
			System.out.println("DriverName		    : " + dbmd.getDriverName());
			System.out.println("SQLKeywords 		     : " + dbmd.getSQLKeywords());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
