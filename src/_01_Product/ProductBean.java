package _01_Product;

public class ProductBean {
	public String productId;
	public int pgPrice;
	public String name;
	public double avgCost;
	public String oPlace;
	public int sLife;
	public String suppierId;

	public ProductBean() {
	}

	public ProductBean(String productId, int pgPrice, String name, double avgCost, String oPlace, int sLife,
			String suppierId) {
		super();
		this.productId = productId;
		this.pgPrice = pgPrice;
		this.name = name;
		this.avgCost = avgCost;
		this.oPlace = oPlace;
		this.sLife = sLife;
		this.suppierId = suppierId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getPgPrice() {
		return pgPrice;
	}

	public void setPgPrice(int pgPrice) {
		this.pgPrice = pgPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(double avgCost) {
		this.avgCost = avgCost;
	}

	public String getOPlace() {
		return oPlace;
	}

	public void setOPlace(String oPlace) {
		this.oPlace = oPlace;
	}

	public int getSLife() {
		return sLife;
	}

	public void setSLife(int sLife) {
		this.sLife = sLife;
	}

	public String getSuppierId() {
		return suppierId;
	}

	public void setSuppierId(String suppierId) {
		this.suppierId = suppierId;
	}
	
}