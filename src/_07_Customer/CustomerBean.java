package _07_Customer;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String Customer_id;	
	private String Simple_Name;
	private String Name;			
	private String Sale_Path;
	private String Telephone;
	private String Fax;
	private String Contacter;
	private String Address;
	private String Uniform_NO;
	private String This_Invertory_Date;
	private String Last_Invertory_Date;
	private String PR_Status;
	private String Current_Discount_id;
	private String Next_Discount_id;			
	private String Tax_Type;		
	private String URL;		
	private String Principal_Name;
	private String Contact_Name;
	private String Email;
	private String Line;
	private String Skype;
	
	public CustomerBean(){
		
	}
	
	public CustomerBean(String customer_id, String simple_Name, String name, String sale_Path, String telephone,
			String fax, String contacter, String address, String uniform_NO, String this_Invertory_Date,
			String last_Invertory_Date, String pR_Status, String current_Discount_id, String next_Discount_id,
			String tax_Type, String uRL, String principal_Name, String contact_Name, String email, String line,
			String skype) {
		super();
		Customer_id = customer_id;
		Simple_Name = simple_Name;
		Name = name;
		Sale_Path = sale_Path;
		Telephone = telephone;
		Fax = fax;
		Contacter = contacter;
		Address = address;
		Uniform_NO = uniform_NO;
		This_Invertory_Date = this_Invertory_Date;
		Last_Invertory_Date = last_Invertory_Date;
		PR_Status = pR_Status;
		Current_Discount_id = current_Discount_id;
		Next_Discount_id = next_Discount_id;
		Tax_Type = tax_Type;
		URL = uRL;
		Principal_Name = principal_Name;
		Contact_Name = contact_Name;
		Email = email;
		Line = line;
		Skype = skype;
	}

	public String getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(String customer_id) {
		Customer_id = customer_id;
	}

	public String getSimple_Name() {
		return Simple_Name;
	}

	public void setSimple_Name(String simple_Name) {
		Simple_Name = simple_Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSale_Path() {
		return Sale_Path;
	}

	public void setSale_Path(String sale_Path) {
		Sale_Path = sale_Path;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getContacter() {
		return Contacter;
	}

	public void setContacter(String contacter) {
		Contacter = contacter;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getUniform_NO() {
		return Uniform_NO;
	}

	public void setUniform_NO(String uniform_NO) {
		Uniform_NO = uniform_NO;
	}

	public String getThis_Invertory_Date() {
		return This_Invertory_Date;
	}

	public void setThis_Invertory_Date(String this_Invertory_Date) {
		This_Invertory_Date = this_Invertory_Date;
	}

	public String getLast_Invertory_Date() {
		return Last_Invertory_Date;
	}

	public void setLast_Invertory_Date(String last_Invertory_Date) {
		Last_Invertory_Date = last_Invertory_Date;
	}

	public String getPR_Status() {
		return PR_Status;
	}

	public void setPR_Status(String pR_Status) {
		PR_Status = pR_Status;
	}

	public String getCurrent_Discount_id() {
		return Current_Discount_id;
	}

	public void setCurrent_Discount_id(String current_Discount_id) {
		Current_Discount_id = current_Discount_id;
	}

	public String getNext_Discount_id() {
		return Next_Discount_id;
	}

	public void setNext_Discount_id(String next_Discount_id) {
		Next_Discount_id = next_Discount_id;
	}

	public String getTax_Type() {
		return Tax_Type;
	}

	public void setTax_Type(String tax_Type) {
		Tax_Type = tax_Type;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getPrincipal_Name() {
		return Principal_Name;
	}

	public void setPrincipal_Name(String principal_Name) {
		Principal_Name = principal_Name;
	}

	public String getContact_Name() {
		return Contact_Name;
	}

	public void setContact_Name(String contact_Name) {
		Contact_Name = contact_Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLine() {
		return Line;
	}

	public void setLine(String line) {
		Line = line;
	}

	public String getSkype() {
		return Skype;
	}

	public void setSkype(String skype) {
		Skype = skype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
