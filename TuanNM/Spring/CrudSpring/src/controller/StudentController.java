package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.StudentDao;
import entity.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;
	private int totalPage;

	@RequestMapping("/StudentList")
	public String getListStudent(HttpSession session) {
		int pageId = 0;
		if (session.getAttribute("pageIds") == null) {
			pageId = 0;
		} else {
			pageId = (int) session.getAttribute("pageIds");
		}
		return "redirect:/" + pageId;
	}

	@RequestMapping("/{pageId}")
	public ModelAndView listStudent(@PathVariable int pageId, Model model, HttpSession session) {
		double limit = 3.0;
		int totalStudent = dao.countStudent();
		totalPage = (int) Math.ceil(totalStudent / limit);
		if (pageId == 0) {
			pageId = 1;
		}
		int start = (pageId - 1) * (int) limit;
		if (pageId > totalPage) {
			pageId = totalPage;
		}
		List<Student> listStudent = dao.getStudent(start, (int) limit);
		model.addAttribute("pageId", pageId);
		model.addAttribute("totalPage", totalPage);
		session.setAttribute("pageIds", pageId);
		session.setAttribute("totalPages", totalPage);

		return new ModelAndView("StudentList", "list", listStudent);
	}

	@RequestMapping("/showForm")
	public ModelAndView showInsert() {
		return new ModelAndView("insertStudent", "command", new Student());
	}


	@RequestMapping(value = "/inserts", method = RequestMethod.POST)
	public String index(@Valid @ModelAttribute("command") Student student, BindingResult result,
			 HttpServletRequest request,
			Model model) {
		String nameFile = student.getFile().getOriginalFilename();
		if (!"".equals(nameFile)) {
			String dirFile = request.getServletContext().getRealPath("uploads");
			System.out.println(dirFile);
			File fileDir = new File(dirFile);
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			try {
				student.getFile().transferTo(new File(fileDir + File.separator + nameFile));
				System.out.println("Upload file thành công!");
				System.out.println(nameFile);
				model.addAttribute("filename", nameFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
		}
		if (result.hasErrors()) {
			return "insertStudent";
		} else {
			dao.insert(student,nameFile);
		}
		return "redirect:/StudentList";
	}

	@RequestMapping(value = "/delete/{code}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable int code, Model model, HttpSession session) {
		dao.delete(code);
		return new ModelAndView("redirect:/StudentList");
	}

	@RequestMapping("/editStudent/{code}")
	public ModelAndView editStudent(@PathVariable int code) {
		Student st = dao.getStudentById(code);
		return new ModelAndView("editStudent", "command", st);
	}

	@RequestMapping(value = "/editStudent", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("student") Student student, HttpSession session) {
		dao.updateStudent(student);
		return new ModelAndView("redirect:/StudentList");
	}

	@ModelAttribute("classList")
	public Map<String, String> getCountryList() {
		Map<String, String> countryList = new HashMap<String, String>();
		countryList.put("FFSE1701", "FFSE1701");
		countryList.put("FFSE1702", "FFSE1702");
		countryList.put("FFSE1703", "FFSE1703");
		countryList.put("FFSE1704", "FFSE1704");
		return countryList;
	}

}
