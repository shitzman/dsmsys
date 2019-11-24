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
	public void countRemarkPassOrFailBySubject() {
		System.out.println(remarkDao.countRemarkPassOrFailBySubject(1,2));
	}
	
	
	@Test
	public void getRemarkBySidTest() {
		List<Remark> remarkList = remarkDao.getRemarkBySId(3);
		System.out.println(remarkList);
	}
	
	@Test
	public void getRemarkByStatusTest() {
		List<Remark> reList = remarkDao.getRemarkByStatus(0);
		System.out.println(reList);
	}
	
	@Test
	public void examRemarkByStuIdTest() {
		List<Remark> remarkList = remarkDao.examRemarkByStuId(19);
		for(Remark remark : remarkList) {
			System.out.println(remark);
		}
		
	}
	
	@Test
	public void getAllRemarkAndStuByeIdTest() {
		List<Remark> remarkList = remarkDao.getAllRemarkAndStuByeId(3);
		for(Remark r: remarkList) {
			System.out.println(r);
		}
	}
	
	
}
