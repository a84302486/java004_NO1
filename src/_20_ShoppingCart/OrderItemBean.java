package _20_ShoppingCart;

//本類別封裝單筆訂單資料
public class OrderItemBean {
	private String productId;
	private String name;
	private int pgPrice = 0 ; 
	private int qty = 0 ;
	
	public OrderItemBean() {

	}

	public OrderItemBean(String productId, String name, int pgPrice, int qty) {
		super();
		this.productId = productId;
		this.name = name;
		this.pgPrice = pgPrice;
		this.qty = qty;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPgPrice() {
		return pgPrice;
	}

	public void setPgPrice(int pgPrice) {
		this.pgPrice = pgPrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
