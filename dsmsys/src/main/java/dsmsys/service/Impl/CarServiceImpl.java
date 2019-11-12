package dsmsys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsmsys.dao.CarDao;
import dsmsys.pojo.Car;
import dsmsys.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao;
	
	@Override
	public Car getCarByCId(String cId) {
		// TODO Auto-generated method stub
		return carDao.getCarByCId(cId);
	}

	@Override
	public List<Car> getAllCar() {
		// TODO Auto-generated method stub
		return carDao.getAllCar();
	}


	@Override
	public List<String> getAllCarIdByStatus(Integer cStatus) {
		// TODO Auto-generated method stub
		return carDao.getAllCarIdByStatus(cStatus);
	}

	@Override
	public int insertCar(Car car) {
		// TODO Auto-generated method stub
		return carDao.insertCar(car);
	}

	@Override
	public int deleteCarByFlag(Integer cFlag) {
		// TODO Auto-generated method stub
		return carDao.deleteCarByFlag(cFlag);
	}

}
