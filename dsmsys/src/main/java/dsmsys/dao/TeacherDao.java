package dsmsys.dao;

import dsmsys.pojo.Teacher;

public interface TeacherDao {

	Teacher getTeacherById(Integer tId);
	int insertTeacher(Teacher teacher);
}
