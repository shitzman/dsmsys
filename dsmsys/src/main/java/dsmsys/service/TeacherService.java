package dsmsys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dsmsys.pojo.Teacher;

public interface TeacherService {

	Teacher getTeacherById(Integer tId);
	
	int insertTeacher(Teacher teacher);
	
	//��ѯ���н���
	List<Teacher> getAllTeacher();
	
	//ɾ���ý���
	int delectTeacher(Integer tId);
	
	//���ݽ���id���½�����������id
	int updateCIdByTId(@Param("cId")String cId, @Param("tId")Integer tId);
	
	//��ȡ���н���id
	List<Integer> getAllTeacherId();
}
