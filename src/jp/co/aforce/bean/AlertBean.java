package jp.co.aforce.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AlertBean implements Serializable {

	public class java {

	}

	private String error;

	public AlertBean() {

	}


	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
