package dsmsys.dao;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Admin;

public interface AdminDao {

	Admin getAdminByMobileAndPwd(@Param("admMobile") String admMobile, @Param("admPassword") String AdmPassword);

}
