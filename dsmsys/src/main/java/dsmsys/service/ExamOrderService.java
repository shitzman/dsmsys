package dsmsys.service;

import java.util.Map;

import dsmsys.pojo.Exammsg;
import dsmsys.pojo.Student;

public interface ExamOrderService {

	Map<Student,Integer> getAllOrderIdAndStudentMap();
	
}
