package jp.co.aforce.model;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class JoinModel {

	public boolean joinCheck(String username, String password, String address, String check) {


		if (username.equals("") || password.equals("") || address.equals("")) {
			return false;
		}
		if (!password.equals(check)) {
			return false;
		}
		return true;

	}

	public boolean joinExecute(String username, String password, String address) {

		ResultSet rs = null;
		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "insert into loginuser values (null, '" + username + "', '" + password + "', '" + address + "');";
			rs = DBUtil.execute(SQL);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.closeConnection();
		}
		return true;
	}

}
