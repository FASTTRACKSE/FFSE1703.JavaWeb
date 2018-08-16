package assignment5.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import assignment5.bean.SinhVien;
import assignment5.dao.SinhVienDao;

@Controller
public class ControllerSpring {
	@Autowired
	SinhVienDao sinhVienDao;
	
	List<SinhVien> listSinhVien = new ArrayList<>();
	
	@RequestMapping("/")  
    public ModelAndView listSinhVien(){  
		listSinhVien = sinhVienDao.listSinhVien();
        return new ModelAndView("index", "listSinhVien", listSinhVien);  
    }  
	
	@RequestMapping(value= {"/addSv"}, method=RequestMethod.GET)
	public ModelAndView addSv() {
		return new ModelAndView("addSv", "command", new SinhVien()); // "command" mặc định của spring frame work
	}
	
	@RequestMapping(value= "/addSave", method=RequestMethod.POST)
	public ModelAndView addSave(@ModelAttribute("command") @Valid SinhVien sv, BindingResult result) {
		sinhVienDao.insert(sv);
		return new ModelAndView("redirect:/"); // mặc định trở về trang index. đã đc định nghĩa ở web.xml
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("command") SinhVien sv){ 
		sinhVienDao.update(sv);
        return new ModelAndView("redirect:/"); // mặc định trở về trang index. đã đc định nghĩa ở web.xml  
    }  
	
	@RequestMapping("/editSv/{maSv}")
	public ModelAndView getSv(@PathVariable String maSv) {
		SinhVien sv = sinhVienDao.getEdit(maSv);
		return new ModelAndView("editSv", "command", sv); // "command" mặc định của spring frame work
	}
	
	@RequestMapping("deleteSv/{maSv}")
	public ModelAndView delete(@PathVariable String maSv) {
		sinhVienDao.delete(maSv);
		return new ModelAndView("redirect:/"); // mặc định trở về trang index. đã đc định nghĩa ở web.xml
	}
}  

