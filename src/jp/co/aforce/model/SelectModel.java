package jp.co.aforce.model;

import java.sql.ResultSet;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.util.DBUtil;
import jp.co.aforce.util.ProductDBUtil;

public class SelectModel {

	public ProductBean search(int id) throws Exception {
		ProductBean p = new ProductBean();
//		List<ProductBean> list = new ArrayList<>();

		ProductDBUtil.makeConnection();
		ProductDBUtil.makeStatement();

		ResultSet rs = ProductDBUtil.executeQuery(id);

		while (rs.next()) {
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setMaker(rs.getString("maker"));
			p.setCategory1(rs.getString("category1"));
			p.setCategory2(rs.getString("category2"));
			p.setColor(rs.getString("color"));
			p.setStock(rs.getInt("stock"));
//			list.add(p);
		}


		ProductDBUtil.closeConnection();

		return p;
	}

	public int insert (ProductBean product) throws Exception {
		ProductDBUtil.makeConnection();

		int line = ProductDBUtil.insertProduct(product);
		return line;
	}

	public boolean select (int id, String name, int price, String maker, String category1, String category2, String color, int stock
			) throws Exception {
		try {


			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "update product set name = '" + name + "', price = " + price + ", maker = '" + maker + "', category1 = '" + category1 + "', category2 = '" + category2 + "', color = '" + color + "', stock =  " + stock + " where id = " + id + ";";
			 if (!DBUtil.update(SQL)) {
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
