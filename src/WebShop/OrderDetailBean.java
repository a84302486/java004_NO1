package WebShop;

import _01_ProductTest.ProductBean;

public class OrderDetailBean {
	private String OrderId;
	private ProductBean ProductBean;
	private Integer Quantity;
	private Integer SubTotal;
	
	public OrderDetailBean(){
		
	}

	public OrderDetailBean(String orderId, _01_ProductTest.ProductBean productBean, Integer quantity,
			Integer subTotal) {
		super();
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
	
}
