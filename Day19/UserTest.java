package day19;

import java.sql.Connection;

import day18.JDBCUtility;

public class UserTest {
public static void main(String[] args) {
	Connection con = JDBCUtility.getConnection();
	
	UserDTO user = UserDTO.getUserDTO();
	UserImpl userImpl = new UserImpl(con);
	
	user.setFlag(0);
	user.setPassword("not telling you");
	user.setUsername("Mountain");
	user.setUserid(1);	
	userImpl.insertUser(user);
	
	user.setFlag(0);
	user.setPassword("not telling you");
	user.setUsername("Mountain");
	user.setUserid(1);	
	userImpl.insertUser(user);
	
	user.setFlag(0);
	user.setPassword("not telling you");
	user.setUsername("Mountain");
	user.setUserid(1);	
	userImpl.insertUser(user);
	
	System.out.println(userImpl.findAllUsers());
	
	
}
}
