package _05_Stock;

public class Product_Stock_Bean {
	 
	private String Product_Stock_id;
	private String product_id;
	private Integer quantity;
	private String status;
	private String insertdate;
	
	public Product_Stock_Bean() {
		
	}

	public Product_Stock_Bean(String product_Stock_id, String product_id, Integer quantity, String status,
			String insertdate) {
		super();
		Product_Stock_id = product_Stock_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.status = status;
		this.insertdate = insertdate;
	}
	
	
	public String getProduct_Stock_id() {
		return Product_Stock_id;
	}
	public void setProduct_Stock_id(String product_Stock_id) {
		Product_Stock_id = product_Stock_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	
	
}
