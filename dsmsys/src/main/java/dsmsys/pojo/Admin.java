package dsmsys.pojo;

public class Admin {

	private Integer admId;
	private String admName;
	private String admMobile;
	private String admPassword;
	private Integer admAccess;
	public Integer getAdmId() {
		return admId;
	}
	public void setAdmId(Integer admId) {
		this.admId = admId;
	}
	public String getAdmMobile() {
		return admMobile;
	}
	public void setAdmMobile(String admMobile) {
		this.admMobile = admMobile;
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}
	public Integer getAdmAccess() {
		return admAccess;
	}
	public void setAdmAccess(Integer admAccess) {
		this.admAccess = admAccess;
	}
	
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	@Override
	public String toString() {
		return "Admin [admId=" + admId + ", admName=" + admName + ", admMobile=" + admMobile + ", admPassword="
				+ admPassword + ", admAccess=" + admAccess + "]";
	}

	
}
