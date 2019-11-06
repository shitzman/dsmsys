package dsmsys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dsmsys.dao.AdminDao;
import dsmsys.dao.ExamOrderDao;
import dsmsys.dao.ExammsgDao;
import dsmsys.dao.RemarkDao;
import dsmsys.dao.StudentDao;
import dsmsys.pojo.Admin;
import dsmsys.pojo.Remark;
import dsmsys.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	ExamOrderDao examOrderDao;
	@Autowired
	RemarkDao remarkDao;
	@Autowired
	ExammsgDao exammsgDao;

	@Override
	public Admin getAdminByMobileAndPwd(String admMobile, String AdmPassword) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByMobileAndPwd(admMobile, AdmPassword);
	}

	/*
	 * --将信息添加到考试记录表
	 * --删除预约表记录
	 * --更新考试信息表已报考人数字
	 * --修改学员表考试状态字段为（2：已约考)
	 */
	@Transactional
	@Override
	public int ratifyExamYes(Integer sId, Integer eId) {
		// TODO Auto-generated method stub
		Remark remark = new Remark();
		remark.setsId(sId);
		remark.seteId(eId);
		remark.setrStatus(0);//考试状态(0:未考)
		remarkDao.insertRemark(remark);//--将信息添加到考试记录表
		examOrderDao.deleteExamOrderBySId(sId);//--删除预约表记录
		exammsgDao.updateExammsgByEIdAteAlrNum(eId, 1);//--更新考试信息表已报考人数字（加一）
		studentDao.updateStatusBySId(sId, 2);//--修改学员表考试状态字段为（2：已约考)
		
		return 1;
	}
	/*
	 * --删除预约表记录
	 * --修改学员考试状态字段为（3：被管理员拒绝）
	 * 
	 */
	@Transactional
	@Override
	public int ratifyExamNo(Integer sId) {
		// TODO Auto-generated method stub
		examOrderDao.deleteExamOrderBySId(sId);//--删除预约表记录
		studentDao.updateStatusBySId(sId, 3);//--修改学员表考试状态字段为（3：被管理员拒绝)
		return 1;
	}

}
