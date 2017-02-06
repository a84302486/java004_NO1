package _01_Product;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private ProductBeanData data = new ProductBeanData();

	public ProductBean(){
		
	}

	public ProductBean(String product_id, int p_g_price, String name, double avg_cost, String o_place, int s_life,
			String suppier_id) {
		super();
		this.data.productId = product_id;
		this.data.pgPrice = p_g_price;
		this.data.name = name;
		this.data.avgCost = avg_cost;
		this.data.oPlace = o_place;
		this.data.sLife = s_life;
		this.data.suppierId = suppier_id;
	}

	public String getProduct_id() {
		return data.productId;
	}

	public void setProduct_id(String product_id) {
		this.data.productId = product_id;
	}

	public int getP_g_price() {
		return data.pgPrice;
	}

	public void setP_g_price(int p_g_price) {
		this.data.pgPrice = p_g_price;
	}

	public String getName() {
		return data.name;
	}

	public void setName(String name) {
		this.data.name = name;
	}

	public double getAvg_cost() {
		return data.avgCost;
	}

	public void setAvg_cost(double avg_cost) {
		this.data.avgCost = avg_cost;
	}

	public String getO_place() {
		return data.oPlace;
	}

	public void setO_place(String o_place) {
		this.data.oPlace = o_place;
	}

	public int getS_life() {
		return data.sLife;
	}

	public void setS_life(int s_life) {
		this.data.sLife = s_life;
	}

	public String getSuppier_id() {
		return data.suppierId;
	}

	public void setSuppier_id(String suppier_id) {
		this.data.suppierId = suppier_id;
	}
	
	
}
