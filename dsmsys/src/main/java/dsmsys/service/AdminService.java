package dsmsys.service;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Admin;

public interface AdminService {
	
	Admin getAdminByMobileAndPwd(@Param("admMobile") String admMobile, @Param("admPassword") String AdmPassword);

}
