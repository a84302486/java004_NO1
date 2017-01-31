package _01_Product;

import java.io.Serializable;

public class ProductBean implements Serializable {
	String product_id;
	String P_G_price;
	String Name;
	String AVG_cost;
	String O_place;
	String S_life;
	String Suppier_id;
	
	public ProductBean(String product_id, String p_G_price, String name, String aVG_cost, String o_place, String s_life,
			String suppier_id) {
		super();
		this.product_id = product_id;
		P_G_price = p_G_price;
		Name = name;
		AVG_cost = aVG_cost;
		O_place = o_place;
		S_life = s_life;
		Suppier_id = suppier_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getP_G_price() {
		return P_G_price;
	}

	public void setP_G_price(String p_G_price) {
		P_G_price = p_G_price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAVG_cost() {
		return AVG_cost;
	}

	public void setAVG_cost(String aVG_cost) {
		AVG_cost = aVG_cost;
	}

	public String getO_place() {
		return O_place;
	}

	public void setO_place(String o_place) {
		O_place = o_place;
	}

	public String getS_life() {
		return S_life;
	}

	public void setS_life(String s_life) {
		S_life = s_life;
	}

	public String getSuppier_id() {
		return Suppier_id;
	}

	public void setSuppier_id(String suppier_id) {
		Suppier_id = suppier_id;
	}
}
