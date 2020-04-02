package jp.co.aforce.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.util.ProductDBUtil;

public class ProductModel {

	public List<ProductBean> search(String keyword, int minPrice, int maxPrice, String maker, String category1, String category2, String color) throws Exception {
		List<ProductBean> list = new ArrayList<>();

		ProductDBUtil.makeConnection();
		ProductDBUtil.makeStatement();

		ResultSet rs = ProductDBUtil.preparedStatement(keyword, minPrice, maxPrice, maker, category1, category2, color);

		while (rs.next()) {
			ProductBean p = new ProductBean();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setTax((int) (p.getPrice() * 0.1));
			p.setPricetax((int) (p.getPrice() * 1.1));
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

	public int insert (ProductBean product) throws Exception {
		ProductDBUtil.makeConnection();

		int line = ProductDBUtil.insertProduct(product);
		return line;
	}

	public boolean stockOver(int id, int count) throws Exception {
		ProductDBUtil.makeConnection();
		ProductDBUtil.makeStatement();

		ResultSet rs = null;

		String SQL = "select stock from product where id = " + id + ";";

		rs = ProductDBUtil.selectJoin(SQL);
		int stock = 0;

		while (rs.next()) {
			ProductBean p = new ProductBean();
			p.setStock(rs.getInt("stock"));
			stock = p.getStock();
		}
		if (stock < count) {
			return false;
		}
		return true;
	}


}
