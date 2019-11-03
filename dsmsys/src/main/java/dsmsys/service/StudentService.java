package dsmsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Student;

public interface StudentService {
	
	Student getStudentBySid(Integer sId);
	
	List<Student> getAllStudent();
	
	int addStudent(Student student);
	
	Student getStudentByMobileAndPwd(@Param("sMobile")String sMobile, @Param("sPassword")String sPasssword);

	//�����û��˻�״̬��0�������ã�1������Ա�������ã�
	List<Student> getAllStudentByAccount(Integer sAccount);
}
