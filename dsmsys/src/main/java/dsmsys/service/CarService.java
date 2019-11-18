package dsmsys.service;

import java.util.List;

import dsmsys.pojo.Car;

public interface CarService {
	
	Car getCarByCId(String cId);
	
	List<Car> getAllCar();
	
	//获取所有可用车牌号
	List<String> getAllCarIdByStatus(Integer cStatus);
	
	//添加车辆信息
	int insertCar(Car car);
	
	//删除车辆信息
	int deleteCarByFlag(Integer cFlag);
	
	//更新车辆信息
	int updatecStatusAndcRemarkBycFlag(Car car);

}
