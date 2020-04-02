package jp.co.aforce.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.util.DBUtil;

public class UserModel {

	public ArrayList<UserBean> getAllUsers() {

		ResultSet rs = null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();

		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();


			String SQL = "SELECT * FROM `loginuser` ORDER BY 'id'";
			rs = DBUtil.execute(SQL);

			while (rs.next()) {
				UserBean objBean = new UserBean();
				objBean.setId(rs.getInt("id"));
				objBean.setUserName(rs.getString("username"));
				objBean.setPassword(rs.getString("password"));
				list.add(objBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return list;
		// TODO 自動生成されたメソッド・スタブ
	}

}
