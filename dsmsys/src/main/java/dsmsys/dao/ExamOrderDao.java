package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.ExamOrder;

public interface ExamOrderDao {
	
	List<ExamOrder> getAllOrder();
	
	//将信息添加到考试预约表
	int insertExamOrder(@Param("eNum")Integer eNum, @Param("sId")Integer sId);
	
	//根据学员id删除预约表的信息
	int deleteExamOrderBySId(Integer sId);
}
