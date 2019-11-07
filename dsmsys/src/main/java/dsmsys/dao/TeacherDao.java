package dsmsys.dao;

import java.util.List;

import dsmsys.pojo.Teacher;

public interface TeacherDao {

	Teacher getTeacherById(Integer tId);
	
	int insertTeacher(Teacher teacher);
	
	//��ѯ���н���
	List<Teacher> getAllTeacher();
	
	//ɾ���ý���
	int delectTeacher(Integer tId);
}
