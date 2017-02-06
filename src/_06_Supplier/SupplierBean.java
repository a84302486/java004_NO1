package _06_Supplier;

import java.io.Serializable;

public class SupplierBean implements Serializable {
	private String supplierId;
	private String name;
	private String telephone;
	private String zipNo;
	private String address;
	private String fax;
	private String email;
	private String url;
	private String principalName;
	private String contactName;
	
	public SupplierBean(){
		
	}

	public SupplierBean(String supplierId, String name, String telephone, String zipNo, String address, String fax,
			String email, String url, String principalName, String contactName) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.telephone = telephone;
		this.zipNo = zipNo;
		this.address = address;
		this.fax = fax;
		this.email = email;
		this.url = url;
		this.principalName = principalName;
		this.contactName = contactName;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getZipNo() {
		return zipNo;
	}

	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	
}