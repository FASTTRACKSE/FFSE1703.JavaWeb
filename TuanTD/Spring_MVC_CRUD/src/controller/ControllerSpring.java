package controller;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import model.dao.*;
import model.entity.*;

@Controller
@SessionAttributes("page")
public class ControllerSpring {
	public int perPage = 2;
	public int currentPage = 1;
	@Autowired
	SinhVienDAO sinhVienDAO;

	@RequestMapping("/")
	public String redirectPage(HttpSession session, Model model) {
		if (session.getAttribute("page") != null) {
			currentPage = (int) session.getAttribute("page");
		}
		if (totalPage(perPage) < 1) {
			model.addAttribute("emptyStudent", "rỗng");
			return "EmptyListStudent";
		}
		return "redirect:/list/" + currentPage;
	}

	@RequestMapping("/list/{page}")
	public String listStudent(Model model, @PathVariable("page") int page) throws SQLException {
		int start = (page - 1) * perPage;
		List<SinhVien> list = sinhVienDAO.getAllStudent(start, perPage);
		model.addAttribute("list", list);
		model.addAttribute("total", totalPage(perPage));
		model.addAttribute("page", page);
		return "StudentList";
	}

	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) sinhVienDAO.countStudent() / (double) perPage);
		return totalPage;
	}

	@RequestMapping("/add")
	public String showFormInsert(Model model) throws SQLException {
		model.addAttribute("command", new SinhVien());
		return "StudentFormInsert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertStudent(@ModelAttribute("command") @Valid SinhVien student,
			@RequestParam("file") MultipartFile file, BindingResult result, Model model)
			throws SQLException, IllegalStateException, IOException {
		System.out.println(file.getOriginalFilename());
		student.setAvatar(uploadFile(file));
		if (result.hasErrors()) {
			return "StudentFormInsert";
		}
		if (sinhVienDAO.checkStudent(student.maSV) == false) {
			sinhVienDAO.insertStudent(student);
			model.addAttribute("page", totalPage(perPage));
		} else {
			model.addAttribute("message", "Mã sinh viên đã tồn tại");
			return "StudentFormInsert";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/edit/{maSV}")
	public String showFormEdit(@PathVariable String maSV, Model model) throws SQLException {
		SinhVien sv = sinhVienDAO.getStudent(maSV);
		model.addAttribute("command", sv);
		return "StudentFormUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("command") @Valid SinhVien student,
			@RequestParam("file") MultipartFile file, BindingResult result, Model model)
			throws SQLException, IllegalStateException, IOException {
		student.setAvatar(uploadFile(file));
		if (result.hasErrors()) {
			return "StudentFormUpdate";
		}
		sinhVienDAO.updateStudent(student);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{maSV}")
	public String deleteStudent(@PathVariable String maSV, Model model, HttpSession session) throws SQLException {
		sinhVienDAO.deleteStudent(maSV);
		if ((int) session.getAttribute("page") > totalPage(perPage)) {
			model.addAttribute("page", totalPage(perPage));
		}
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		String path = "E:\\FFSE1703.JavaWeb\\TuanTD\\Spring_MVC_CRUD\\WebContent\\WEB-INF\\resource\\upload";
		if (fileName != null) {
			File fileUpload = new File(path + File.separator, fileName);
			file.transferTo(fileUpload);
		} else {
			fileName = "default.png";
		}
		return fileName;
	}

//	@RequestMapping(method = RequestMethod.POST)
//	public String uploadFile2(MultipartFile file) throws IllegalStateException, IOException {
//		String fileName = file.getOriginalFilename();
//		InputStream input = file.getInputStream();
//		return fileName;
//	}
}
