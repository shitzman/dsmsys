package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Exammsg;

public interface ExammsgDao {
	//根据考试id获取考试信息
	Exammsg getExammsgByENum(Integer eId);
	
	//添加考试信息
	int insertExamMsg(Exammsg exammsg);
	
	//查询所有考试信息
	List<Exammsg> getAllExammsg();
	
	//查询所有有效考试信息（考试时间在今天之后）
	List<Exammsg> getAllExammsgByTime(String eTime);
	
	//按科目查询所有有效考试信息
	List<Exammsg> getAllExammsgByTimeAndSubject(@Param("eTime")String eTime, @Param("eSubject")String eSubject);

	//修改考试信息表已报考人数
	int updateExammsgByEIdAteAlrNum(@Param("eId")Integer eId,@Param("addeAlrNum")Integer addeAlrNum);

	//根据考试id获取考试信息
	Exammsg getExammsgByeId(Integer eId);
}
