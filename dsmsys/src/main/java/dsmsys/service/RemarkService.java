package dsmsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Remark;

public interface RemarkService {

	//����ѧԱid�Լ�����״̬��ѯ���Ա��
	String selecteIdBysIdAndrStatus(@Param("sId")Integer sId, @Param("rStatus")Integer rStatus);
	
	//����ѧԱ����״̬��0��������1��������2���ҿƣ���ѯ���Լ�¼
	List<Remark> getRemarkByStatus(Integer rStatus);
	
	//����ѧԱ��ǰ���Լ�¼
	int updateScoreAndRemarkAndStatus(Remark remark);
	
	//����ѧԱid��ѯѧԱ�Ŀ��Լ�¼
	List<Remark> examRemarkByStuId(Integer sId);
}
