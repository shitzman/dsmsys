package dsmsys.service;

import java.util.List;

import dsmsys.pojo.Teacher;

public interface TeacherService {

	Teacher getTeacherById(Integer tId);
	
	int insertTeacher(Teacher teacher);
	
	//查询所有教练
	List<Teacher> getAllTeacher();
	
	//删除该教练
	int delectTeacher(Integer tId);
}
