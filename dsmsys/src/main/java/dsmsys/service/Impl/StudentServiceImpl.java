package dsmsys.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dsmsys.dao.ExamOrderDao;
import dsmsys.dao.RemarkDao;
import dsmsys.dao.StudentDao;
import dsmsys.pojo.Student;
import dsmsys.pojo.SumStuBySubject;
import dsmsys.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	@Autowired
	ExamOrderDao examOrderDao;
	@Autowired
	RemarkDao remarkDao;
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
		List<Student> stuList = studentDao.getAllStudentByAccount(sAccount);
		for(int i=0; i<stuList.size(); i++){
			stuList.get(i).settIdList(studentDao.selecttIdsBytSubject(stuList.get(i).getsCurrent()));
		}
		return stuList;
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

	@Override
	public List<Student> getAllStudentByAccountLikeNameOrMobile(Integer sAccount, String para1) {
		// TODO Auto-generated method stub
		List<Student> stuList = studentDao.getAllStudentByAccountLikeNameOrMobile(sAccount, para1);
		for(int i=0; i<stuList.size(); i++){
			stuList.get(i).settIdList(studentDao.selecttIdsBytSubject(stuList.get(i).getsCurrent()));
		}
		return stuList;
	}
	
	
	/***
	 * 数组中存有以下数据
	 * 统计在校学员所处科目人数
	 * 统计各科目所有历史考试中，过关、不过关的人数
	 * 统计学员账户account=0的数量
	 * 统计学生约考数量
	 * 统计表中所有字段status为0，即处于代考状态的记录数量
	 */
	@Override
	public int[][] sumStuBySubjectArray() {
		// TODO Auto-generated method stub
		List<SumStuBySubject> baseSumStuList = new ArrayList<SumStuBySubject>();
		for(int i=0; i<4; i++){				//初始化各个科目为0
			baseSumStuList.add(new SumStuBySubject(i,0));
		}
		List<SumStuBySubject> sumStuList = studentDao.countStuBysCurrent();	//获得数据库中的实际人数
		
		for(SumStuBySubject sj: sumStuList){
			baseSumStuList.get(sj.getSubject()-1).setSum(sj.getSum());	//将实际人数覆盖初始人数，从零计数，所以科目减一
		}
		
		int[][] managesomeCountArray = new int[5][4];
		for(int i=0; i<4; i++) {
			managesomeCountArray[0][i] = baseSumStuList.get(i).getSubject();
			managesomeCountArray[1][i] = baseSumStuList.get(i).getSum();
			managesomeCountArray[2][i] = remarkDao.countRemarkPassOrFailBySubject(i+1, 1);//科目i+1通关人数；
			managesomeCountArray[3][i] = remarkDao.countRemarkPassOrFailBySubject(i+1, 2);//科目i+1挂科人数；
		}
		managesomeCountArray[4][0] = studentDao.countStuByAccount(0);//0为管理员未审核的学员数量
		managesomeCountArray[4][1] = examOrderDao.countStuByExamOrder();//examorder表中记录数量即为学生约考数量；
		managesomeCountArray[4][2] = remarkDao.countRemarkBystatus(0);//统计表中所有字段status为0，即处于代考状态的记录数量
		return managesomeCountArray;
	}
}
