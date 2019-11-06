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
	public void insertCarTest() {
		Car car = new Car();
		car.setcId("test1");
		car.setcImg("car.jpg");
		car.setcStatus(1);
		car.setcRemark("test1");
		if(carDao.insertCar(car)>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void getAllCarIdTest() {
		List<String> carList = carDao.getAllCarIdByStatus(1);
		System.out.println(carList);
	}
	
	@Test
	public void getCarByCIdTest(){
		Car car =  carDao.getCarByCId("豫N9512");
		System.out.println(car);
	}
	@Test
	public void getAllCarTest() {
		List<Car> carList = carDao.getAllCar();
		System.out.println(carList);
	}
}
