package dsmsys.service;

import org.apache.ibatis.annotations.Param;

public interface RemarkService {

	//����ѧԱid�Լ�����״̬��ѯ���Ա��
		String selecteIdBysIdAndrStatus(@Param("sId")Integer sId, @Param("rStatus")Integer rStatus);
}
