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
import dsmsys.service.ExammsgService;
import dsmsys.service.RemarkService;

@Controller
@RequestMapping("exam")
public class ExamController {

	@Autowired
	ExammsgService exammsgService;
	@Autowired
	RemarkService remarkService;
	

	
	//ΪѧԱ��ʾ��Լ����Ϣ����ǰʱ��֮���ҿ�Ŀ�Եȣ�
	@RequestMapping(value="showexammsg", method=RequestMethod.GET)
	public String showExammsg(HttpSession session,Model model){
		Student student = (Student) session.getAttribute("student");
		//�鿴��ǰѧԱ����Լ����¼(rstatus=0��δ��)
		String eId = remarkService.selecteIdBysIdAndrStatus(student.getsId(), 0);
		model.addAttribute("eId", eId);
		
		String eTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String eSubject = student.getsCurrent()+"";
		//��������ʱ���Լ���ǰѧԱ������Ŀչʾ��Լ����Ϣ
		List<Exammsg> examList = exammsgService.getAllExammsgByTimeAndSubject(eTime, eSubject);
		model.addAttribute("examList", examList);
		model.addAttribute("sStatus", student.getsStatus());//���ݵ�ǰ�û���������״̬������ǰ���жϿ�����ʾЧ��
		return "student/showExammsg";
	}
}
