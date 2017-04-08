package _21_ShoppingOrder;

import _01_Product.ProductBean;

public class OrderDetailBean {
	private String OrderId;
	private ProductBean ProductBean;
	private Integer Quantity;
	private Integer SubTotal;
	private boolean mark;
	private Integer score;
	
	public OrderDetailBean(){
		
	}

	public OrderDetailBean(String orderId, _01_Product.ProductBean productBean, Integer quantity,
			Integer subTotal, boolean mark, Integer score) {
		OrderId = orderId;
		ProductBean = productBean;
		Quantity = quantity;
		SubTotal = subTotal;
		this.mark = mark;
		this.score = score;
	}
	
	public OrderDetailBean(boolean mark, Integer score) {
		this.mark = mark;
		this.score = score;
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

	public boolean getMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
}
