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
	 * --����Ϣ��ӵ����Լ�¼��
	 * --ɾ��ԤԼ���¼
	 * --���¿�����Ϣ���ѱ���������
	 * --�޸�ѧԱ����״̬�ֶ�Ϊ��2����Լ��)
	 */
	@Transactional
	@Override
	public int ratifyExamYes(Integer sId, Integer eId) {
		// TODO Auto-generated method stub
		Remark remark = new Remark();
		remark.setsId(sId);
		remark.seteId(eId);
		remark.setrStatus(0);//����״̬(0:δ��)
		remarkDao.insertRemark(remark);//--����Ϣ��ӵ����Լ�¼��
		examOrderDao.deleteExamOrderBySId(sId);//--ɾ��ԤԼ���¼
		exammsgDao.updateExammsgByEIdAteAlrNum(eId, 1);//--���¿�����Ϣ���ѱ��������֣���һ��
		studentDao.updateStatusBySId(sId, 2);//--�޸�ѧԱ����״̬�ֶ�Ϊ��2����Լ��)
		
		return 1;
	}
	/*
	 * --ɾ��ԤԼ���¼
	 * --�޸�ѧԱ����״̬�ֶ�Ϊ��3��������Ա�ܾ���
	 * 
	 */
	@Transactional
	@Override
	public int ratifyExamNo(Integer sId) {
		// TODO Auto-generated method stub
		examOrderDao.deleteExamOrderBySId(sId);//--ɾ��ԤԼ���¼
		studentDao.updateStatusBySId(sId, 3);//--�޸�ѧԱ����״̬�ֶ�Ϊ��3��������Ա�ܾ�)
		return 1;
	}

}
