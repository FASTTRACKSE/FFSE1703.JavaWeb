package fasttrackse.controllers;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import fasttrackse.beans.*;

import fasttrackse.dao.EmpDao;
@Controller
public class EmpController {
    @Autowired
	EmpDao dao;
	@RequestMapping("/empform")
	public ModelAndView showform(){
		return new ModelAndView("empform","command",new Emp());
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}
	

	@RequestMapping(value="/viewemp/{pageid}")
	public ModelAndView viewSV(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 2;
		double pageTotal = (int) Math.ceil(dao.countSV()/perPage);
 		int start = (pageid-1)*(int)perPage;
		List<Emp> listsv = dao.getSVbyPage(start,(int)perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal",pageTotal);
		return new ModelAndView("viewemp", "listsv", listsv);
	}
	
/*	@RequestMapping("/viewemp")
	public ModelAndView viewemp(){
		List<Emp> list=dao.getEmployees();
		return new ModelAndView("viewemp","list",list);
	}*/
	
	@RequestMapping(value="/editemp/{id}")
	public ModelAndView edit(@PathVariable int id){
		Emp emp=dao.getEmpById(id);
		return new ModelAndView("empeditform","command",emp);
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Emp emp){
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}
	
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp/1");
	}

}