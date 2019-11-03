package dsmsys.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dsmsys.pojo.Teacher;
import dsmsys.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/showt")
	public void teacherControllerTest(Integer tId) {
		System.out.println(teacherService.getTeacherById(tId));
	}
	
	@RequestMapping("/addteacher")
	public void  addTeacher(@Valid Teacher teacher,Errors errors,MultipartFile tImgFile) {
		if(errors.hasErrors()) {
			System.out.println("ss");
			return;
		}
		teacher.settImg(tImgFile.getOriginalFilename());
		try {
			tImgFile.transferTo(new File("D:\\java\\upfiletest\\1\\"+tImgFile.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(teacher);
		System.out.println(tImgFile.getOriginalFilename());
	}

}
