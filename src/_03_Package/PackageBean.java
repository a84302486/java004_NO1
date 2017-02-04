package _03_Package;

import java.io.Serializable;

public class PackageBean implements Serializable {
	private String package_id;
	private String package_name;
	
	public PackageBean(){
		
	}

	public PackageBean(String package_id, String package_name) {
		super();
		this.package_id = package_id;
		this.package_name = package_name;
	}

	public String getPackage_id() {
		return package_id;
	}

	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}
	
}
	