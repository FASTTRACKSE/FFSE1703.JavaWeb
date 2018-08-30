package com.fasttrack.spring;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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

import com.fasttrack.model.Student;
import com.fasttrack.service.StudentService;

@Controller
public class StudentController {

	StudentService studentService;

	@Autowired(required = true)
	@Qualifier(value = "studentServiceImpl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = studentService.listStudent().size();
		int recordsPerPage = 2;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("listStudent", studentService.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listSinhVien", studentService.listStudent());
		return "create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("student") @Valid Student sv, HttpServletRequest request,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "create";
		}
		sv.setAvatar(uploadFile(file, request));
		studentService.create(sv);
		return "redirect:/list";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpServletRequest request, Model model) {
		studentService.delete(id);
		return "redirect:/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		return "edit";
	}
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		return "view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, HttpServletRequest request, MultipartFile file,
			@ModelAttribute("student") @Valid Student student, BindingResult bindingResult)
			throws IllegalStateException, IOException {
		if (student.getAvatar() != null) {
			if (!file.isEmpty()) {
				deleteFile(student.getAvatar(), request);
				student.setAvatar(uploadFile(file, request));
			}
		}
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		studentService.update(student);
		return "redirect:/list";
	}

	public String uploadFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("hhmmssddMMyyyy");
		String fileName = fm.format(date) + "_" + file.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\upload\\";
		if (fileName.isEmpty()) {
			fileName = "default.png";
		} else {
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;
	}

	public boolean deleteFile(String fileName, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\upload\\";
		File file = new File(path, fileName);
		boolean result = file.delete();
		return result;
	}
}