package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import beans.Student;
import dao.StudentDao;

@Controller
public class StudentController {
	// Trang index
	public int currentPage = 1;
	// Số sinh viên trên 1 trang
	public int soBanGhi = 4;

	@Autowired
	StudentDao dao;

	@RequestMapping("/")
	public String redirect(HttpSession session) {
		if (session.getAttribute("page") != null) {
			currentPage = (int) session.getAttribute("page");
		}
		return "redirect:/" + currentPage;
	}

	@RequestMapping("/formStudent")
	public ModelAndView showform() {
		return new ModelAndView("formStudent", "command", new Student());
	}

	@RequestMapping("/{pageid}")
	public ModelAndView view(@PathVariable int pageid, Model model, HttpSession session) {
		// Tổng số trang có sẵn
		int tongTrang = (int) Math.ceil((double) dao.total() / (double) soBanGhi);

		// Điểm bắt đầu lấy bản ghi trong database
		int start = (int) ((pageid - 1) * soBanGhi);

		List<Student> list = dao.getStudent(start, (int) soBanGhi);
		model.addAttribute("total", tongTrang);
		session.setAttribute("page", pageid);
		return new ModelAndView("list", "list", list);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("command") @Valid Student student, BindingResult result,
			HttpSession session, HttpServletRequest request, @RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {
		//
		student.setAvatar(upload(file, request));

		if (result.hasErrors()) {
			return new ModelAndView("formStudent");
		}
		int tongTrang = (int) Math.ceil((double) dao.total() / (double) soBanGhi);
		dao.save(student);
		session.setAttribute("page", tongTrang);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, HttpSession session) {
		dao.delete(id);
		int tongTrang = (int) Math.ceil((double) dao.total() / (double) soBanGhi);
		if ((int) session.getAttribute("page") > tongTrang) {
			session.setAttribute("page", tongTrang);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Student student = dao.getStudentId(id);
		return new ModelAndView("formEditStudent", "command", student);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("student") Student student, HttpSession session,
			HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		if (student.avatar != null) {
			if (file != null) {
				student.setAvatar(upload(file, request));
			}
		} else {
			student.setAvatar(upload(file, request));
		}
		dao.update(student);
		int tongTrang = (int) Math.ceil((double) dao.total() / (double) soBanGhi);
		if ((int) session.getAttribute("page") > tongTrang) {
			session.setAttribute("page", tongTrang);
		}
		return new ModelAndView("redirect:/");
	}

	public String upload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = "";
		String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\";
		System.out.println(file.getOriginalFilename());
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
