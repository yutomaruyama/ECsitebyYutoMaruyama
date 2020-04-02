package jp.co.aforce.model;

import java.util.List;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.util.PurchaseDBUtil;

public class PurchaseModel {
	public boolean insert (
			List<ItemBean> cart, String name, String address
			) throws Exception {

		PurchaseDBUtil.makeConnection();

		boolean insert = PurchaseDBUtil.purchase(cart, name, address);
		return insert;
	}

}
