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
}
