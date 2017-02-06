package _07_Customer;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String customerId;	
	private String simpleName;
	private String name;			
	private String salePath;
	private String telephone;
	private String fax;
	private String contacter;
	private String address;
	private String uniformNO;
	private String thisInvertoryDate;
	private String lastInvertoryDate;
	private String prStatus;
	private String currentDiscountId;
	private String nextDiscountId;			
	private String taxType;		
	private String url;		
	private String principalName;
	private String contactName;
	private String email;
	private String line;
	private String skype;
	
	public CustomerBean(){
		
	}

	public CustomerBean(String customerId, String simpleName, String name, String salePath, String telephone,
			String fax, String contacter, String address, String uniformNO, String thisInvertoryDate,
			String lastInvertoryDate, String prStatus, String currentDiscountId, String nextDiscountId, String taxType,
			String url, String principalName, String contactName, String email, String line, String skype) {
		super();
		this.customerId = customerId;
		this.simpleName = simpleName;
		this.name = name;
		this.salePath = salePath;
		this.telephone = telephone;
		this.fax = fax;
		this.contacter = contacter;
		this.address = address;
		this.uniformNO = uniformNO;
		this.thisInvertoryDate = thisInvertoryDate;
		this.lastInvertoryDate = lastInvertoryDate;
		this.prStatus = prStatus;
		this.currentDiscountId = currentDiscountId;
		this.nextDiscountId = nextDiscountId;
		this.taxType = taxType;
		this.url = url;
		this.principalName = principalName;
		this.contactName = contactName;
		this.email = email;
		this.line = line;
		this.skype = skype;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalePath() {
		return salePath;
	}

	public void setSalePath(String salePath) {
		this.salePath = salePath;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUniformNO() {
		return uniformNO;
	}

	public void setUniformNO(String uniformNO) {
		this.uniformNO = uniformNO;
	}

	public String getThisInvertoryDate() {
		return thisInvertoryDate;
	}

	public void setThisInvertoryDate(String thisInvertoryDate) {
		this.thisInvertoryDate = thisInvertoryDate;
	}

	public String getLastInvertoryDate() {
		return lastInvertoryDate;
	}

	public void setLastInvertoryDate(String lastInvertoryDate) {
		this.lastInvertoryDate = lastInvertoryDate;
	}

	public String getPrStatus() {
		return prStatus;
	}

	public void setPrStatus(String prStatus) {
		this.prStatus = prStatus;
	}

	public String getCurrentDiscountId() {
		return currentDiscountId;
	}

	public void setCurrentDiscountId(String currentDiscountId) {
		this.currentDiscountId = currentDiscountId;
	}

	public String getNextDiscountId() {
		return nextDiscountId;
	}

	public void setNextDiscountId(String nextDiscountId) {
		this.nextDiscountId = nextDiscountId;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
