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
			car.setcImg("car.jpg");//如果没上传照片怎应用默认图片
		}else {
			String imgName = cImgFile.getOriginalFilename();
			String imgSuffix = imgName.substring(imgName.lastIndexOf(".")+1).trim();//获得文件后缀名
			boolean b = imgSuffix.equalsIgnoreCase("jpg") || imgSuffix.equalsIgnoreCase("png");
			//如果即文件后缀既不是jpg也不是png;
			if(!b) {
				model.addAttribute("msg", "请选择【.jpg】或【.png】格式的图片");
				return "admin/addCar";
			}
			try {
				int a = (int) (Math.random()*10000);
				imgName = a+cImgFile.getOriginalFilename();//链接随机数防止文件名重复
				//获取项目在当前机器上的真实绝对路径，将上传文件储存在项目的img文件夹中；
				cImgFile.transferTo(new File(session.getServletContext().getRealPath("/")+"\\img\\"+imgName));
				car.setcImg(imgName);//将图片路径存入数据库
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(carService.insertCar(car)<=0) {
			model.addAttribute("msg", "添加失败");
			return "admin/addCar";
		}
		return "redirect:showallcar";
	}
	
	@RequestMapping(value = "addcar", method = RequestMethod.GET)
	public String toAddCar() {
		
		return "admin/addCar";
	}
	
	//展示所有车辆信息
	@RequestMapping(value = "/showallcar", method = RequestMethod.GET)
	public String showAllCar(Model model) {
		List<Car> carList = carService.getAllCar();
		model.addAttribute("carList", carList);
		return "showAllCar";
	}
	
	
	
	
}
