package controller;

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

import dao.SinhVienDao;
import entity.SinhVien;

@Controller
public class ControllerSinhVien {
	@Autowired  
	SinhVienDao dao;
	
	@RequestMapping("/")
	public ModelAndView showindex() {
		List<SinhVien> list = new ArrayList<SinhVien>();
		list = dao.getSinhVien();
		return new ModelAndView("index","sinhvien",list);
	}
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	@RequestMapping("/add")
	public ModelAndView addSinhVien() {
		return new ModelAndView("add");		
	}
	
	@RequestMapping(value="/addsave",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("sinhvien") SinhVien sv) {
		dao.addSinhVien(sv);
		return new ModelAndView("redirect:/");
	}
	 @RequestMapping("/edit/{id}")  
	    public ModelAndView editStudent(@PathVariable int id){  
		 SinhVien sv=dao.getStudentId(id); 
	        return new ModelAndView("edit","student",sv);  	        
	    }
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("sinhvien")  SinhVien sv){ 
		 	dao.update(sv);
	        return new ModelAndView("redirect:/");  
	    } 
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        
        return new ModelAndView("redirect:/");  
    }  
}
