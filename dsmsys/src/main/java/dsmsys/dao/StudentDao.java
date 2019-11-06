package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
}
