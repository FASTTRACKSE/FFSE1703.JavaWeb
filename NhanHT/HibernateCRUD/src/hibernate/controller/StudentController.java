package hibernate.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import hibernate.model.Student;
import hibernate.service.StudentService;

@Controller
public class StudentController {
	// Trang index
	public int currentPage = 1;
	// Số sinh viên trên 1 trang
	public int soBanGhi = 4;
	private StudentService studentService;

	@RequestMapping("/")
	public String redirect(HttpSession session) {
		if (session.getAttribute("page") != null) {
			currentPage = (int) session.getAttribute("page");
		}
		return "redirect:/" + currentPage;
	}

	@Autowired
	@Qualifier(value = "studentServiceImpl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/{pageid}", method = RequestMethod.GET)
	public String listStudent(@PathVariable int pageid, Model model, HttpSession session) {

		int tongTrang = (int) Math.ceil((long) studentService.total() / (double) soBanGhi);

		// Điểm bắt đầu lấy bản ghi trong database
		int start = (int) ((pageid - 1) * soBanGhi);

		model.addAttribute("total", tongTrang);
		model.addAttribute("page", pageid);
		session.setAttribute("page", pageid);
		model.addAttribute("listStudent", this.studentService.listStudent(start, soBanGhi));
		return "student";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showformadd(Model model) {
		model.addAttribute("command", new Student());
		return "formStudent";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("command") @Valid Student p, BindingResult result,
			@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {

		if (p.getId() == 0) {
			// new person, add it
			if (result.hasErrors()) {
				return ("formStudent");
			}
			if (!file.isEmpty()) {
				p.setAvatar(upload(file, request));
			}
			studentService.addStudent(p);
		} else {
			// existing person, call update
			if (result.hasErrors()) {
				return ("formStudent");
			}
			if (p.avatar != null) {
				if (!file.isEmpty()) {
					p.setAvatar(upload(file, request));
				}
			}
			studentService.updateStudent(p);
		}
		return "redirect:/";

	}

	@RequestMapping("/remove/{id}")
	public String removeStudent(@PathVariable("id") int id) {
		studentService.removeStudent(id);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") int id, Model model) throws IllegalStateException, IOException {
		model.addAttribute("student", studentService.getStudentById(id));
		return "formEditStudent";
	}

	public String upload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = "";
		String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\";
		if (file != null) {
			fileName = file.getOriginalFilename();
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;
	}
}
