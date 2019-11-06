package dsmsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Exammsg;

public interface ExammsgService {
	
Exammsg getExammsgByENum(Integer eId);
	
	//��ӿ�����Ϣ
	int insertExamMsg(Exammsg exammsg);
	
	//��ѯ���п�����Ϣ
	List<Exammsg> getAllExammsg();
	
	//��ѯ������Ч������Ϣ������ʱ���ڽ���֮��
	List<Exammsg> getAllExammsgByTime(String eTime);
	
	//����Ŀ��ѯ������Ч������Ϣ
	List<Exammsg> getAllExammsgByTimeAndSubject(@Param("eTime")String eTime, @Param("eSubject")String eSubject);

}
