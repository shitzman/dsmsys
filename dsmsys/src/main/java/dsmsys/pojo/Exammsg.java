package dsmsys.pojo;

public class Exammsg {

	private Integer eNum;
	private String eTime;
	private Integer eSubject;
	private String eAddress;
	private Integer eAllNum;
	private Integer eAlrNum;
	public Integer geteNum() {
		return eNum;
	}
	public void seteNum(Integer eNum) {
		this.eNum = eNum;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
	public Integer geteSubject() {
		return eSubject;
	}
	public void seteSubject(Integer eSubject) {
		this.eSubject = eSubject;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	public Integer geteAllNum() {
		return eAllNum;
	}
	public void seteAllNum(Integer eAllNum) {
		this.eAllNum = eAllNum;
	}
	public Integer geteAlrNum() {
		return eAlrNum;
	}
	public void seteAlrNum(Integer eAlrNum) {
		this.eAlrNum = eAlrNum;
	}
	@Override
	public String toString() {
		return "Exammsg [eNum=" + eNum + ", eTime=" + eTime + ", eSubject=" + eSubject + ", eAddress=" + eAddress
				+ ", eAllNum=" + eAllNum + ", eAlrNum=" + eAlrNum + "]";
	}
	
	
}
