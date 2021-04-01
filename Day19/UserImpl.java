package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserImpl implements UserDAO {

	Connection con;
	Statement findAllStatement;
	PreparedStatement findByIDStatement;
	PreparedStatement insertItemStatement;
	PreparedStatement deleteStatement;
	PreparedStatement updateStatement;
	PreparedStatement createTable;

	public UserImpl(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
		try {
			findAllStatement = con.createStatement();
			createTable = con.prepareStatement("create table users(userid INTEGER, username varchar(30), password varchar(30), flag INTEGER)");
			findByIDStatement = con.prepareStatement("select * from users where userid = ?");
			insertItemStatement = con.prepareStatement("insert into users values(?, ?, ?, ?)");
			deleteStatement = con.prepareStatement("delete from users where customer_id = ?");
			updateStatement = con
					.prepareStatement("update users set username = ?, password = ?, flag = ? where userid = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public UserDTO findUserByID(Integer userId) {
		// TODO Auto-generated method stub
		try {
			findByIDStatement.setInt(1, userId);
			ResultSet rs = findByIDStatement.executeQuery();

			UserDTO user = UserDTO.getUserDTO();

			while (rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFlag(rs.getInt(4));
			}

			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		List<UserDTO> users = new ArrayList<UserDTO>();

		try {
			ResultSet rs = findAllStatement.executeQuery("select * from users");
			while (rs.next()) {
				UserDTO user = UserDTO.getUserDTO();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFlag(rs.getInt(4));

				users.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public int insertUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		int userid = userDTO.getUserid();
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		int flag = userDTO.getFlag();

		int i = 0;
		try {
			findByIDStatement.setInt(1, userid);
			ResultSet rs = findByIDStatement.executeQuery();

			if (rs != null)
				return 0;

			insertItemStatement.setInt(1, userid);
			insertItemStatement.setString(2, username);
			insertItemStatement.setString(3, password);
			insertItemStatement.setInt(4, flag);

			i = insertItemStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

		return i;
	}

	@Override
	public int updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		int userid = userDTO.getUserid();
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		int flag = userDTO.getFlag();

		int i = 0;

		try {
			updateStatement.setInt(4, userid);
			updateStatement.setString(1, username);
			updateStatement.setString(2, password);
			updateStatement.setInt(3, flag);

			i = insertItemStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

		return i;

	}

	@Override
	public int deleteUserByID(Integer userId) {
		// TODO Auto-generated method stub
		int i = 0;

		try {
			deleteStatement.setInt(1, userId);
			i = deleteStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteUserByDTO(UserDTO userDTO) {
		// TODO Auto-generated method stub
		int userid = userDTO.getUserid();

		int i = 0;

		try {
			deleteStatement.setInt(1, userid);
			i = deleteStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int createUsersTable() {
		// TODO Auto-generated method stub
		try {
			int i = createTable.executeUpdate();
			return i;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

}
