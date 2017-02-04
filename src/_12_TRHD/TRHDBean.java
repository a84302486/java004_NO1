package _12_TRHD;

import java.io.Serializable;

public class TRHDBean implements Serializable {
	
	private String co_seq;			
	private String co_type; 		
	private String co_role; 		
	private String co_year;			
	private String co_month;		
	private String min_role;		
	private String tr_date;			
	private int seq_no;			
	private int to_qty;			
	private double to_list;			
	private double to_price;		
	private double to_sold;			
	private double to_cost;			
	private double to_disc;			
	 
	public TRHDBean(){
		
	}

	public TRHDBean(String co_seq, String co_type, String co_role, String co_year, String co_month, String min_role,
			String tr_date, int seq_no, int to_qty, double to_list, double to_price, double to_sold, double to_cost,
			double to_disc) {
		super();
		this.co_seq = co_seq;
		this.co_type = co_type;
		this.co_role = co_role;
		this.co_year = co_year;
		this.co_month = co_month;
		this.min_role = min_role;
		this.tr_date = tr_date;
		this.seq_no = seq_no;
		this.to_qty = to_qty;
		this.to_list = to_list;
		this.to_price = to_price;
		this.to_sold = to_sold;
		this.to_cost = to_cost;
		this.to_disc = to_disc;
	}

	public String getCo_seq() {
		return co_seq;
	}

	public void setCo_seq(String co_seq) {
		this.co_seq = co_seq;
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

	public int getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}

	public int getTo_qty() {
		return to_qty;
	}

	public void setTo_qty(int to_qty) {
		this.to_qty = to_qty;
	}

	public double getTo_list() {
		return to_list;
	}

	public void setTo_list(double to_list) {
		this.to_list = to_list;
	}

	public double getTo_price() {
		return to_price;
	}

	public void setTo_price(double to_price) {
		this.to_price = to_price;
	}

	public double getTo_sold() {
		return to_sold;
	}

	public void setTo_sold(double to_sold) {
		this.to_sold = to_sold;
	}

	public double getTo_cost() {
		return to_cost;
	}

	public void setTo_cost(double to_cost) {
		this.to_cost = to_cost;
	}

	public double getTo_disc() {
		return to_disc;
	}

	public void setTo_disc(double to_disc) {
		this.to_disc = to_disc;
	}
	
}