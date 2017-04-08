package _21_ShoppingOrder;

import _01_Product.ProductBean;

public class OrderDetailBean {
	private String OrderId;
	private ProductBean ProductBean;
	private Integer Quantity;
	private Integer SubTotal;
	private Double score;
	
	public OrderDetailBean(){
		
	}

	public OrderDetailBean(String orderId, _01_Product.ProductBean productBean, Integer quantity,
			Integer subTotal, Double score) {
		OrderId = orderId;
		ProductBean = productBean;
		Quantity = quantity;
		SubTotal = subTotal;
		this.score = score;
	}
	
	public OrderDetailBean(String orderId, _01_Product.ProductBean productBean, Integer quantity,
			Integer subTotal) {
		OrderId = orderId;
		ProductBean = productBean;
		Quantity = quantity;
		SubTotal = subTotal;
	}
	

	public String getOrderId() {
		return OrderId;
	}


	public void setOrderId(String orderId) {
		OrderId = orderId;
	}


	public ProductBean getProductBean() {
		return ProductBean;
	}


	public void setProductBean(ProductBean productBean) {
		ProductBean = productBean;
	}


	public Integer getQuantity() {
		return Quantity;
	}


	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}


	public Integer getSubTotal() {
		return SubTotal;
	}


	public void setSubTotal(Integer subTotal) {
		SubTotal = subTotal;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
}
