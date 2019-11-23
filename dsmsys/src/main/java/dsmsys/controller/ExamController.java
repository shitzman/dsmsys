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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dsmsys.pojo.Exammsg;
import dsmsys.pojo.Student;
import dsmsys.service.ExammsgService;
import dsmsys.service.RemarkService;

@Controller
@RequestMapping("exam")
public class ExamController {

	@Autowired
	ExammsgService exammsgService;
	@Autowired
	RemarkService remarkService;
	

	
	//为学员显示可约考信息（当前时间之后，且科目对等）
	@RequestMapping(value="showexammsg", method=RequestMethod.GET)
	public String showExammsg(HttpSession session,Model model){
		Student student = (Student) session.getAttribute("student");
		//查看当前学员有无约考记录(rstatus=0：未考)
		String eId = remarkService.selecteIdBysIdAndrStatus(student.getsId(), 0);
		model.addAttribute("eId", eId);
		
		String eTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String eSubject = student.getsCurrent()+"";
		//根据现在时间以及当前学员所属科目展示可约考信息
		PageHelper.startPage(1, 50);	//该情况数据量不会多，没必要分页，但与管理员查询所有发布的考试信息共用一页，为保持数据格式一致………………
		List<Exammsg> examList = exammsgService.getAllExammsgByTimeAndSubject(eTime, eSubject);
		PageInfo<Exammsg> pageExamList = new PageInfo<Exammsg>(examList);
		model.addAttribute("pageExamList", pageExamList);
		model.addAttribute("sStatus", student.getsStatus());//传递当前用户所属考试状态，用以前端判断控制显示效果
		return "student/showExammsg";
	}
}
