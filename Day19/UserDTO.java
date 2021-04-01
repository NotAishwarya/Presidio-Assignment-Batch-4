package day19;

import java.io.Serializable;

public class UserDTO implements Cloneable, Serializable {
	
	private int userid;
	private String username;
	private String password;
	private int flag;
	
	private static UserDTO userDTO;

	private UserDTO() {

	}
	
	synchronized public static UserDTO getUserDTO() {
		if(userDTO == null)
			return userDTO = new UserDTO();
		userDTO.clear();
		return userDTO.getClone();
	}
	
	private UserDTO getClone() {
		try {
			return (UserDTO) super.clone();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public void clear() {
		username = null;
		password = null;
		userid = 0;
		flag = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (flag != other.flag)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userid != other.userid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + ", password=" + password + ", flag=" + flag
				+ "]";
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public static void setUserDTO(UserDTO userDTO) {
		UserDTO.userDTO = userDTO;
	}
}
