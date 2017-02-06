package _03_Package;

import java.io.Serializable;

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

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	

	
}
	