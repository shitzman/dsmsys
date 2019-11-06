package dsmsys.service;

import org.apache.ibatis.annotations.Param;

public interface RemarkService {

	//根据学员id以及考试状态查询考试编号
		String selecteIdBysIdAndrStatus(@Param("sId")Integer sId, @Param("rStatus")Integer rStatus);
}
