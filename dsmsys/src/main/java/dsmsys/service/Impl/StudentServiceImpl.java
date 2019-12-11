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
		//�ı�ѧԱ���ѧԱ����״̬
		studentDao.updateStatusBySId(sId, sStatus);
		//������ԤԼ�������ԤԼ��Ϣ
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
	 * �����д�����������
	 * ͳ����УѧԱ������Ŀ����
	 * ͳ�Ƹ���Ŀ������ʷ�����У����ء������ص�����
	 * ͳ��ѧԱ�˻�account=0������
	 * ͳ��ѧ��Լ������
	 * ͳ�Ʊ��������ֶ�statusΪ0�������ڴ���״̬�ļ�¼����
	 */
	@Override
	public int[][] sumStuBySubjectArray() {
		// TODO Auto-generated method stub
		List<SumStuBySubject> baseSumStuList = new ArrayList<SumStuBySubject>();
		for(int i=0; i<4; i++){				//��ʼ��������ĿΪ0
			baseSumStuList.add(new SumStuBySubject(i,0));
		}
		List<SumStuBySubject> sumStuList = studentDao.countStuBysCurrent();	//������ݿ��е�ʵ������
		
		for(SumStuBySubject sj: sumStuList){
			baseSumStuList.get(sj.getSubject()-1).setSum(sj.getSum());	//��ʵ���������ǳ�ʼ������������������Կ�Ŀ��һ
		}
		
		int[][] managesomeCountArray = new int[5][4];
		for(int i=0; i<4; i++) {
			managesomeCountArray[0][i] = baseSumStuList.get(i).getSubject();
			managesomeCountArray[1][i] = baseSumStuList.get(i).getSum();
			managesomeCountArray[2][i] = remarkDao.countRemarkPassOrFailBySubject(i+1, 1);//��Ŀi+1ͨ��������
			managesomeCountArray[3][i] = remarkDao.countRemarkPassOrFailBySubject(i+1, 2);//��Ŀi+1�ҿ�������
		}
		managesomeCountArray[4][0] = studentDao.countStuByAccount(0);//0Ϊ����Աδ��˵�ѧԱ����
		managesomeCountArray[4][1] = examOrderDao.countStuByExamOrder();//examorder���м�¼������Ϊѧ��Լ��������
		managesomeCountArray[4][2] = remarkDao.countRemarkBystatus(0);//ͳ�Ʊ��������ֶ�statusΪ0�������ڴ���״̬�ļ�¼����
		return managesomeCountArray;
	}
}
