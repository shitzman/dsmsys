package dsmsys.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dsmsys.pojo.Exammsg;
import dsmsys.pojo.Student;
import dsmsys.service.ExamOrderService;
import dsmsys.service.ExammsgService;

@Controller
@RequestMapping("exam")
public class ExamController {

	@Autowired
	ExammsgService exammsgService;
	
	

	
	//为学员显示可约考信息（当前时间之后，且科目对等）
	@RequestMapping(value="showexammsg", method=RequestMethod.GET)
	public String showExammsg(HttpSession session,Model model){
		Student student = (Student) session.getAttribute("student");
		String eTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String eSubject = student.getsCurrent()+"";
		//根据现在时间以及当前学员所属科目展示可约考信息
		List<Exammsg> examList = exammsgService.getAllExammsgByTimeAndSubject(eTime, eSubject);
		model.addAttribute("examList", examList);
		model.addAttribute("sStatus", student.getsStatus());//传递当前用户所属考试状态，用以前端判断控制显示效果
		return "student/showExammsg";
	}
}
