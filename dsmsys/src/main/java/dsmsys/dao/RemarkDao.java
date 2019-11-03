package dsmsys.dao;

import java.util.List;

import dsmsys.pojo.Remark;

public interface RemarkDao {
	
	List<Remark> getRemarkBySId(Integer sId);

}
