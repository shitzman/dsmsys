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
 * 对此控制器下的添加教练功能进行AdminIntercepter过滤验证
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	@Autowired
	CarService carService;
	
	
	//删除教练信息
	@RequestMapping(value="/deleteteacher", method=RequestMethod.GET)
	public String deleteTeacher(Integer tId, Model model){
		if(teacherService.delectTeacher(tId)>0){
			model.addAttribute("msg","成功删除编号为["+tId+"]的教练");
		}else{
			model.addAttribute("msg", "删除信息失败！");
		}
		//返回所有教练界面并显示删除提示信息
		List<Teacher> teacherList = teacherService.getAllTeacher();
		model.addAttribute("teacherList", teacherList);
		return "showAllTeacher";
	}
	
	
	//查询所有教练
	@RequestMapping(value = "/showallteacher", method = RequestMethod.GET)
	public String showAllTeacher(Model model) {
		List<Teacher> teacherList = teacherService.getAllTeacher();
		model.addAttribute("teacherList", teacherList);
		return "showAllTeacher";
	}
	
	
	@RequestMapping(value = "/addteacher", method = RequestMethod.GET)
	public String toAddTeacher(Model model) {
		List<String> carIdList = carService.getAllCarIdByStatus(1);//获取所有可用车牌号，用于前端选择
		model.addAttribute("carIdList", carIdList);
		return "admin/addTeacher";
	}
	
	//添加教练
	@RequestMapping(value = "/addteacher", method = RequestMethod.POST)
	public String  addTeacher(Teacher teacher,MultipartFile tImgFile,HttpSession session,Model model) {
		
		if(tImgFile.isEmpty()) {
			teacher.settImg("teacher.jpg");//如果没上传照片怎应用默认图片
		}else {
			String imgName = tImgFile.getOriginalFilename();
			String imgSuffix = imgName.substring(imgName.lastIndexOf(".")+1).trim();//获得文件后缀名
			boolean b = imgSuffix.equalsIgnoreCase("jpg") || imgSuffix.equalsIgnoreCase("png");
			//如果即文件后缀既不是jpg也不是png;
			if(!b) {
				model.addAttribute("msg", "请选择【.jpg】或【.png】格式的图片");
				List<String> carIdList = carService.getAllCarIdByStatus(1);//获取所有可用车牌号，用于前端选择
				model.addAttribute("carIdList", carIdList);
				return "admin/addTeacher";
			}
			
			try {
				int a = (int) (Math.random()*10000);
				imgName = a+tImgFile.getOriginalFilename();//链接随机数防止文件名重复
				//获取项目在当前机器上的真实绝对路径，将上传文件储存在项目的img文件夹中；
				tImgFile.transferTo(new File(session.getServletContext().getRealPath("/")+"/img/"+imgName));
				teacher.settImg(imgName);//将文件路径存入数据库
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
