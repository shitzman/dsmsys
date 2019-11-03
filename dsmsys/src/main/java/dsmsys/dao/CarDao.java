package dsmsys.dao;

import java.util.List;

import dsmsys.pojo.Car;

public interface CarDao {

	Car getCarByCId(String cId);
	List<Car> getAllCar();
}
