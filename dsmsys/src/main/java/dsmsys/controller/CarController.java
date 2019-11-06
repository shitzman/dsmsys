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

import dsmsys.pojo.Car;
import dsmsys.service.CarService;

@Controller
@RequestMapping("car")
public class CarController {

	@Autowired
	CarService carService;
	
	@RequestMapping(value = "addcar", method = RequestMethod.POST)
	public String  addCar(Car car,MultipartFile cImgFile,HttpSession session,Model model) {
		if(cImgFile.isEmpty()) {
			car.setcImg("car.jpg");//���û�ϴ���Ƭ��Ӧ��Ĭ��ͼƬ
		}else {
			String imgName = cImgFile.getOriginalFilename();
			String imgSuffix = imgName.substring(imgName.lastIndexOf(".")+1).trim();//����ļ���׺��
			boolean b = imgSuffix.equalsIgnoreCase("jpg") || imgSuffix.equalsIgnoreCase("png");
			//������ļ���׺�Ȳ���jpgҲ����png;
			if(!b) {
				model.addAttribute("msg", "��ѡ��.jpg����.png����ʽ��ͼƬ");
				return "admin/addCar";
			}
			try {
				int a = (int) (Math.random()*10000);
				imgName = a+cImgFile.getOriginalFilename();//�����������ֹ�ļ����ظ�
				//��ȡ��Ŀ�ڵ�ǰ�����ϵ���ʵ����·�������ϴ��ļ���������Ŀ��img�ļ����У�
				cImgFile.transferTo(new File(session.getServletContext().getRealPath("/")+"\\img\\"+imgName));
				car.setcImg(imgName);//��ͼƬ·���������ݿ�
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(carService.insertCar(car)<=0) {
			model.addAttribute("msg", "���ʧ��");
			return "admin/addCar";
		}
		return "redirect:showallcar";
	}
	
	@RequestMapping(value = "addcar", method = RequestMethod.GET)
	public String toAddCar() {
		
		return "admin/addCar";
	}
	
	//չʾ���г�����Ϣ
	@RequestMapping(value = "/showallcar", method = RequestMethod.GET)
	public String showAllCar(Model model) {
		List<Car> carList = carService.getAllCar();
		model.addAttribute("carList", carList);
		return "showAllCar";
	}
	
	
	
	
}
