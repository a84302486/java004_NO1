package _13_TRDT;

import java.io.Serializable;

public class TRDTBean implements Serializable {
	private String co_sqe;		
	private String co_type; 		
	private String co_role; 		
	private String co_year;			
	private String co_month;		
	private String min_role;		
	private String tr_date;			
	private String product_id;		
	private String taste_id;		
	private String package_id;		
	private int seq_no;			
	private int tr_qty;			
	private double tr_list;			
	private double tr_price;		
	private double tr_sold;			
	private double tr_cost;			
	private double tr_discount;		
	private double pre_deposit;		
	private double this_deposit;	
	private double visa;			
	private double cash;			
	private String sales;			
	private String shift;			
	private double disc_atm;		
	private String m_id;			
	private String iuser;			
	private String idate;			
	private String itime;			
	private String muser;			
	private String mdate;			
	private String mtime;			
	
	public TRDTBean(){
		
	}

	public TRDTBean(String co_sqe, String co_type, String co_role, String co_year, String co_month, String min_role,
			String tr_date, String product_id, String taste_id, String package_id, int seq_no, int tr_qty,
			double tr_list, double tr_price, double tr_sold, double tr_cost, double tr_discount, double pre_deposit,
			double this_deposit, double visa, double cash, String sales, String shift, double disc_atm, String m_id,
			String iuser, String idate, String itime, String muser, String mdate, String mtime) {
		super();
		this.co_sqe = co_sqe;
		this.co_type = co_type;
		this.co_role = co_role;
		this.co_year = co_year;
		this.co_month = co_month;
		this.min_role = min_role;
		this.tr_date = tr_date;
		this.product_id = product_id;
		this.taste_id = taste_id;
		this.package_id = package_id;
		this.seq_no = seq_no;
		this.tr_qty = tr_qty;
		this.tr_list = tr_list;
		this.tr_price = tr_price;
		this.tr_sold = tr_sold;
		this.tr_cost = tr_cost;
		this.tr_discount = tr_discount;
		this.pre_deposit = pre_deposit;
		this.this_deposit = this_deposit;
		this.visa = visa;
		this.cash = cash;
		this.sales = sales;
		this.shift = shift;
		this.disc_atm = disc_atm;
		this.m_id = m_id;
		this.iuser = iuser;
		this.idate = idate;
		this.itime = itime;
		this.muser = muser;
		this.mdate = mdate;
		this.mtime = mtime;
	}

	public String getCo_sqe() {
		return co_sqe;
	}

	public void setCo_sqe(String co_sqe) {
		this.co_sqe = co_sqe;
	}

	public String getCo_type() {
		return co_type;
	}

	public void setCo_type(String co_type) {
		this.co_type = co_type;
	}

	public String getCo_role() {
		return co_role;
	}

	public void setCo_role(String co_role) {
		this.co_role = co_role;
	}

	public String getCo_year() {
		return co_year;
	}

	public void setCo_year(String co_year) {
		this.co_year = co_year;
	}

	public String getCo_month() {
		return co_month;
	}

	public void setCo_month(String co_month) {
		this.co_month = co_month;
	}

	public String getMin_role() {
		return min_role;
	}

	public void setMin_role(String min_role) {
		this.min_role = min_role;
	}

	public String getTr_date() {
		return tr_date;
	}

	public void setTr_date(String tr_date) {
		this.tr_date = tr_date;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getTaste_id() {
		return taste_id;
	}

	public void setTaste_id(String taste_id) {
		this.taste_id = taste_id;
	}

	public String getPackage_id() {
		return package_id;
	}

	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}

	public int getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}

	public int getTr_qty() {
		return tr_qty;
	}

	public void setTr_qty(int tr_qty) {
		this.tr_qty = tr_qty;
	}

	public double getTr_list() {
		return tr_list;
	}

	public void setTr_list(double tr_list) {
		this.tr_list = tr_list;
	}

	public double getTr_price() {
		return tr_price;
	}

	public void setTr_price(double tr_price) {
		this.tr_price = tr_price;
	}

	public double getTr_sold() {
		return tr_sold;
	}

	public void setTr_sold(double tr_sold) {
		this.tr_sold = tr_sold;
	}

	public double getTr_cost() {
		return tr_cost;
	}

	public void setTr_cost(double tr_cost) {
		this.tr_cost = tr_cost;
	}

	public double getTr_discount() {
		return tr_discount;
	}

	public void setTr_discount(double tr_discount) {
		this.tr_discount = tr_discount;
	}

	public double getPre_deposit() {
		return pre_deposit;
	}

	public void setPre_deposit(double pre_deposit) {
		this.pre_deposit = pre_deposit;
	}

	public double getThis_deposit() {
		return this_deposit;
	}

	public void setThis_deposit(double this_deposit) {
		this.this_deposit = this_deposit;
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

	public double getDisc_atm() {
		return disc_atm;
	}

	public void setDisc_atm(double disc_atm) {
		this.disc_atm = disc_atm;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
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