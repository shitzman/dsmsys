package dsmsys.pojo;


public class Teacher {
	
	private Integer tId;
	private String cId;
	private String tName;
	private String tSex;
	private Integer tSubject;
	private String tImg;
	
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettSex() {
		return tSex;
	}
	public void settSex(String tSex) {
		this.tSex = tSex;
	}
	public Integer gettSubject() {
		return tSubject;
	}
	public void settSubject(Integer tSubject) {
		this.tSubject = tSubject;
	}
	public String gettImg() {
		return tImg;
	}
	public void settImg(String tImg) {
		this.tImg = tImg;
	}
	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", cId=" + cId + ", tName=" + tName + ", tSex=" + tSex + ", tSubject=" + tSubject
				+ ", tImg=" + tImg + "]";
	}

	
}
