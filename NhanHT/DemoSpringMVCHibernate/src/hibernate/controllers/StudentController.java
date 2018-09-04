package hibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hibernate.model.Student;
import hibernate.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;

	@Autowired
	@Qualifier(value = "studentServiceImpl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listStudent(Model model) {
		model.addAttribute("listStudent", this.studentService.listStudent());
		return "student";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showformadd(Model model) {
		model.addAttribute("command", new Student());
		return "formStudent";
	}

	// For add and update person both
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("command") Student p) {
		System.out.println(p.getDiaChi());
		// if(p.getId() == 0){
		// //new person, add it
		this.studentService.addStudent(p);
		// }
		// else{
		// //existing person, call update
		// this.studentService.updateStudent(p);
		// }

		return "redirect:/student";

	}

	@RequestMapping("/remove/{id}")
	public String removeStudent(@PathVariable("id") int id) {

		this.studentService.removeStudent(id);
		;
		return "redirect:/student";
	}

	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", this.studentService.getStudentById(id));
		model.addAttribute("listStudent", this.studentService.listStudent());
		return "student";
	}
}
