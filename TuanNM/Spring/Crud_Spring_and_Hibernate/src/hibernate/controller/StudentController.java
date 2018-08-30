package hibernate.controller;

import java.io.File;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hibernate.model.Student;
import hibernate.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	public void setStudentService(StudentService ps) {
		this.studentService = ps;
	}

	@RequestMapping("/StudentList")
	public String getListStudent(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIds") == null) {
			pageId = 1;
		} else {
			pageId = (int) session.getAttribute("pageIds");
		}
		return "redirect:/" + pageId;
	}
//	@RequestMapping(value = "/StudentList", method = RequestMethod.GET)
//	public String getAllSinhVien(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page,
//			@RequestParam(value = "step", defaultValue = "3") Integer step) {
//		Integer offset = (page - 1) * step;
//		model.addAttribute("count", this.studentService.countStudent());
//		model.addAttribute("offset", offset);
//		model.addAttribute("step", step);
//		model.addAttribute("list", this.studentService.listStudent(offset, step));
//		return "StudentList";
//	}
	
	@RequestMapping(value = "/{pageId}", method = RequestMethod.GET)
	public String listPersons(@PathVariable int pageId, Model model, @RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "step", defaultValue = "3") Integer step) {
		
		int offset = (pageId - 1) * step;
		Long totalStudent = studentService.countStudent();
		int totalPage = (int) Math.ceil(totalStudent / (double) step);
		if (pageId == 0) {
			pageId = 1;
		}
		
		if (pageId > totalPage) {
			pageId = totalPage;
		}
		
	
		model.addAttribute("list", this.studentService.listStudent(offset, step));
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("count",  totalStudent);
//		model.addAttribute("offset", offset);
//		model.addAttribute("step", step);
	
		return "StudentList";
	}

	@RequestMapping("/showForm")
	public ModelAndView showInsert() {
		return new ModelAndView("insertStudent", "command", new Student());
	}

	@RequestMapping(value = "/inserts", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("command") Student student, BindingResult result,
			@RequestParam("files") MultipartFile file, HttpServletRequest request, HttpSession session) {

		if (result.hasErrors()) {
			return "insertStudent";
		} else {
			String nameFile = file.getOriginalFilename();
			if (!"".equals(nameFile)) {
				String dirFile = request.getServletContext().getRealPath("upload");
				System.out.println(dirFile);
				File fileDir = new File(dirFile);
				if (!fileDir.exists()) {
					fileDir.mkdir();
				}
				try {
					file.transferTo(new File(fileDir + File.separator + nameFile));
					System.out.println("Upload file thành công!");
					System.out.println(nameFile);

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Upload file thất bại!");
				}
			}
			student.setAvatar(nameFile);
			this.studentService.addStudent(student);
			;
		}
		return "redirect:/StudentList";
	}

	@RequestMapping("/delete/{id}")
	public String removePerson(@PathVariable("id") int id) {
		this.studentService.removeStudent(id);
		return "redirect:/StudentList";
	}

	@RequestMapping("/editStudent/{id}")
	public String editStudent(@PathVariable int id, Model model) {
		Student st = studentService.getStudentById(id);
		model.addAttribute("student", st);
		return "editStudent";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("student") Student student, BindingResult result,
			HttpServletRequest request, @RequestParam("files") MultipartFile file) {
		student.setAvatar(student.getAvatar());
		String nameFile = file.getOriginalFilename();
		if (!"".equals(nameFile)) {
			String dirFile = request.getServletContext().getRealPath("upload");
			System.out.println(dirFile);
			File fileDir = new File(dirFile);
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			try {
				file.transferTo(new File(fileDir + File.separator + nameFile));
				System.out.println("Upload file thành công!");
				System.out.println(nameFile);
				student.setAvatar(nameFile);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		
		this.studentService.updateStudent(student);
		return new ModelAndView("redirect:/StudentList");
	}

}
