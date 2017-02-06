package _09_Commission;

import java.io.Serializable;

public class CommissionBean implements Serializable {
	private int commissionId;	
	private String customerId; 	
	private double discount01;		
	private double discount02;		
	private double discount03;	
	private double discount04;		
	private double discount05;		
	private double discount06;		
	private double discount07;		
	private double discount08;		
	private double discount09;		
	private double discount10;	
	private double rate01;		
	private double rate02;
	private double rate03;
	private double rate04;
	private double rate05;
	private double rate06;
	private double rate07;
	private double rate08;
	private double rate09;
	private double rate10;
	
	public CommissionBean(){
		
	}

	public CommissionBean(int commissionId, String customerId, double discount01, double discount02, double discount03,
			double discount04, double discount05, double discount06, double discount07, double discount08,
			double discount09, double discount10, double rate01, double rate02, double rate03, double rate04,
			double rate05, double rate06, double rate07, double rate08, double rate09, double rate10) {
		super();
		this.commissionId = commissionId;
		this.customerId = customerId;
		this.discount01 = discount01;
		this.discount02 = discount02;
		this.discount03 = discount03;
		this.discount04 = discount04;
		this.discount05 = discount05;
		this.discount06 = discount06;
		this.discount07 = discount07;
		this.discount08 = discount08;
		this.discount09 = discount09;
		this.discount10 = discount10;
		this.rate01 = rate01;
		this.rate02 = rate02;
		this.rate03 = rate03;
		this.rate04 = rate04;
		this.rate05 = rate05;
		this.rate06 = rate06;
		this.rate07 = rate07;
		this.rate08 = rate08;
		this.rate09 = rate09;
		this.rate10 = rate10;
	}

	public int getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(int commissionId) {
		this.commissionId = commissionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerLdd) {
		this.customerId = customerLdd;
	}

	public double getDiscount01() {
		return discount01;
	}

	public void setDiscount01(double discount01) {
		this.discount01 = discount01;
	}

	public double getDiscount02() {
		return discount02;
	}

	public void setDiscount02(double discount02) {
		this.discount02 = discount02;
	}

	public double getDiscount03() {
		return discount03;
	}

	public void setDiscount03(double discount03) {
		this.discount03 = discount03;
	}

	public double getDiscount04() {
		return discount04;
	}

	public void setDiscount04(double discount04) {
		this.discount04 = discount04;
	}

	public double getDiscount05() {
		return discount05;
	}

	public void setDiscount05(double discount05) {
		this.discount05 = discount05;
	}

	public double getDiscount06() {
		return discount06;
	}

	public void setDiscount06(double discount06) {
		this.discount06 = discount06;
	}

	public double getDiscount07() {
		return discount07;
	}

	public void setDiscount07(double discount07) {
		this.discount07 = discount07;
	}

	public double getDiscount08() {
		return discount08;
	}

	public void setDiscount08(double discount08) {
		this.discount08 = discount08;
	}

	public double getDiscount09() {
		return discount09;
	}

	public void setDiscount09(double discount09) {
		this.discount09 = discount09;
	}

	public double getDiscount10() {
		return discount10;
	}

	public void setDiscount10(double discount10) {
		this.discount10 = discount10;
	}

	public double getRate01() {
		return rate01;
	}

	public void setRate01(double rate01) {
		this.rate01 = rate01;
	}

	public double getRate02() {
		return rate02;
	}

	public void setRate02(double rate02) {
		this.rate02 = rate02;
	}

	public double getRate03() {
		return rate03;
	}

	public void setRate03(double rate03) {
		this.rate03 = rate03;
	}

	public double getRate04() {
		return rate04;
	}

	public void setRate04(double rate04) {
		this.rate04 = rate04;
	}

	public double getRate05() {
		return rate05;
	}

	public void setRate05(double rate05) {
		this.rate05 = rate05;
	}

	public double getRate06() {
		return rate06;
	}

	public void setRate06(double rate06) {
		this.rate06 = rate06;
	}

	public double getRate07() {
		return rate07;
	}

	public void setRate07(double rate07) {
		this.rate07 = rate07;
	}

	public double getRate08() {
		return rate08;
	}

	public void setRate08(double rate08) {
		this.rate08 = rate08;
	}

	public double getRate09() {
		return rate09;
	}

	public void setRate09(double rate09) {
		this.rate09 = rate09;
	}

	public double getRate10() {
		return rate10;
	}

	public void setRate10(double rate10) {
		this.rate10 = rate10;
	}
		
}