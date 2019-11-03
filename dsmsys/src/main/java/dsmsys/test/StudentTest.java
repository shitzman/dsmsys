package dsmsys.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dsmsys.dao.StudentDao;
import dsmsys.pojo.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapp-config.xml")
public class StudentTest {
	
	@Autowired
	StudentDao studentDao;
	
	@Test
	public void getAllStudentByAccountTest() {
		List<Student> stuList = studentDao.getAllStudentByAccount(0);
		System.out.println(stuList);
	}
	
	@Test
	public void getStudentBySidTest(){
		Student student = studentDao.getStudentBySid(2);
		System.out.println(student);
	}
	
	@Test
	public void getAllStudentTest() {
		List<Student> stuList = studentDao.getAllStudent();
		System.out.println(stuList);
	}
	
	@Test
	public void addStudentTest() {
		Student student = new Student();
		student.setsNumber("41141548962015");
		student.setsMobile("15346971856");
		student.setsName("test");
		student.setsPassword("test");
		student.setsSex("男");
		student.setsAddress("新乡");
		if(studentDao.addStudent(student)>0) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void getStudentByMobileAndPwdTest() {
		
		Student student = studentDao.getStudentByMobileAndPwd("15224791863", "123456");
		System.out.println(student);
	}
}
