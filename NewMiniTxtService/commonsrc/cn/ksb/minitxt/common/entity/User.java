package cn.ksb.minitxt.common.entity;

public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3323053279475922297L;
	
	private String username;
	private String password;
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
}
