package _21_ShoppingOrder;

public class OrderBean {
	private String OrderId;
	private String OrderDate;
	private String ShippedDate;
	private String M_Username;
	private Integer OrderTotal;
	
	
	public OrderBean(){
		
	}
	
	public OrderBean(String orderId, String orderDate, String shippedDate, String m_Username, Integer orderTotal) {
		super();
		OrderId = orderId;
		OrderDate = orderDate;
		ShippedDate = shippedDate;
		M_Username = m_Username;
		OrderTotal = orderTotal;
	}
	
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getShippedDate() {
		return ShippedDate;
	}
	public void setShippedDate(String shippedDate) {
		ShippedDate = shippedDate;
	}
	public String getM_Username() {
		return M_Username;
	}
	public void setM_Username(String m_Username) {
		M_Username = m_Username;
	}
	public Integer getOrderTotal() {
		return OrderTotal;
	}
	public void setOrderTotal(Integer orderTotal) {
		OrderTotal = orderTotal;
	}
	
	
	
	
}
