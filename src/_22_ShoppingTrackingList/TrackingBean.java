package _22_ShoppingTrackingList;

public class TrackingBean {
	private String username;
	private String producid;
	
	public TrackingBean() {
	}

	public TrackingBean(String username, String producid) {
		this.username = username;
		this.producid = producid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProducid() {
		return producid;
	}

	public void setProducid(String producid) {
		this.producid = producid;
	}

}
