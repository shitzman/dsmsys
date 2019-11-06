package dsmsys.pojo;

public class ExamOrder {
	private Integer sId;
	private Integer eNum;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public Integer geteNum() {
		return eNum;
	}
	public void seteNum(Integer eNum) {
		this.eNum = eNum;
	}
	@Override
	public String toString() {
		return "Order [sId=" + sId + ", eNum=" + eNum + "]";
	}
	
	
	

}
