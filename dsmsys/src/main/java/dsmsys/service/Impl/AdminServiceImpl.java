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
import dsmsys.pojo.Exammsg;
import dsmsys.pojo.Remark;
import dsmsys.pojo.Student;
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
	 * --修改学员表考试时间
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
		Exammsg exammsg = exammsgDao.getExammsgByeId(eId);// --修改学员表考试时间
		studentDao.updatesTimeBysId(sId,exammsg.geteTime());
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

	@Transactional
	@Override
	public int changeRemarkAndStuPass(Remark remark) {
		// TODO Auto-generated method stub
		remarkDao.updateScoreAndRemarkAndStatus(remark);//更新当前考试记录
		Student stu = studentDao.getStudentBySid(remark.getsId());//获取当前学员信息
		studentDao.updatesCurrentBysId(stu.getsCurrent()+1, stu.getsId());//学员的当前科目+1
		studentDao.updateStatusBySId(remark.getsId(), 0);//更改学员当前考试状态为0
		
		return stu.getsCurrent()+1;	//返回学员当前所处科目，用于判断是否毕业
	}

	@Transactional
	@Override
	public int changeRemarkAndStuFail(Remark remark) {
		// TODO Auto-generated method stub
		remarkDao.updateScoreAndRemarkAndStatus(remark);//更新当前考试记录
		studentDao.updateStatusBySId(remark.getsId(), 0);//更改学员当前考试状态为0
		return 1;
	}

}
