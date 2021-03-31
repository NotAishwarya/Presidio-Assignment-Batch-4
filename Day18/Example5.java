package day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Example5 {
public static void main(String[] args) {
	Connection con = JDBCUtility.getConnection();
	
	try {
		
		PreparedStatement updateSales = con.prepareStatement("update COFFEES set SALES = ? where COF_NAME like ?");
		PreparedStatement updateTotal = con.prepareStatement("update COFFEES set TOTAL = TOTAL + ? WHERE COF_NAME like ?");
		
		int [] salesForWeek = {175, 150, 60, 155, 90};
        String [] coffees = {"Colombian", "French_Roast", "Espresso", "Colombian_Decaf", "French_Roast_Decaf"};
        
        int len = coffees.length;
        
        con.setAutoCommit(false);
        
        for(int i =0; i < len; i++) {
        	updateSales.setInt(1, salesForWeek[i]);
        	updateSales.setString(2, coffees[i]);
        	
        	updateSales.execute();
        	
        	updateTotal.setInt(1, salesForWeek[i]);
        	updateTotal.setString(2, coffees[i]);
        	
        	updateTotal.execute();
        	
        	con.commit();	
        }
        
        con.setAutoCommit(true);
        
        
        updateSales.close();
        updateTotal.close();
        
        Statement stmt = con.createStatement();
        
        ResultSet rs = stmt.executeQuery("select COF_NAME, SALES, TOTAL from COFFEES");
        
        while(rs.next()) {
        	System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
        }
        
        JDBCUtility.closeConnection(null, null);
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		if(con != null) {
			System.out.println("Transaction is being rolledback");
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
}
