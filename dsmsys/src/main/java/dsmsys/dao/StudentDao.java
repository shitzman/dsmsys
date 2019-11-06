package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Student;

public interface StudentDao {

	Student getStudentBySid(Integer sId);
	
	List<Student> getAllStudent();
	
	int addStudent(Student student);
	
	//��¼
	Student getStudentByMobileAndPwd(@Param("sMobile")String sMobile, @Param("sPassword")String sPasssword);

	//�����û��˻�״̬��0�������ã�1������Ա�������ã�
	List<Student> getAllStudentByAccount(Integer sAccount);
	
	//���ѧԱ��ĿΪ����
	int ratifyStu(Student student);
	
	//���ѧԱ�ֻ����Ƿ��ѱ�ע��
	int checkSMobile(String sMobile);
	
	//����ѧԱid�ı�ѧԱ����״̬
	int updateStatusBySId(@Param("sId")Integer sId, @Param("sStatus")Integer sStatus);
}
