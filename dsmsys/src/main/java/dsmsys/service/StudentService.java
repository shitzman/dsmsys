package dsmsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Student;

public interface StudentService {
	
	Student getStudentBySid(Integer sId);
	
	List<Student> getAllStudent();
	
	int addStudent(Student student);
	
	Student getStudentByMobileAndPwd(@Param("sMobile")String sMobile, @Param("sPassword")String sPasssword);

	//�����û��˻�״̬����ѧԱ��0�������ã�1������Ա�������ã�
	List<Student> getAllStudentByAccount(Integer sAccount);
	
	//���ѧԱ��ĿΪ����
	int ratifyStu(Student student);
	
	//���ѧԱ�ֻ����Ƿ��ѱ�ע��
	int checkSMobile(String sMobile);
	
	//ѧԱԼ��
	int addExamOrder(Integer sId,Integer sStatus,Integer eNum);
	
	//���ݽ���id��ȡѧԱ��Ϣ
	List<Student> getStudentByTId(Integer tId);
	
	//����ѧԱid�޸�ѧԱ��������id
	int updatetIdBysId(Integer tId, Integer sId);
	
	//����ѧԱid����ѧԱ��t_id�ֶ�Ϊnull�����������ϵ)
	int updatetIdNullBysId(Integer sId);
	
	//�����û��˻�״̬��0�������ã�1������Ա�������ã�
	List<Student> getAllStudentByAccountLikeNameOrMobile(@Param("sAccount")Integer sAccount,@Param("para1")String para1);
}
