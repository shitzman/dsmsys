package dsmsys.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dsmsys.dao.ExammsgDao;
import dsmsys.pojo.Exammsg;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapp-config.xml")
public class ExammsgTest {

	@Autowired
	ExammsgDao exammsgDao;
	
	@Test
	public void getExammsgByENumTest(){
		Exammsg exammsg = exammsgDao.getExammsgByENum(1);
		System.out.println(exammsg);
	}
}
