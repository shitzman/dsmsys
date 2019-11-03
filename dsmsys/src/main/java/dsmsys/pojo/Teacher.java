package dsmsys.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Teacher {
	
	private Integer tId;
	@Min(value = 0,message="请输入正确的车辆id")
	private Integer cId;
	@NotNull
	@Size(min=1,max=10,message="用户名错误")
	private String tName;
	@NotNull
	@Size(max=2)
	private String tSex;
	private Integer tSubject;
	private String tImg;
	
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
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
