package dsmsys.pojo;

public class Car {
	private Integer cFlag;
	private String cId;
	private String cImg;
	private Integer cStatus;
	private String cRemark;
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcImg() {
		return cImg;
	}
	public void setcImg(String cImg) {
		this.cImg = cImg;
	}
	
	public Integer getcStatus() {
		return cStatus;
	}
	public void setcStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}
	public String getcRemark() {
		return cRemark;
	}
	public void setcRemark(String cRemark) {
		this.cRemark = cRemark;
	}
	public Integer getcFlag() {
		return cFlag;
	}
	public void setcFlag(Integer cFlag) {
		this.cFlag = cFlag;
	}
	@Override
	public String toString() {
		return "Car [cFlag=" + cFlag + ", cId=" + cId + ", cImg=" + cImg + ", cStatus=" + cStatus + ", cRemark="
				+ cRemark + "]";
	}

}
