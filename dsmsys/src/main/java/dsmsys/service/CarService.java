package dsmsys.service;

import java.util.List;

import dsmsys.pojo.Car;

public interface CarService {
	
	Car getCarByCId(String cId);
	
	List<Car> getAllCar();
	
	//��ȡ���п��ó��ƺ�
	List<String> getAllCarIdByStatus(Integer cStatus);
	
	//��ӳ�����Ϣ
	int insertCar(Car car);

}
