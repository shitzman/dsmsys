package dsmsys.dao;

import java.util.List;

import dsmsys.pojo.Remark;

public interface RemarkDao {
	
	List<Remark> getRemarkBySId(Integer sId);
	
	//添加信息到考试记录表
	int insertRemark(Remark remark);

}
