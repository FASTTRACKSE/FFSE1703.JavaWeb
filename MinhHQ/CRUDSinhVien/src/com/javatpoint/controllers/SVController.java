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
import com.javatpoint.beans.SinhVien;  
import com.javatpoint.dao.SVDao;  
@Controller  
public class SVController {  
    @Autowired  
    SVDao dao;
    
    @RequestMapping("/empform")  
    public ModelAndView showform(){  
        return new ModelAndView("svform","command",new SinhVien());  
    }  
   
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("emp") SinhVien emp, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException {
		emp.setAvatar(uploadFile(file, session));
        dao.save(emp);  
        return new ModelAndView("redirect:/viewsv/1");
    }  
    
    @RequestMapping(value="/viewsv/{pageid}")  
    public ModelAndView viewSV(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 2;
		double pageTotal = (int) Math.ceil(dao.countSV()/perPage);
 		int start = (pageid*(int)perPage)-(int)perPage;
		List<SinhVien> listsv = dao.getEmployeesByPage(start,(int)perPage);
		model.addAttribute("pageid",(int)pageid);
		model.addAttribute("pagetotal",(int)pageTotal);
		return new ModelAndView("viewsv", "listsv", listsv);
    }
    
    @RequestMapping(value="/editemp/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        SinhVien emp=dao.getEmpById(id);  
        return new ModelAndView("sveditform","command",emp);  
    }  

    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("emp") SinhVien emp, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException {
		emp.setAvatar(uploadFile(file, session));
        dao.update(emp);  
        return new ModelAndView("redirect:/viewsv/1");  
    }  

    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/viewsv/1");  
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