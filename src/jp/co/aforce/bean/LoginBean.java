package jp.co.aforce.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginBean implements Serializable {

	private String username;
	private String password;
	private String emsg;

	public LoginBean() {

	}

	public void setUsername(String username) {
		this.username = username;

	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public String getPassword() {
		return password;
	}

	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}

	public String getEmsg() {
		return emsg;
	}

}
