package dsmsys.dao;

import java.util.List;

import dsmsys.pojo.Car;

public interface CarDao {

	Car getCarByCId(String cId);
	
	List<Car> getAllCar();
	
	//��ȡ���п��ó��ƺ�
	List<String> getAllCarIdByStatus(Integer cStatus);
	
	//��ӳ�����Ϣ
	int insertCar(Car car);
	
}
