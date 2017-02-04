package _02_Taste;

import java.io.Serializable;

public class TasteBean implements Serializable {
	private String taste_id;
	private String taste_name;
	
	public TasteBean(){
		
	}

	public TasteBean(String taste_id, String taste_name) {
		super();
		this.taste_id = taste_id;
		this.taste_name = taste_name;
	}

	public String getTaste_id() {
		return taste_id;
	}

	public void setTaste_id(String taste_id) {
		this.taste_id = taste_id;
	}

	public String getTaste_name() {
		return taste_name;
	}

	public void setTaste_name(String taste_name) {
		this.taste_name = taste_name;
	}
	
}
	