package dsmsys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dsmsys.dao.TeacherDao;
import dsmsys.pojo.Teacher;
import dsmsys.service.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	@Override
	public Teacher getTeacherById(Integer tId) {
		// TODO Auto-generated method stub
		return teacherDao.getTeacherById(tId);
	}
	@Override
	public int insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.insertTeacher(teacher);
	}
	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return teacherDao.getAllTeacher();
	}
	@Override
	public int delectTeacher(Integer tId) {
		// TODO Auto-generated method stub
		return teacherDao.delectTeacher(tId);
	}

}
