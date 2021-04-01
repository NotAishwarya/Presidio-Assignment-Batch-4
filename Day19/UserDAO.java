package day19;

import java.util.List;

public interface UserDAO {
	
	public int createUsersTable();
	
	public UserDTO findUserByID(Integer userId);

	public List<UserDTO> findAllUsers();

	public int insertUser(UserDTO userDTO);

	public int updateUser(UserDTO userDTO);

	public int deleteUserByID(Integer userId);

	public int deleteUserByDTO(UserDTO userDTO);
}
