package _05_Stock;


public class StockBean {
	
	private String stockId;
	private String productId;
	private String mfg;
	private String exp;
	private int quantity;
	
	public StockBean() {
		
	}

	public StockBean(String stockId, String productId, String mfg, String exp, int quantity) {
		super();
		this.stockId = stockId;
		this.productId = productId;
		this.mfg = mfg;
		this.exp = exp;
		this.quantity = quantity;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMfg() {
		return mfg;
	}

	public void setMfg(String mfg) {
		this.mfg = mfg;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
