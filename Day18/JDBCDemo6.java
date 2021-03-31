package day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class JDBCDemo6 {
public static void main(String[] args) {
	try {
		
		Connection con = JDBCUtility.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from users where uid = ?");
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			int userID = scan.nextInt();
			
			ps.setInt(1, userID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs == null)
				continue;
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int colCount = rsmd.getColumnCount();
			System.out.println(colCount);
			
			while(rs.next()){
			
				for(int i = 1; i < colCount; i++) {
				System.out.println(rs.getString(i));
				}
				
			}
			JDBCUtility.closeConnection(null, null);
		}
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
