package dsmsys.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dsmsys.pojo.Teacher;
import dsmsys.service.CarService;
import dsmsys.service.TeacherService;
/*
 * �Դ˿������µ���ӽ������ܽ���AdminIntercepter������֤
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	@Autowired
	CarService carService;
	
	
	//ɾ��������Ϣ
	@RequestMapping(value="/deleteteacher", method=RequestMethod.GET)
	public String deleteTeacher(Integer tId, Model model){
		if(teacherService.delectTeacher(tId)>0){
			model.addAttribute("msg","�ɹ�ɾ�����Ϊ["+tId+"]�Ľ���");
		}else{
			model.addAttribute("msg", "ɾ����Ϣʧ�ܣ�");
		}
		//�������н������沢��ʾɾ����ʾ��Ϣ
		List<Teacher> teacherList = teacherService.getAllTeacher();
		model.addAttribute("teacherList", teacherList);
		return "showAllTeacher";
	}
	
	
	//��ѯ���н���
	@RequestMapping(value = "/showallteacher", method = RequestMethod.GET)
	public String showAllTeacher(Model model) {
		List<Teacher> teacherList = teacherService.getAllTeacher();
		model.addAttribute("teacherList", teacherList);
		return "showAllTeacher";
	}
	
	
	@RequestMapping(value = "/addteacher", method = RequestMethod.GET)
	public String toAddTeacher(Model model) {
		List<String> carIdList = carService.getAllCarIdByStatus(1);//��ȡ���п��ó��ƺţ�����ǰ��ѡ��
		model.addAttribute("carIdList", carIdList);
		return "admin/addTeacher";
	}
	
	//��ӽ���
	@RequestMapping(value = "/addteacher", method = RequestMethod.POST)
	public String  addTeacher(Teacher teacher,MultipartFile tImgFile,HttpSession session,Model model) {
		
		if(tImgFile.isEmpty()) {
			teacher.settImg("teacher.jpg");//���û�ϴ���Ƭ��Ӧ��Ĭ��ͼƬ
		}else {
			String imgName = tImgFile.getOriginalFilename();
			String imgSuffix = imgName.substring(imgName.lastIndexOf(".")+1).trim();//����ļ���׺��
			boolean b = imgSuffix.equalsIgnoreCase("jpg") || imgSuffix.equalsIgnoreCase("png");
			//������ļ���׺�Ȳ���jpgҲ����png;
			if(!b) {
				model.addAttribute("msg", "��ѡ��.jpg����.png����ʽ��ͼƬ");
				List<String> carIdList = carService.getAllCarIdByStatus(1);//��ȡ���п��ó��ƺţ�����ǰ��ѡ��
				model.addAttribute("carIdList", carIdList);
				return "admin/addTeacher";
			}
			
			try {
				int a = (int) (Math.random()*10000);
				imgName = a+tImgFile.getOriginalFilename();//�����������ֹ�ļ����ظ�
				//��ȡ��Ŀ�ڵ�ǰ�����ϵ���ʵ����·�������ϴ��ļ���������Ŀ��img�ļ����У�
				tImgFile.transferTo(new File(session.getServletContext().getRealPath("/")+"/img/"+imgName));
				teacher.settImg(imgName);//���ļ�·���������ݿ�
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		teacherService.insertTeacher(teacher);
		
		return "redirect:showallteacher";
		
	}

}
