package _03_PackageHibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="package")
public class PackageBean implements Serializable {
	private String packageId;
	private String packageName;
	
	public PackageBean(){
		
	}

	public PackageBean(String packageId, String packageName) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
	}
	
	@Id
	@Column(columnDefinition="varchar(20) not null")
	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
	@Column(columnDefinition="varchar(60)")
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	

	
}
	