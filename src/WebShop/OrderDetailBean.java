package WebShop;

public class OrderDetailBean {
	private String OrderId;
	private String product_id;
	private Integer P_G_price;
	private Integer Quantity;
	private Integer SubTotal;
	
	public OrderDetailBean(){
		
	}
	
	public OrderDetailBean(String orderId, String product_id, Integer p_G_price, Integer quantity, Integer subTotal) {
		super();
		OrderId = orderId;
		this.product_id = product_id;
		P_G_price = p_G_price;
		Quantity = quantity;
		SubTotal = subTotal;
	}
	
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Integer getP_G_price() {
		return P_G_price;
	}
	public void setP_G_price(Integer p_G_price) {
		P_G_price = p_G_price;
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
