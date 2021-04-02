package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserImpl implements UserDAO {

	private Connection con;
	private Statement findAllStatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement insertItemStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement createTable;

	public UserImpl(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
		try {
			findAllStatement = con.createStatement();
			createTable = con.prepareStatement("create table users(userid INTEGER, username varchar(30), password varchar(30), flag INTEGER)");
			findByIDStatement = con.prepareStatement("select * from users where userid = ?");
			insertItemStatement = con.prepareStatement("insert into users values(?, ?, ?, ?)");
			deleteStatement = con.prepareStatement("delete from users where userid = ?");
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

		int i = 0;
		try {
			findByIDStatement.setInt(1, userid);
			ResultSet rs = findByIDStatement.executeQuery();

			if (rs.next())
				return 0;

			insertItemStatement.setInt(1, userid);
			insertItemStatement.setString(2, userDTO.getUsername());
			insertItemStatement.setString(3, userDTO.getPassword());
			insertItemStatement.setInt(4, userDTO.getFlag());

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
		int i = 0;

		try {
			updateStatement.setInt(4, userDTO.getUserid());
			updateStatement.setString(1, userDTO.getUsername());
			updateStatement.setString(2, userDTO.getPassword());
			updateStatement.setInt(3, userDTO.getFlag());

			i = updateStatement.executeUpdate();
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
		int i = 0;

		try {
			deleteStatement.setInt(1, userDTO.getUserid());
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
