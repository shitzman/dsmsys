package dsmsys.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dsmsys.dao.TeacherDao;
import dsmsys.pojo.Teacher;
import dsmsys.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapp-config.xml")
public class TeacherTest {
	
	@Autowired
	TeacherDao teacherDao;
	@Autowired
	TeacherService teacherService;
	@Test
	public void getTeacherByIdTest() {
		Teacher teacher = teacherDao.getTeacherById(1);
		System.out.println(teacher);
	}
	
	@Test
	public void insertTeacherTest() {
		Teacher teacher = new Teacher();
		teacher.setcId(2);
		teacher.settName("test4");
		teacher.settSex("m");
		teacher.settSubject(3);
		teacher.settImg("/test");
		int flag = teacherService.insertTeacher(teacher);
		
		if(flag>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
}
