package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.dao.*;
import model.entity.*;

@Controller
public class ControllerSpring {

	@Autowired
	SinhVienDAO sinhVienDAO;

	@RequestMapping("/")
	public ModelAndView listStudent() throws SQLException {
		List<SinhVien> list = sinhVienDAO.getAllStudent();
		return new ModelAndView("list", "list", list);
	}

	@RequestMapping("/add")
	public ModelAndView showFormInsert() throws SQLException {
		return new ModelAndView("forminsert", "command", new SinhVien());
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute("sinhVien") SinhVien student) throws SQLException {
		sinhVienDAO.insertStudent(student);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit/{maSV}")
	public ModelAndView showFormEdit(@PathVariable String maSV) throws SQLException {
		SinhVien sv = sinhVienDAO.getStudent(maSV);
		return new ModelAndView("formupdate", "command", sv);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("sinhVien") SinhVien student) throws SQLException {
		sinhVienDAO.updateStudent(student);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/delete/{maSV}")
	public ModelAndView deleteStudent(@PathVariable String maSV) throws SQLException {
		sinhVienDAO.deleteStudent(maSV);
		return new ModelAndView("redirect:/");
	}
}
