package dsmsys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dsmsys.dao.ExamOrderDao;
import dsmsys.dao.StudentDao;
import dsmsys.pojo.Student;
import dsmsys.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	@Autowired
	ExamOrderDao examOrderDao;
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

	@Override
	public int ratifyStu(Student student) {
		// TODO Auto-generated method stub
		return studentDao.ratifyStu(student);
	}

	@Override
	public int checkSMobile(String sMobile) {
		// TODO Auto-generated method stub
		return studentDao.checkSMobile(sMobile);
	}

	@Transactional
	@Override
	public int addExamOrder(Integer sId, Integer sStatus, Integer eNum) {
		//改变学员表的学员考试状态
		studentDao.updateStatusBySId(sId, sStatus);
		//往考试预约表中添加预约信息
		examOrderDao.insertExamOrder(eNum, sId);
		return 1;
	}

	@Override
	public List<Student> getStudentByTId(Integer tId) {
		// TODO Auto-generated method stub
		return studentDao.getStudentByTId(tId);
	}

	@Override
	public int updatetIdBysId(Integer tId, Integer sId) {
		// TODO Auto-generated method stub
		return studentDao.updatetIdBysId(tId, sId);
	}

	@Override
	public int updatetIdNullBysId(Integer sId) {
		// TODO Auto-generated method stub
		return studentDao.updatetIdNullBysId(sId);
	}

}
