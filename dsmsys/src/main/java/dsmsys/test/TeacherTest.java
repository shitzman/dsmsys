package dsmsys.test;

import java.util.List;

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
	public void getAllTeacherTest() {
		List<Teacher> teacherList = teacherDao.getAllTeacher();
		System.out.println(teacherList);
	}
	
	@Test
	public void getTeacherByIdTest() {
		Teacher teacher = teacherDao.getTeacherById(1);
		System.out.println(teacher);
	}
	
	@Test
	public void insertTeacherTest() {
		Teacher teacher = new Teacher();
		teacher.setcId("2");
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
	
	@Test
	public void stringTest() {
		/*
		 * String a = "sss.jpg"; a = a.substring(a.lastIndexOf(".")+1).trim();//取出文件后缀名；
		 * boolean b = a.equalsIgnoreCase("JPG");//不分大小写比较后缀名 System.out.println(b);
		 */
		String imgName = "shssh.xml";
		String imgSuffix = imgName.substring(imgName.lastIndexOf(".")+1).trim();//获得文件后缀名
		if(imgSuffix.equalsIgnoreCase("jpg") || imgSuffix.equalsIgnoreCase("png")) {
			System.out.println("ss");
		}else {
			System.out.println(imgSuffix.equalsIgnoreCase("jpg") || imgSuffix.equalsIgnoreCase("png"));
		}
	}
	
	@Test
	public void randomeTest(){
		int a = (int) (Math.random()*10000);
		System.out.println(a);
	}
}
