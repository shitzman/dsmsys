package dsmsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Student;

public interface StudentService {
	
	Student getStudentBySid(Integer sId);
	
	List<Student> getAllStudent();
	
	int addStudent(Student student);
	
	Student getStudentByMobileAndPwd(@Param("sMobile")String sMobile, @Param("sPassword")String sPasssword);

	//根据用户账户状态（0：不可用，1：管理员审批可用）
	List<Student> getAllStudentByAccount(Integer sAccount);
}
