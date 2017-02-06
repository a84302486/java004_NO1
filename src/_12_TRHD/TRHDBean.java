package _12_TRHD;

import java.io.Serializable;

public class TRHDBean implements Serializable {
	
	private String coSeq;			
	private String coType; 		
	private String coRole; 		
	private String coYear;			
	private String coMonth;		
	private String minRole;		
	private String trDate;			
	private int seqNo;			
	private int toQty;			
	private double toList;			
	private double toPrice;		
	private double toSold;			
	private double toCost;			
	private double toDisc;			
	 
	public TRHDBean(){
		
	}

	public TRHDBean(String coSeq, String coType, String coRole, String coYear, String coMonth, String minRole,
			String trDate, int seqNo, int toQty, double toList, double toPrice, double toSold, double toCost,
			double toDisc) {
		super();
		this.coSeq = coSeq;
		this.coType = coType;
		this.coRole = coRole;
		this.coYear = coYear;
		this.coMonth = coMonth;
		this.minRole = minRole;
		this.trDate = trDate;
		this.seqNo = seqNo;
		this.toQty = toQty;
		this.toList = toList;
		this.toPrice = toPrice;
		this.toSold = toSold;
		this.toCost = toCost;
		this.toDisc = toDisc;
	}

	public String getCoSeq() {
		return coSeq;
	}

	public void setCoSeq(String coSeq) {
		this.coSeq = coSeq;
	}

	public String getCoType() {
		return coType;
	}

	public void setCoType(String coType) {
		this.coType = coType;
	}

	public String getCoRole() {
		return coRole;
	}

	public void setCoRole(String coRole) {
		this.coRole = coRole;
	}

	public String getCoYear() {
		return coYear;
	}

	public void setCoYear(String coYear) {
		this.coYear = coYear;
	}

	public String getCoMonth() {
		return coMonth;
	}

	public void setCoMonth(String coMonth) {
		this.coMonth = coMonth;
	}

	public String getMinRole() {
		return minRole;
	}

	public void setMinRole(String minRole) {
		this.minRole = minRole;
	}

	public String getTrDate() {
		return trDate;
	}

	public void setTrDate(String trDate) {
		this.trDate = trDate;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public int getToQty() {
		return toQty;
	}

	public void setToQty(int toQty) {
		this.toQty = toQty;
	}

	public double getToList() {
		return toList;
	}

	public void setToList(double toList) {
		this.toList = toList;
	}

	public double getToPrice() {
		return toPrice;
	}

	public void setToPrice(double toPrice) {
		this.toPrice = toPrice;
	}

	public double getToSold() {
		return toSold;
	}

	public void setToSold(double toSold) {
		this.toSold = toSold;
	}

	public double getToCost() {
		return toCost;
	}

	public void setToCost(double toCost) {
		this.toCost = toCost;
	}

	public double getToDisc() {
		return toDisc;
	}

	public void setToDisc(double toDisc) {
		this.toDisc = toDisc;
	}
	
	
}