package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Remark;
import dsmsys.pojo.Student;

public interface StudentDao {

	Student getStudentBySid(Integer sId);
	
	List<Student> getAllStudent();
	
	int addStudent(Student student);
	
	//登录
	Student getStudentByMobileAndPwd(@Param("sMobile")String sMobile, @Param("sPassword")String sPasssword);

	//根据用户账户状态（0：不可用，1：管理员审批可用）
	List<Student> getAllStudentByAccount(Integer sAccount);
	
	//审核学员账目为可用
	int ratifyStu(Student student);
	
	//检测学员手机号是否已被注册
	int checkSMobile(String sMobile);
	
	//根据学员id改变学员考试状态
	int updateStatusBySId(@Param("sId")Integer sId, @Param("sStatus")Integer sStatus);
	
	//根据教练id获取学员信息
	List<Student> getStudentByTId(Integer tId);
	
	//根据学员id修改学员所跟教练id
	int updatetIdBysId(@Param("tId")Integer tId, @Param("sId")Integer sId);
	
	//根据学员id更新学员考试时时间
	int updatesTimeBysId(@Param("sId")Integer sId, @Param("sExTime")String sExTime);
	
	//根据学员id更新学员所属科目并重置考试时间为null
	int updatesCurrentBysId(@Param("sCurrent")Integer sCurrent, @Param("sId")Integer sId);
	
	//根据学员id更新学员表t_id字段为null（解除教练关系)
	int updatetIdNullBysId(Integer sId);
	
	//根据用户账户状态（0：不可用，1：管理员审批可用）
	List<Student> getAllStudentByAccountLikeNameOrMobile(@Param("sAccount")Integer sAccount,@Param("para1")String para1);

}
