package dsmsys.pojo;

public class Remark {

	private Integer sId;
	private Integer eId;
	private Integer rStatus;
	private Integer rScore;
	private String rRemark;
	private Exammsg exammsg;
	private Student student;
	
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public Integer getrStatus() {
		return rStatus;
	}
	public void setrStatus(Integer rStatus) {
		this.rStatus = rStatus;
	}
	public Integer getrScore() {
		return rScore;
	}
	public void setrScore(Integer rScore) {
		this.rScore = rScore;
	}
	public String getrRemark() {
		return rRemark;
	}
	public void setrRemark(String rRemark) {
		this.rRemark = rRemark;
	}
	public Exammsg getExammsg() {
		return exammsg;
	}
	public void setExammsg(Exammsg exammsg) {
		this.exammsg = exammsg;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Remark [sId=" + sId + ", eId=" + eId + ", rStatus=" + rStatus + ", rScore=" + rScore + ", rRemark="
				+ rRemark + ", exammsg=" + exammsg + ", student=" + student + "]";
	}
	
}
