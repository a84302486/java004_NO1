package _05_Composition;

import java.io.Serializable;

public class CompositionBean implements Serializable {
	private String com_type;
	private String com_id;
	private String com_description;
	
	public CompositionBean(){
		
	}

	public CompositionBean(String com_type, String com_id, String com_description) {
		super();
		this.com_type = com_type;
		this.com_id = com_id;
		this.com_description = com_description;
	}

	public String getCom_type() {
		return com_type;
	}

	public void setCom_type(String com_type) {
		this.com_type = com_type;
	}

	public String getCom_id() {
		return com_id;
	}

	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}

	public String getCom_description() {
		return com_description;
	}

	public void setCom_description(String com_description) {
		this.com_description = com_description;
	}
	
}