package dsmsys.test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dsmsys.dao.ExamOrderDao;
import dsmsys.pojo.ExamOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapp-config.xml")
public class ExamOrderTest {

	@Autowired
	ExamOrderDao orderDao;
	@Test
	public void getAllOrderTest(){
		List<ExamOrder> orderList = orderDao.getAllOrder();
		System.out.println(orderList);
	
	}
	
}
