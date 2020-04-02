package jp.co.aforce.model;

import java.sql.ResultSet;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.util.DBUtil;

public class InsertModel {
	public int insert (
			String name, int price, String maker, String category1, String category2, String color, int stock, String info
			) throws Exception {
		int id = 0;

		try {


			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "insert into product values(null, '" + name + "', " + price + ", '" + maker + "', '" + category1 + "', '" + category2 + "', '" + color + "', " + stock + ");";
			 if (!DBUtil.insert(SQL)) {
				 return id;
			 }
			 SQL = "insert into info values(null, '" + name + "', '" + info + "');";
			 if (!DBUtil.insert(SQL)) {
				 return id;
			 }
			 SQL = "select id from product where name = '" + name + "' and price = " + price + " and maker = '" + maker + "' and category1 = '" + category1 + "' and category2 = '" + category2 + "' and color = '" + color + "' and stock = " + stock + ";";
			 System.out.println(SQL);
			 ResultSet rs = DBUtil.execute(SQL);
			 ProductBean product = new ProductBean();
			 product.setId(rs.getInt("id"));
			 id = product.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection();
		}
		return id;



	}

}
