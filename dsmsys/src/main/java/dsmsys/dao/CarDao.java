package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Car;

public interface CarDao {

	Car getCarByCId(String cId);
	
	List<Car> getAllCar();
	
	//��ȡ���п��ó��ƺ�
	List<String> getAllCarIdByStatus(Integer cStatus);
	
	//��ӳ�����Ϣ
	int insertCar(Car car);
	
	//ɾ��������Ϣ
	int deleteCarByFlag(Integer cFlag);
	
	//���³�����Ϣ
	int updatecStatusAndcRemarkBycFlag(Car car);

	
}
