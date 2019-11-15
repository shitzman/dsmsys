package dsmsys.service;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Admin;
import dsmsys.pojo.Remark;

public interface AdminService {
	
	Admin getAdminByMobileAndPwd(@Param("admMobile") String admMobile, @Param("admPassword") String AdmPassword);

	//管理员审批学员考试申请操作（同意）
	int ratifyExamYes(Integer sId, Integer eId);
	
	//管理员审批学员考试申请操作（拒绝）
	int ratifyExamNo(Integer sId);
	
	//管理员录入学员考试信息操作（过关）
	int changeRemarkAndStuPass(Remark remark);
	
	//管理员录入学员考试信息操作（挂科）
	int changeRemarkAndStuFail(Remark remark);
}
