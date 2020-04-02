package jp.co.aforce.bean;

public class ItemBean {

	private ProductBean product;
	private int count;
	private int subtotalPrice;

	public ItemBean() {

	}

	public int getSubtotalPrice() {
		return subtotalPrice;
	}

	public void setSubtotalPrice(int subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}

	public ProductBean getProduct() {
		return product;
	}

	public int getCount() {
		return count;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
