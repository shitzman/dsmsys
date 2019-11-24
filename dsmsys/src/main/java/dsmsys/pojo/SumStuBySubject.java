package dsmsys.pojo;

public class SumStuBySubject {
	
	private Integer subject;
	private Integer sum;
	public Integer getSubject() {
		return subject;
	}
	public void setSubject(Integer subject) {
		this.subject = subject;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "SumStuBySubject [subject=" + subject + ", sum=" + sum + "]";
	}

}
