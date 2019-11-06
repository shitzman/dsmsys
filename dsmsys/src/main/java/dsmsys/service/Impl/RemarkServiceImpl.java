package dsmsys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsmsys.dao.RemarkDao;
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

}
