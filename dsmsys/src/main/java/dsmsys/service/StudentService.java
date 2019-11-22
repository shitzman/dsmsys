package dsmsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Student;

public interface StudentService {
	
	Student getStudentBySid(Integer sId);
	
	List<Student> getAllStudent();
	
	int addStudent(Student student);
	
	Student getStudentByMobileAndPwd(@Param("sMobile")String sMobile, @Param("sPassword")String sPasssword);

	//根据用户账户状态返回学员（0：不可用，1：管理员审批可用）
	List<Student> getAllStudentByAccount(Integer sAccount);
	
	//审核学员账目为可用
	int ratifyStu(Student student);
	
	//检测学员手机号是否已被注册
	int checkSMobile(String sMobile);
	
	//学员约考
	int addExamOrder(Integer sId,Integer sStatus,Integer eNum);
	
	//根据教练id获取学员信息
	List<Student> getStudentByTId(Integer tId);
	
	//根据学员id修改学员所跟教练id
	int updatetIdBysId(Integer tId, Integer sId);
	
	//根据学员id更新学员表t_id字段为null（解除教练关系)
	int updatetIdNullBysId(Integer sId);
	
	//根据用户账户状态（0：不可用，1：管理员审批可用）
	List<Student> getAllStudentByAccountLikeNameOrMobile(@Param("sAccount")Integer sAccount,@Param("para1")String para1);
}
