package dsmsys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsmsys.dao.RemarkDao;
import dsmsys.pojo.Remark;
import dsmsys.service.RemarkService;

@Service
public class RemarkServiceImpl implements RemarkService {

	@Autowired
	RemarkDao remarkDao;
	@Override
	public String selecteIdBysIdAndrStatus(Integer sId, Integer rStatus) {
		// TODO Auto-generated method stub
		return remarkDao.selecteIdBysIdAndrStatus(sId, rStatus);
	}
	@Override
	public List<Remark> getRemarkByStatus(Integer rStatus) {
		// TODO Auto-generated method stub
		return remarkDao.getRemarkByStatus(rStatus);
	}
	@Override
	public int updateScoreAndRemarkAndStatus(Remark remark) {
		// TODO Auto-generated method stub
		return remarkDao.updateScoreAndRemarkAndStatus(remark);
	}
	@Override
	public List<Remark> examRemarkByStuId(Integer sId) {
		// TODO Auto-generated method stub
		return remarkDao.examRemarkByStuId(sId);
	}
	@Override
	public List<Remark> getAllRemarkAndStuByeId(Integer eId) {
		// TODO Auto-generated method stub
		return remarkDao.getAllRemarkAndStuByeId(eId);
	}

}
