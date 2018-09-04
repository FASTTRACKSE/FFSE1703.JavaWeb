package com.javatpoint.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.javatpoint.beans.Emp;
import com.javatpoint.dao.EmpDao;

@Controller
public class EmpController {
	@Autowired
	EmpDao dao;

	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform", "command", new Emp());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp, HttpSession session,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		emp.setAvatar(uploadFile(file, session));
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp/1");// will redirect to viewemp request mapping
	}

	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Emp emp = dao.getEmpById(id);
		return new ModelAndView("empeditform", "command", emp);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Emp emp, HttpSession session,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		if (emp.getAvatar() != null) {
			if (!file.isEmpty()) {
				emp.setAvatar(uploadFile(file, session));
			}
		}
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp/1");
	}

	@RequestMapping(value = "/viewemp/{pageid}")
	public ModelAndView viewemp(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 2;
		double pageTotal = (int) Math.ceil(dao.countSV() / perPage);
		int start = (pageid - 1) * (int) perPage;
		List<Emp> listsv = dao.getSVbyPage(start, (int) perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal", pageTotal);
		return new ModelAndView("viewemp", "listsv", listsv);
	}

	public String uploadFile(MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("hhmmssddMMyyyy");
		String fileName = fm.format(date) + "_" + file.getOriginalFilename();
		String path = session.getServletContext().getRealPath("/") + "\\resources\\upload\\";
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

}