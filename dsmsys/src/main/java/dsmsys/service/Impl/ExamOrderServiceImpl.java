package dsmsys.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsmsys.dao.ExamOrderDao;
import dsmsys.dao.StudentDao;
import dsmsys.pojo.ExamOrder;
import dsmsys.pojo.Exammsg;
import dsmsys.pojo.Student;
import dsmsys.service.ExamOrderService;

@Service
public class ExamOrderServiceImpl implements ExamOrderService {

	@Autowired
	ExamOrderDao examOrderDao;
	@Autowired
	StudentDao studentDao;
	
	
	@Override
	public Map<Student, Integer> getAllOrderIdAndStudentMap() {
		
		List<ExamOrder> examOrderList = examOrderDao.getAllOrder();
		
		//因为考试编号重复，所以将Student作为键
		Map<Student,Integer> orderList = new HashMap<Student,Integer>();
			
		for(ExamOrder order :examOrderList){
		
			orderList.put(studentDao.getStudentBySid(order.getsId()),order.geteNum());
				
		}
		return orderList;
	}


	
	
	
	

}
