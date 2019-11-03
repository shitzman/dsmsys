package dsmsys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsmsys.dao.AdminDao;
import dsmsys.pojo.Admin;
import dsmsys.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public Admin getAdminByMobileAndPwd(String admMobile, String AdmPassword) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByMobileAndPwd(admMobile, AdmPassword);
	}

}
