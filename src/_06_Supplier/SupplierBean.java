package _06_Supplier;

import java.io.Serializable;

public class SupplierBean implements Serializable {
	private String supplier_id;
	private String name;
	private String telephone;
	private String zipNo;
	private String address;
	private String fax;
	private String email;
	private String url;
	private String principal_Name;
	private String contact_Name;
	
	public SupplierBean(){
		
	}

	public SupplierBean(String supplier_id, String name, String telephone, String zipNo, String address, String fax,
			String email, String url, String principal_Name, String contact_Name) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
		this.telephone = telephone;
		this.zipNo = zipNo;
		this.address = address;
		this.fax = fax;
		this.email = email;
		this.url = url;
		this.principal_Name = principal_Name;
		this.contact_Name = contact_Name;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
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

	public String getPrincipal_Name() {
		return principal_Name;
	}

	public void setPrincipal_Name(String principal_Name) {
		this.principal_Name = principal_Name;
	}

	public String getContact_Name() {
		return contact_Name;
	}

	public void setContact_Name(String contact_Name) {
		this.contact_Name = contact_Name;
	}
	
	
}