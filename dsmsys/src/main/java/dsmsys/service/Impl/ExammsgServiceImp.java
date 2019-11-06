package dsmsys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsmsys.dao.ExammsgDao;
import dsmsys.pojo.Exammsg;
import dsmsys.service.ExammsgService;

@Service
public class ExammsgServiceImp implements ExammsgService {

	@Autowired
	ExammsgDao exammsgDao;
	@Override
	public Exammsg getExammsgByENum(Integer eId) {
		// TODO Auto-generated method stub
		return exammsgDao.getExammsgByENum(eId);
	}

	@Override
	public int insertExamMsg(Exammsg exammsg) {
		// TODO Auto-generated method stub
		return exammsgDao.insertExamMsg(exammsg);
	}

	@Override
	public List<Exammsg> getAllExammsg() {
		// TODO Auto-generated method stub
		return exammsgDao.getAllExammsg();
	}

	@Override
	public List<Exammsg> getAllExammsgByTime(String eTime) {
		// TODO Auto-generated method stub
		return exammsgDao.getAllExammsgByTime(eTime);
	}

	@Override
	public List<Exammsg> getAllExammsgByTimeAndSubject(String eTime, String eSubject) {
		// TODO Auto-generated method stub
		return exammsgDao.getAllExammsgByTimeAndSubject(eTime, eSubject);
	}

}
