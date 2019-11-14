package dsmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Teacher;

public interface TeacherDao {

	Teacher getTeacherById(Integer tId);
	
	int insertTeacher(Teacher teacher);
	
	//查询所有教练
	List<Teacher> getAllTeacher();
	
	//删除该教练
	int delectTeacher(Integer tId);
	
	//根据教练id更新教练所属车辆id
	int updateCIdByTId(@Param("cId")String cId, @Param("tId")Integer tId);
}
