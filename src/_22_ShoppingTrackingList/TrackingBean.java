package _22_ShoppingTrackingList;

import _01_Product.ProductBean;

public class TrackingBean {
	private String username;
	private ProductBean ProductBean;
	
	public TrackingBean() {
	}

	public TrackingBean(String username, _01_Product.ProductBean productBean) {
		super();
		this.username = username;
		ProductBean = productBean;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ProductBean getProductBean() {
		return ProductBean;
	}

	public void setProductBean(ProductBean productBean) {
		ProductBean = productBean;
	}
}
