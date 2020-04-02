package jp.co.aforce.model;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class LoginModel {

	public boolean loginCheck(String username, String password) {

		ResultSet rs = null;

		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "SELECT * FROM loginuser WHERE username = '" + username + "' AND password = '" + password + "'";
			rs = DBUtil.execute(SQL);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return rs != null;
	}

}
