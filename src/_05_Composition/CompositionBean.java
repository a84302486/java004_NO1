package _05_Composition;

import java.io.Serializable;

public class CompositionBean implements Serializable {
	private String comType;
	private String comId;
	private String comDescription;
	
	public CompositionBean(){
		
	}

	public CompositionBean(String comType, String comId, String comDescription) {
		super();
		this.comType = comType;
		this.comId = comId;
		this.comDescription = comDescription;
	}

	public String getComType() {
		return comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getComDescription() {
		return comDescription;
	}

	public void setComDescription(String comDescription) {
		this.comDescription = comDescription;
	}
	
}