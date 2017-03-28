package _02_TasteHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taste")
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
	
	@Id
	@Column(columnDefinition="varchar(4) not null")
	public String getTasteId() {
		return tasteId;
	}

	public void setTasteId(String tasteId) {
		this.tasteId = tasteId;
	}
	
	@Column(columnDefinition="varchar(60)")
	public String getTasteName() {
		return tasteName;
	}

	public void setTasteName(String tasteName) {
		this.tasteName = tasteName;
	}
	
}
	