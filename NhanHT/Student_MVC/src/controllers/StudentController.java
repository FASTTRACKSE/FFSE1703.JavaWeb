package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import beans.Student;
import dao.StudentDao;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;

	@RequestMapping("/formStudent")
	public ModelAndView showform() {
		return new ModelAndView("formStudent", "command", new Student());
	}

    @RequestMapping("/list")  
    public ModelAndView view(){  
        List<Student> list=dao.getEmployees();  
       return new ModelAndView("list", "list", list);
    }
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("student") Student student){  
        dao.save(student);  
        return new ModelAndView("redirect:/list");
    } 
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/list");  
    } 
    @RequestMapping(value="/edit/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Student student=dao.getStudentId(id);  
        return new ModelAndView("formEditStudent","command",student);  
    }  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("student") Student student){  
        dao.update(student);  
        return new ModelAndView("redirect:/list");  
    }  
}
