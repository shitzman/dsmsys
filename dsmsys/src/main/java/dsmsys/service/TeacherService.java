package dsmsys.service;

import dsmsys.pojo.Teacher;

public interface TeacherService {

	Teacher getTeacherById(Integer tId);
	int insertTeacher(Teacher teacher);
}
