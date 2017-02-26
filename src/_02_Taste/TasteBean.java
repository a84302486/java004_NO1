package _02_Taste;

public class TasteBean  {
	private String tasteId;
	private String tasteName;
	
	public TasteBean(){
		
	}

	public TasteBean(String tasteId, String tasteName) {
		super();
		this.tasteId = tasteId;
		this.tasteName = tasteName;
	}

	public String getTasteId() {
		return tasteId;
	}

	public void setTasteId(String tasteId) {
		this.tasteId = tasteId;
	}

	public String getTasteName() {
		return tasteName;
	}

	public void setTasteName(String tasteName) {
		this.tasteName = tasteName;
	}
	
}
	