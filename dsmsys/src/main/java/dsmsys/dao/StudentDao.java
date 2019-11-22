package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Remark;
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
	
	//���ݽ���id��ȡѧԱ��Ϣ
	List<Student> getStudentByTId(Integer tId);
	
	//����ѧԱid�޸�ѧԱ��������id
	int updatetIdBysId(@Param("tId")Integer tId, @Param("sId")Integer sId);
	
	//����ѧԱid����ѧԱ����ʱʱ��
	int updatesTimeBysId(@Param("sId")Integer sId, @Param("sExTime")String sExTime);
	
	//����ѧԱid����ѧԱ������Ŀ�����ÿ���ʱ��Ϊnull
	int updatesCurrentBysId(@Param("sCurrent")Integer sCurrent, @Param("sId")Integer sId);
	
	//����ѧԱid����ѧԱ��t_id�ֶ�Ϊnull�����������ϵ)
	int updatetIdNullBysId(Integer sId);
	
	//�����û��˻�״̬��0�������ã�1������Ա�������ã�
	List<Student> getAllStudentByAccountLikeNameOrMobile(@Param("sAccount")Integer sAccount,@Param("para1")String para1);

}
