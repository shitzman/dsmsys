package dsmsys.pojo;

import java.util.List;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class Student {
	
	private Integer sId;
	@Null
	@Size(min=15,max=18)
	private String sNumber;
	@Null
	@Size(min=2,max=10)
	private String sName;
	@Null
	@Size(min=1,max=1)
	private String sSex;
	private Integer tId;
	@Null
	@Size(min=7,max=11)
	private String sMobile;
	private Integer sCurrent;
	private Integer sAccount;
	private String sPassword;
	private Integer sStatus;
	private String sRegTime;
	private String sExTime;
	private String sAddress;
	
	private List<Integer> tIdList;//存储学员当前科目可选择教练列表

	
	public Integer getsId() {
		return sId;
	}


	public void setsId(Integer sId) {
		this.sId = sId;
	}


	public String getsNumber() {
		return sNumber;
	}


	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public String getsSex() {
		return sSex;
	}


	public void setsSex(String sSex) {
		this.sSex = sSex;
	}


	public Integer gettId() {
		return tId;
	}


	public void settId(Integer tId) {
		this.tId = tId;
	}


	public String getsMobile() {
		return sMobile;
	}


	public void setsMobile(String sMobile) {
		this.sMobile = sMobile;
	}


	public Integer getsCurrent() {
		return sCurrent;
	}


	public void setsCurrent(Integer sCurrent) {
		this.sCurrent = sCurrent;
	}


	public Integer getsAccount() {
		return sAccount;
	}


	public void setsAccount(Integer sAccount) {
		this.sAccount = sAccount;
	}


	public String getsPassword() {
		return sPassword;
	}


	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}


	public Integer getsStatus() {
		return sStatus;
	}


	public void setsStatus(Integer sStatus) {
		this.sStatus = sStatus;
	}


	public String getsRegTime() {
		return sRegTime;
	}


	public void setsRegTime(String sRegTime) {
		this.sRegTime = sRegTime;
	}


	public String getsExTime() {
		return sExTime;
	}


	public void setsExTime(String sExTime) {
		this.sExTime = sExTime;
	}


	public String getsAddress() {
		return sAddress;
	}


	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}


	public List<Integer> gettIdList() {
		return tIdList;
	}


	public void settIdList(List<Integer> tIdList) {
		this.tIdList = tIdList;
	}


	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sNumber=" + sNumber + ", sName=" + sName + ", sSex=" + sSex + ", tId=" + tId
				+ ", sMobile=" + sMobile + ", sCurrent=" + sCurrent + ", sAccount=" + sAccount + ", sPassword="
				+ sPassword + ", sStatus=" + sStatus + ", sRegTime=" + sRegTime + ", sExTime=" + sExTime + ", sAddress="
				+ sAddress + ", tIdList=" + tIdList + "]";
	}
	

}
