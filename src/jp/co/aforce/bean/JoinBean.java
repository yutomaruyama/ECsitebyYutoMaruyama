package jp.co.aforce.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class JoinBean implements Serializable {

	private String username;
	private String password;
	private String mailaddress;
	private String check;
	private String emsg;

	public JoinBean() {

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

	public void setCheck(String check) {
		this.check = check;
	}

	public String getCheck() {
		return check;
	}

	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}

	public String getEmsg() {
		return emsg;
	}

	public String getMailaddress() {
		return mailaddress;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

}
