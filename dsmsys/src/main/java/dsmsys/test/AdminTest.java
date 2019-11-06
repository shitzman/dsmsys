package dsmsys.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dsmsys.dao.AdminDao;
import dsmsys.pojo.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapp-config.xml")
public class AdminTest {
	
	@Autowired
	AdminDao adminDao;
	@Test
	public void getAdminByMobileAndPwdTest(){
		Admin admin = adminDao.getAdminByMobileAndPwd("123456789", "123456");
		System.out.println(admin);
	}
}
