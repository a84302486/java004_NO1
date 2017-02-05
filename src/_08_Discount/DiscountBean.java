package _08_Discount;

import java.io.Serializable;

public class DiscountBean implements Serializable {
	private String discountId;
	private double description;

	public DiscountBean(){
		
	}

	public DiscountBean(String discountId, double description) {
		super();
		this.discountId = discountId;
		this.description = description;
	}

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	public double getDescription() {
		return description;
	}

	public void setDescription(double description) {
		this.description = description;
	}
	
}