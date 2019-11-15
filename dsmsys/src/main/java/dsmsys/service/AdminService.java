package dsmsys.service;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Admin;
import dsmsys.pojo.Remark;

public interface AdminService {
	
	Admin getAdminByMobileAndPwd(@Param("admMobile") String admMobile, @Param("admPassword") String AdmPassword);

	//����Ա����ѧԱ�������������ͬ�⣩
	int ratifyExamYes(Integer sId, Integer eId);
	
	//����Ա����ѧԱ��������������ܾ���
	int ratifyExamNo(Integer sId);
	
	//����Ա¼��ѧԱ������Ϣ���������أ�
	int changeRemarkAndStuPass(Remark remark);
	
	//����Ա¼��ѧԱ������Ϣ�������ҿƣ�
	int changeRemarkAndStuFail(Remark remark);
}
