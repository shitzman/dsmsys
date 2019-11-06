package dsmsys.test;

import java.util.List;

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
	public void getAllExammsgByTimeAndSubjectTest(){
		List<Exammsg> examList = exammsgDao.getAllExammsgByTimeAndSubject("2019/10/5", "2");
		System.out.println(examList);
	}
	
	@Test
	public void getAllExammsgByTimeTest(){
		List<Exammsg> examList = exammsgDao.getAllExammsgByTime("2019/10/5");
		System.out.println(examList);
	}
	
	@Test
	public void getAllExammsgTest(){
		List<Exammsg> examList = exammsgDao.getAllExammsg();
		System.out.println(examList);
	}
	
	@Test
	public void insertExamMsgTest(){
		Exammsg exammsg = new Exammsg();
		exammsg.seteAddress("test");
		exammsg.seteAllNum(2);
		exammsg.seteSubject(2);
		exammsg.seteTime("2019-9-1");
		
		if(exammsgDao.insertExamMsg(exammsg)>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败 ");
		}
	}
	
	@Test
	public void getExammsgByENumTest(){
		Exammsg exammsg = exammsgDao.getExammsgByENum(1);
		System.out.println(exammsg);
	}
}
