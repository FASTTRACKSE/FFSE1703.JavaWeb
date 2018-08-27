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
	public int perPage = 2;
	public int currentPage = 1;
    @Autowired
	EmpDao dao;//will inject dao from xml file
    
    
	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) dao.countStudent() / (double) perPage);
		return totalPage;
	}
	
	@RequestMapping("/viewemp")
	public String redirectPage(HttpSession session, Model model) {
		if (session.getAttribute("page") != null) {
			currentPage = (int) session.getAttribute("page");
		}
		if (totalPage(perPage) < 1) {
			model.addAttribute("emptyStudent", "rỗng");
			return "viewemp";
		}
		return "redirect:/list/" + currentPage;
	}
	
	@RequestMapping("/list/{page}")
	public String listStudent(Model model, @PathVariable("page") int page) throws SQLException {
		int start = (page - 1) * perPage;
		List<Emp> list = dao.getEmployees(start, perPage);
		model.addAttribute("list", list);
		model.addAttribute("total", totalPage(perPage));
		model.addAttribute("page", page);
		return "viewemp";
	}
    
    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
	@RequestMapping("/empform")
	public ModelAndView showform(){
		return new ModelAndView("empform","command",new Emp());
	}
	/*It saves object into database. The @ModelAttribute puts request data
	 *  into model object. You need to mention RequestMethod.POST method 
	 *  because default request is GET*/
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException {
		emp.setImage(uploadFile(file, session));
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping
	}
	
	

	/* It displays object data into form for the given id. 
	 * The @PathVariable puts URL data into variable.*/
    
	@RequestMapping(value="/editemp/{id}")
	public ModelAndView edit(@PathVariable int id){
		Emp emp=dao.getEmpById(id);
		return new ModelAndView("empeditform","command",emp);
	}
	/* It updates model object. */
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Emp emp, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException{
		emp.setImage(uploadFile(file, session));
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp");
	}
	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp");
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
	
	public boolean deleteFile(String fileName, HttpSession session) {
		String path = session.getServletContext().getRealPath("/") + "\\resources\\upload\\";
		File file = new File(path, fileName);
		boolean result = file.delete();
		return result;
	}

}