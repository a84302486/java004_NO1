package _13_TRDT;

import java.io.Serializable;

public class TRDTBean implements Serializable {
	private String coSqe;		
	private String coType; 		
	private String coRole; 		
	private String coYear;			
	private String coMonth;		
	private String minRole;		
	private String trDate;			
	private String productId;		
	private String tasteId;		
	private String packageId;		
	private int seqNo;			
	private int trQty;			
	private double trList;			
	private double trPrice;		
	private double trSold;			
	private double trCost;			
	private double trDiscount;		
	private double preDeposit;		
	private double thisDeposit;	
	private double visa;			
	private double cash;			
	private String sales;			
	private String shift;			
	private double discAtm;		
	private String mId;			
	private String iuser;			
	private String idate;			
	private String itime;			
	private String muser;			
	private String mdate;			
	private String mtime;			
	
	public TRDTBean(){
		
	}

	public TRDTBean(String coSqe, String coType, String coRole, String coYear, String coMonth, String minRole,
			String trDate, String productId, String tasteId, String packageId, int seqNo, int trQty, double trList,
			double trPrice, double trSold, double trCost, double trDiscount, double preDeposit, double thisDeposit,
			double visa, double cash, String sales, String shift, double discAtm, String mId, String iuser,
			String idate, String itime, String muser, String mdate, String mtime) {
		super();
		this.coSqe = coSqe;
		this.coType = coType;
		this.coRole = coRole;
		this.coYear = coYear;
		this.coMonth = coMonth;
		this.minRole = minRole;
		this.trDate = trDate;
		this.productId = productId;
		this.tasteId = tasteId;
		this.packageId = packageId;
		this.seqNo = seqNo;
		this.trQty = trQty;
		this.trList = trList;
		this.trPrice = trPrice;
		this.trSold = trSold;
		this.trCost = trCost;
		this.trDiscount = trDiscount;
		this.preDeposit = preDeposit;
		this.thisDeposit = thisDeposit;
		this.visa = visa;
		this.cash = cash;
		this.sales = sales;
		this.shift = shift;
		this.discAtm = discAtm;
		this.mId = mId;
		this.iuser = iuser;
		this.idate = idate;
		this.itime = itime;
		this.muser = muser;
		this.mdate = mdate;
		this.mtime = mtime;
	}

	public String getCoSqe() {
		return coSqe;
	}

	public void setCoSqe(String coSqe) {
		this.coSqe = coSqe;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTasteId() {
		return tasteId;
	}

	public void setTasteId(String tasteId) {
		this.tasteId = tasteId;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public int getTrQty() {
		return trQty;
	}

	public void setTrQty(int trQty) {
		this.trQty = trQty;
	}

	public double getTrList() {
		return trList;
	}

	public void setTrList(double trList) {
		this.trList = trList;
	}

	public double getTrPrice() {
		return trPrice;
	}

	public void setTrPrice(double trPrice) {
		this.trPrice = trPrice;
	}

	public double getTrSold() {
		return trSold;
	}

	public void setTrSold(double trSold) {
		this.trSold = trSold;
	}

	public double getTrCost() {
		return trCost;
	}

	public void setTrCost(double trCost) {
		this.trCost = trCost;
	}

	public double getTrDiscount() {
		return trDiscount;
	}

	public void setTrDiscount(double trDiscount) {
		this.trDiscount = trDiscount;
	}

	public double getPreDeposit() {
		return preDeposit;
	}

	public void setPreDeposit(double preDeposit) {
		this.preDeposit = preDeposit;
	}

	public double getThisDeposit() {
		return thisDeposit;
	}

	public void setThisDeposit(double thisDeposit) {
		this.thisDeposit = thisDeposit;
	}

	public double getVisa() {
		return visa;
	}

	public void setVisa(double visa) {
		this.visa = visa;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public double getDiscAtm() {
		return discAtm;
	}

	public void setDiscAtm(double discAtm) {
		this.discAtm = discAtm;
	}

	public String getMid() {
		return mId;
	}

	public void setMid(String mId) {
		this.mId = mId;
	}

	public String getIuser() {
		return iuser;
	}

	public void setIuser(String iuser) {
		this.iuser = iuser;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getItime() {
		return itime;
	}

	public void setItime(String itime) {
		this.itime = itime;
	}

	public String getMuser() {
		return muser;
	}

	public void setMuser(String muser) {
		this.muser = muser;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	
}