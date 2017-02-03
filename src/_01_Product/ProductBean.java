package _01_Product;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private String product_id;
	private int p_g_price;
	private String name;
	private double avg_cost;
	private String o_place;
	private int s_life;
	private String suppier_id;
	
	public ProductBean(){
		
	}

	public ProductBean(String product_id, int p_g_price, String name, double avg_cost, String o_place, int s_life,
			String suppier_id) {
		super();
		this.product_id = product_id;
		this.p_g_price = p_g_price;
		this.name = name;
		this.avg_cost = avg_cost;
		this.o_place = o_place;
		this.s_life = s_life;
		this.suppier_id = suppier_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public int getP_g_price() {
		return p_g_price;
	}

	public void setP_g_price(int p_g_price) {
		this.p_g_price = p_g_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvg_cost() {
		return avg_cost;
	}

	public void setAvg_cost(double avg_cost) {
		this.avg_cost = avg_cost;
	}

	public String getO_place() {
		return o_place;
	}

	public void setO_place(String o_place) {
		this.o_place = o_place;
	}

	public int getS_life() {
		return s_life;
	}

	public void setS_life(int s_life) {
		this.s_life = s_life;
	}

	public String getSuppier_id() {
		return suppier_id;
	}

	public void setSuppier_id(String suppier_id) {
		this.suppier_id = suppier_id;
	}
	
	
}
