package dsmsys.service;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Admin;

public interface AdminService {
	
	Admin getAdminByMobileAndPwd(@Param("admMobile") String admMobile, @Param("admPassword") String AdmPassword);

	//����Ա����ѧԱ�������������ͬ�⣩
	int ratifyExamYes(Integer sId, Integer eId);
	
	//����Ա����ѧԱ��������������ܾ���
	int ratifyExamNo(Integer sId);
}
