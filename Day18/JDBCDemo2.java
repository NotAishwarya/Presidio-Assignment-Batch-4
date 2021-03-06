package day18;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JDBCDemo2 {
public static void main(String[] args) {
	ExecutorService es=Executors.newFixedThreadPool(2);
	
	es.execute(()->{
		Connection con=JDBCUtility.getConnection();
		System.out.println(con);
		JDBCUtility.closeConnection(null, null);
		
		Connection con2=JDBCUtility.getConnection();
		System.out.println(con2);
	});
	es.execute(()->{
		Connection con=JDBCUtility.getConnection();
		System.out.println(con);
		Connection con2=JDBCUtility.getConnection();
		System.out.println(con2);
	});
	es.shutdown();
}
}
