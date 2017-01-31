package _14_Member;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String M_ID;	
	String M_Username;
	String M_Password;			
	String M_Name;
	String M_Nick;
	String M_Sex;
	String M_Birthday;
	String M_EMail;
	String M_Phone;
	String M_Cellphone;
	String M_Address;
	String M_Line;
	String M_FaceBook;
	String M_IdentityCard;			
	String M_Invoice;		
	String M_UniformNumber;		
	String M_Joindate;			
	
	
	public MemberBean(String m_ID, String m_Username, String m_Password, String m_Name, String m_Nick, String m_Sex,
			String m_Birthday, String m_EMail, String m_Phone, String m_Cellphone, String m_Address, String m_Line,
			String m_FaceBook, String m_IdentityCard, String m_Invoice, String m_UniformNumber, String m_Joindate
			) {
		super();
		M_ID = m_ID;
		M_Username = m_Username;
		M_Password = m_Password;
		M_Name = m_Name;
		M_Nick = m_Nick;
		M_Sex = m_Sex;
		M_Birthday = m_Birthday;
		M_EMail = m_EMail;
		M_Phone = m_Phone;
		M_Cellphone = m_Cellphone;
		M_Address = m_Address;
		M_Line = m_Line;
		M_FaceBook = m_FaceBook;
		M_IdentityCard = m_IdentityCard;
		M_Invoice = m_Invoice;
		M_UniformNumber = m_UniformNumber;
		M_Joindate = m_Joindate;
	
	}
	
	public MemberBean(){
		
	}
	

	public String getM_ID() {
		return M_ID;
	}

	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}

	public String getM_Username() {
		return M_Username;
	}

	public void setM_Username(String m_Username) {
		M_Username = m_Username;
	}

	public String getM_Password() {
		return M_Password;
	}

	public void setM_Password(String m_Password) {
		M_Password = m_Password;
	}

	public String getM_Name() {
		return M_Name;
	}

	public void setM_Name(String m_Name) {
		M_Name = m_Name;
	}

	public String getM_Nick() {
		return M_Nick;
	}

	public void setM_Nick(String m_Nick) {
		M_Nick = m_Nick;
	}

	public String getM_Sex() {
		return M_Sex;
	}

	public void setM_Sex(String m_Sex) {
		M_Sex = m_Sex;
	}

	public String getM_Birthday() {
		return M_Birthday;
	}

	public void setM_Birthday(String m_Birthday) {
		M_Birthday = m_Birthday;
	}

	public String getM_EMail() {
		return M_EMail;
	}

	public void setM_EMail(String m_EMail) {
		M_EMail = m_EMail;
	}

	public String getM_Phone() {
		return M_Phone;
	}

	public void setM_Phone(String m_Phone) {
		M_Phone = m_Phone;
	}

	public String getM_Cellphone() {
		return M_Cellphone;
	}

	public void setM_Cellphone(String m_Cellphone) {
		M_Cellphone = m_Cellphone;
	}

	public String getM_Address() {
		return M_Address;
	}

	public void setM_Address(String m_Address) {
		M_Address = m_Address;
	}

	public String getM_Line() {
		return M_Line;
	}

	public void setM_Line(String m_Line) {
		M_Line = m_Line;
	}

	public String getM_FaceBook() {
		return M_FaceBook;
	}

	public void setM_FaceBook(String m_FaceBook) {
		M_FaceBook = m_FaceBook;
	}

	public String getM_IdentityCard() {
		return M_IdentityCard;
	}

	public void setM_IdentityCard(String m_IdentityCard) {
		M_IdentityCard = m_IdentityCard;
	}

	public String getM_Invoice() {
		return M_Invoice;
	}

	public void setM_Invoice(String m_Invoice) {
		M_Invoice = m_Invoice;
	}

	public String getM_UniformNumber() {
		return M_UniformNumber;
	}

	public void setM_UniformNumber(String m_UniformNumber) {
		M_UniformNumber = m_UniformNumber;
	}

	public String getM_Joindate() {
		return M_Joindate;
	}

	public void setM_Joindate(String m_Joindate) {
		M_Joindate = m_Joindate;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
