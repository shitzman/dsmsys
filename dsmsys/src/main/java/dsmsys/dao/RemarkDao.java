package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Remark;

public interface RemarkDao {
	
	List<Remark> getRemarkBySId(Integer sId);
	
	//�����Ϣ�����Լ�¼��
	int insertRemark(Remark remark);

	//����ѧԱid�Լ�����״̬��ѯ���Ա��
	String selecteIdBysIdAndrStatus(@Param("sId")Integer sId, @Param("rStatus")Integer rStatus);
	
	//����ѧԱ����״̬��0��������1��������2���ҿƣ���ѯ���Լ�¼
	List<Remark> getRemarkByStatus(Integer rStatus);
	
	//����ѧԱ��ǰ���Լ�¼
	int updateScoreAndRemarkAndStatus(Remark remark);
	
	//����ѧԱid��ѯѧԱ�Ŀ��Լ�¼
	List<Remark> examRemarkByStuId(Integer sId);
	
	//���ݿ��Ա�Ų�ѯ���Լ�¼�Լ���Ӧѧ����Ϣ
	List<Remark> getAllRemarkAndStuByeId(Integer eId);
	
	//��ѯ��ǰ��Ŀ������ʷ�����У����ء������ص�����
	int countRemarkPassOrFailBySubject(@Param("subject")Integer subject,@Param("status")Integer status);
	
	//ͳ�Ʊ��������ֶ�statusΪ0�������ڴ���״̬�ļ�¼����
	int countRemarkBystatus(Integer status);
}
