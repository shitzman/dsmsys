package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Exammsg;

public interface ExammsgDao {
	//���ݿ���id��ȡ������Ϣ
	Exammsg getExammsgByENum(Integer eId);
	
	//��ӿ�����Ϣ
	int insertExamMsg(Exammsg exammsg);
	
	//��ѯ���п�����Ϣ
	List<Exammsg> getAllExammsg();
	
	//��ѯ������Ч������Ϣ������ʱ���ڽ���֮��
	List<Exammsg> getAllExammsgByTime(String eTime);
	
	//����Ŀ��ѯ������Ч������Ϣ
	List<Exammsg> getAllExammsgByTimeAndSubject(@Param("eTime")String eTime, @Param("eSubject")String eSubject);

	//�޸Ŀ�����Ϣ���ѱ�������
	int updateExammsgByEIdAteAlrNum(@Param("eId")Integer eId,@Param("addeAlrNum")Integer addeAlrNum);

	//���ݿ���id��ȡ������Ϣ
	Exammsg getExammsgByeId(Integer eId);
}
