package dsmsys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsmsys.dao.StudentDao;
import dsmsys.pojo.Student;
import dsmsys.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	@Override
	public Student getStudentBySid(Integer sId) {
		// TODO Auto-generated method stub
		return studentDao.getStudentBySid(sId);
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);
	}

	@Override
	public Student getStudentByMobileAndPwd(String sMobile, String sPasssword) {
		// TODO Auto-generated method stub
		return studentDao.getStudentByMobileAndPwd(sMobile, sPasssword);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}

	@Override
	public List<Student> getAllStudentByAccount(Integer sAccount) {
		// TODO Auto-generated method stub
		return studentDao.getAllStudentByAccount(sAccount);
	}

}
