package jp.co.aforce.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.util.DBUtil;
import jp.co.aforce.util.ProductDBUtil;

public class DeleteModel {

	public List<ProductBean> search(int id) throws Exception {
		List<ProductBean> list = new ArrayList<>();

		ProductDBUtil.makeConnection();
		ProductDBUtil.makeStatement();

		ResultSet rs = ProductDBUtil.executeQuery(id);

		while (rs.next()) {
			ProductBean p = new ProductBean();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setMaker(rs.getString("maker"));
			p.setCategory1(rs.getString("category1"));
			p.setCategory2(rs.getString("category2"));
			p.setColor(rs.getString("color"));
			p.setStock(rs.getInt("stock"));
			list.add(p);
		}

		ProductDBUtil.closeConnection();

		return list;
	}

	public boolean delete (int id) throws Exception {

		try {


			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "delete from product where id = " + id + ";";
			 if (!DBUtil.delete(SQL)) {
				 return false;
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return true;



	}

}
