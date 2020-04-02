package jp.co.aforce.bean;

import java.io.Serializable;

@SuppressWarnings ("serial")
public class UserBean implements Serializable {

	private int Id;
	private String UserName;
	private String Password;

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getId() {
		return Id;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getPassword() {
		return Password;
	}

}
