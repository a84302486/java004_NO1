package _22_ShoppingTrackingList;

import _01_Product.ProductBean;

public class TrackingBean {
	private String username;
	private String procductId;
	private ProductBean ProductBean;
	
	public TrackingBean() {
	}
	public TrackingBean(String username, String procductId) {
		this.username = username;
		this.procductId = procductId;
	}
	
	public TrackingBean(String username, _01_Product.ProductBean productBean) {
		this.username = username;
		ProductBean = productBean;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getProcductId() {
		return procductId;
	}
	
	public void setProcductId(String procductId) {
		this.procductId = procductId;
	}
	
	public ProductBean getProductBean() {
		return ProductBean;
	}

	public void setProductBean(ProductBean productBean) {
		ProductBean = productBean;
	}
}
