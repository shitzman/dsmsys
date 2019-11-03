package dsmsys.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dsmsys.dao.CarDao;
import dsmsys.pojo.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapp-config.xml")
public class CarTest {

	@Autowired
	CarDao carDao;
	
	@Test
	public void getCarByCIdTest(){
		Car car =  carDao.getCarByCId("ԥN9512");
		System.out.println(car);
	}
	@Test
	public void getAllCarTest() {
		List<Car> carList = carDao.getAllCar();
		System.out.println(carList);
	}
}
