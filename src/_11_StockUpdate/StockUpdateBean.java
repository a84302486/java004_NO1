package _11_StockUpdate;

import java.io.Serializable;

public class StockUpdateBean implements Serializable {

//	private int cpId;
	private String cpDate;
	private int cpREC;
	private int cpRET;
	private int cpSAL;
	private int cpBAD;
	private int cpBAL;
	private int endStock;
	private int netStock;

	public StockUpdateBean() {

	}

	public StockUpdateBean( String cpDate, int cpREC, int cpRET, int cpSAL, int cpBAD, int cpBAL, int endStock,
			int netStock) {
		super();
//		this.cpId = cpId;
		this.cpDate = cpDate;
		this.cpREC = cpREC;
		this.cpRET = cpRET;
		this.cpSAL = cpSAL;
		this.cpBAD = cpBAD;
		this.cpBAL = cpBAL;
		this.endStock = endStock;
		this.netStock = netStock;
	}

//	public int getCpId() {
//		return cpId;
//	}

//	public void setCpId(int cpId) {
//		this.cpId = cpId;
//	}

	public String getCpDate() {
		return cpDate;
	}

	public void setCpDate(String cpDate) {
		this.cpDate = cpDate;
	}

	public int getCpREC() {
		return cpREC;
	}

	public void setCpREC(int cpREC) {
		this.cpREC = cpREC;
	}

	public int getCpRET() {
		return cpRET;
	}

	public void setCpRET(int cpRET) {
		this.cpRET = cpRET;
	}

	public int getCpSAL() {
		return cpSAL;
	}

	public void setCpSAL(int cpSAL) {
		this.cpSAL = cpSAL;
	}

	public int getCpBAD() {
		return cpBAD;
	}

	public void setCpBAD(int cpBAD) {
		this.cpBAD = cpBAD;
	}

	public int getCpBAL() {
		return cpBAL;
	}

	public void setCpBAL(int cpBAL) {
		this.cpBAL = cpBAL;
	}

	public int getEndStock() {
		return endStock;
	}

	public void setEndStock(int endStock) {
		this.endStock = endStock;
	}

	public int getNetStock() {
		return netStock;
	}

	public void setNetStock(int netStock) {
		this.netStock = netStock;
	}
	
	
}	