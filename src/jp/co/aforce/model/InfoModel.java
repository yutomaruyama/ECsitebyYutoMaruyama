package jp.co.aforce.model;

import java.sql.ResultSet;

import jp.co.aforce.bean.InfoBean;
import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.util.ProductDBUtil;

public class InfoModel {

	public InfoBean info(int id) throws Exception {
		InfoBean i = new InfoBean();

		ProductDBUtil.makeConnection();
		ProductDBUtil.makeStatement();

		String SQL = "select * from product left join info on info.name = product.name where product.id = " + id + ";";

		ResultSet rs = ProductDBUtil.selectJoin(SQL);

		while (rs.next()) {
			i.setId(rs.getInt("product.id"));
			i.setName(rs.getString("product.name"));
			i.setPrice(rs.getInt("price"));
			i.setPricetax((int) (i.getPrice() * 1.1));
			i.setMaker(rs.getString("maker"));
			i.setCategory1(rs.getString("category1"));
			i.setCategory2(rs.getString("category2"));
			i.setColor(rs.getString("color"));
			i.setStock(rs.getInt("stock"));
			i.setInfo(rs.getString("info"));
		}

		ProductDBUtil.closeConnection();

		return i;
	}

	public int insert (ProductBean product) throws Exception {
		ProductDBUtil.makeConnection();

		int line = ProductDBUtil.insertProduct(product);
		return line;
	}


}
