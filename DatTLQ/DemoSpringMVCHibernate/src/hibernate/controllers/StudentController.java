package hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;

import hibernate.entity.Student;
import hibernate.service.StudentService;
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	public void setStudentService(StudentService sv){
		this.studentService = sv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listStudent(Student sv,Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listStudent", this.studentService.listStudent());
		return "StudentList";
	}

	//For add and update person both
	@RequestMapping(value= "add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student sv){
		
		if(sv.getId() == 0){
			//new person, add it
			this.studentService.addStudent(sv);
		}else{
			//existing person, call update
			this.studentService.updateStudent(sv);
		}
		
		return "redirect:/studentlist";
		
	}
	
	@RequestMapping("/deleteemp/{id}")
    public String removeStudent(@PathVariable("id") int id){
		
        this.studentService.removeStudent(id);
        return "redirect:/student";
    }
 
    @RequestMapping("/editemp/{id}")
    public ModelAndView editStudent(@PathVariable("id") int id){
        Student st = this.studentService.getStudentById(id);
        return new ModelAndView("edit", "command", st);
    }
}
