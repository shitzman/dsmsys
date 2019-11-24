package dsmsys.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dsmsys.dao.StudentDao;
import dsmsys.pojo.Student;
import dsmsys.pojo.SumStuBySubject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapp-config.xml")
public class StudentTest {
	
	@Autowired
	StudentDao studentDao;
	
	@Test
	public void SumStuBySubjectTest() {
	
		List<SumStuBySubject> sumStuList = studentDao.countStuBysCurrent();
		int[][] sumStuArray = new int[2][4];
		for(int i=0; i<4; i++) {
			sumStuArray[0][i] = sumStuList.get(i).getSubject();
			sumStuArray[1][i] = sumStuList.get(i).getSum();
		}
		
		for(int i=0; i<4; i++) {
			System.out.print(sumStuArray[0][i]+"---");
		}
		System.out.println();
		for(int i=0; i<4; i++) {
			System.out.print(sumStuArray[1][i]+"---");
		}
	}
	
	@Test
	public void getAllStudentByAccountLikeNameOrMobileTest() {
		List<Student> stuList = studentDao.getAllStudentByAccountLikeNameOrMobile(1, "152247");
		System.out.println(stuList);
	}
	
	@Test
	public void ratifyStuTest() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sRegTime = sdf.format(now);
		Integer sId = 14;
		
		Student student = new Student();
		student.setsRegTime(sRegTime);
		student.setsId(sId);
		student.setsAccount(1);//修改学员账户状态字段为可用；
		student.setsCurrent(1);//修改当前学员默认科目为科目一；
		if(studentDao.ratifyStu(student)>0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	
	@Test
	public void getAllStudentByAccountTest() {
		List<Student> stuList = studentDao.getAllStudentByAccount(1);
		for(Student stu : stuList) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void getStudentBySidTest(){
		Student student = studentDao.getStudentBySid(2);
		System.out.println(student);
	}
	
	@Test
	public void getAllStudentTest() {
		List<Student> stuList = studentDao.getAllStudent();
		for(Student stu : stuList) {
			System.out.println(stu.gettIdList());
		}
		
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
