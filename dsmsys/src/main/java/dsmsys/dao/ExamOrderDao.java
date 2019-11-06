package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.ExamOrder;

public interface ExamOrderDao {
	
	List<ExamOrder> getAllOrder();
	
	//����Ϣ��ӵ�����ԤԼ��
	int insertExamOrder(@Param("eNum")Integer eNum, @Param("sId")Integer sId);
	
	//����ѧԱidɾ��ԤԼ�����Ϣ
	int deleteExamOrderBySId(Integer sId);
}
