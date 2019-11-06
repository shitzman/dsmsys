package dsmsys.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dsmsys.dao.RemarkDao;
import dsmsys.pojo.Remark;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapp-config.xml")
public class RemarkTest {
	
	@Autowired
	RemarkDao remarkDao;
	
	@Test
	public void getRemarkBySidTest() {
		List<Remark> remarkList = remarkDao.getRemarkBySId(3);
		System.out.println(remarkList);
	}
	
	
}
