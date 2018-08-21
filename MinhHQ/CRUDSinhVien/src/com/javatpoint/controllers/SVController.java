package com.javatpoint.controllers;  
import java.sql.SQLException;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import com.javatpoint.beans.SinhVien;  
import com.javatpoint.dao.SVDao;  
@Controller  
public class SVController {  
    @Autowired  
    SVDao dao;
    
    @RequestMapping("/empform")  
    public ModelAndView showform(){  
        return new ModelAndView("svform","command",new SinhVien());  
    }  
   
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("emp") SinhVien emp){  
        dao.save(emp);  
        return new ModelAndView("redirect:/viewsv/1");
    }  
    
    @RequestMapping(value="/viewsv/{pageid}")  
    public ModelAndView viewSV(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 2;
		double pageTotal = (int) Math.ceil(dao.countSV()/perPage);
 		int start = (pageid*(int)perPage)-(int)perPage;
		List<SinhVien> listsv = dao.getEmployeesByPage(start,(int)perPage);
		model.addAttribute("pageid",(int)pageid);
		model.addAttribute("pagetotal",(int)pageTotal);
		return new ModelAndView("viewsv", "listsv", listsv);
    }
    
    @RequestMapping(value="/editemp/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        SinhVien emp=dao.getEmpById(id);  
        return new ModelAndView("sveditform","command",emp);  
    }  

    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("emp") SinhVien emp){  
        dao.update(emp);  
        return new ModelAndView("redirect:/viewsv/1");  
    }  

    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/viewsv/1");  
    }  
  
}  