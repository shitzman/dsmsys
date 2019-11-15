package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Remark;

public interface RemarkDao {
	
	List<Remark> getRemarkBySId(Integer sId);
	
	//添加信息到考试记录表
	int insertRemark(Remark remark);

	//根据学员id以及考试状态查询考试编号
	String selecteIdBysIdAndrStatus(@Param("sId")Integer sId, @Param("rStatus")Integer rStatus);
	
	//根据学员考试状态（0：待考，1：考过，2：挂科）查询考试记录
	List<Remark> getRemarkByStatus(Integer rStatus);
	
	//更新学员当前考试记录
	int updateScoreAndRemarkAndStatus(Remark remark);
}
