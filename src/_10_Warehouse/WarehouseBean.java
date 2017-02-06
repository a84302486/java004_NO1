package _10_Warehouse;

import java.io.Serializable;

public class WarehouseBean implements Serializable {

	private int wId;
	private String customerId;
	private String productId;
	private String tasteId;
	private String packageId;
	private int stock;
	private int acREC;
	private int acRET;
	private int acSAL;
	private int acBAD;
	private int acBAL;
	private String mfd;

	public WarehouseBean() {

	}

	public WarehouseBean(int wId, String customerId, String productId, String tasteId, String packageId, int stock,
			int acREC, int acRET, int acSAL, int acBAD, int acBAL, String mfd) {
		super();
		this.wId = wId;
		this.customerId = customerId;
		this.productId = productId;
		this.tasteId = tasteId;
		this.packageId = packageId;
		this.stock = stock;
		this.acREC = acREC;
		this.acRET = acRET;
		this.acSAL = acSAL;
		this.acBAD = acBAD;
		this.acBAL = acBAL;
		this.mfd = mfd;
	}

	public int getwId() {
		return wId;
	}

	public void setwId(int wId) {
		this.wId = wId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getAcREC() {
		return acREC;
	}

	public void setAcREC(int acREC) {
		this.acREC = acREC;
	}

	public int getAcRET() {
		return acRET;
	}

	public void setAcRET(int acRET) {
		this.acRET = acRET;
	}

	public int getAcSAL() {
		return acSAL;
	}

	public void setAcSAL(int acSAL) {
		this.acSAL = acSAL;
	}

	public int getAcBAD() {
		return acBAD;
	}

	public void setAcBAD(int acBAD) {
		this.acBAD = acBAD;
	}

	public int getAcBAL() {
		return acBAL;
	}

	public void setAcBAL(int acBAL) {
		this.acBAL = acBAL;
	}

	public String getMfd() {
		return mfd;
	}

	public void setMfd(String mfd) {
		this.mfd = mfd;
	}
	
}