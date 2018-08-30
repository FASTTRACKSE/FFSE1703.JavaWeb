package assignment5.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import assignment5.dao.SinhVienDB;
import assignment5.entity.*;
@Controller
public class ControllerSpring {
	@Autowired
	private SinhVienDB dao;
	static int  pageTrang =0;
	private static final String UPLOAD_DIRECTORY ="/upload";  
	 @RequestMapping("/")  
	    public ModelAndView show(){  
	        return new ModelAndView("redirect:/1");  
	    }
	 @RequestMapping("/{pageid}")  
	    public ModelAndView showIndex(@PathVariable int pageid){  
		 int tongSv=dao.count();		 
		 int total=3;
		 int soTrang = (int)Math.ceil(tongSv/(total*1.0));
		 pageTrang=pageid;		 
		 List<SinhVien> list=dao.getStudent(((pageid-1)*total),total);
		 ModelAndView model = new ModelAndView("index");
		 model.addObject("page",pageid);
		 model.addObject("soTrang",soTrang);
		 model.addObject("list",list);
	        return model;         
	    }
	 @RequestMapping("/edit/{id}")  
	    public ModelAndView editStudent(@PathVariable int id){  
		 SinhVien sv=dao.getStudentId(id); 
	        return new ModelAndView("edit","student",sv);  	        
	    }
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("sinhvien") @Valid SinhVien sv, BindingResult result){ 
		 if(result.hasErrors()) {
				return new ModelAndView("redirect:/edit/"+sv.getId());
		 }
	        dao.update(sv);  
	        return new ModelAndView("redirect:/");  
	    } 
	 @RequestMapping(value="/delete/{id}")  
	    public ModelAndView delete(@PathVariable int id){  
	        dao.delete(id);  
	        int tongSv=dao.count();		 
			int total=3;
			int soTrang = (int)Math.ceil(tongSv/(total*1.0));
			if(pageTrang>soTrang) {
				pageTrang=soTrang;
			}
	        return new ModelAndView("redirect:/"+pageTrang);  
	    }
	 @RequestMapping("/add")  
	    public ModelAndView showAdd(){  
	        return new ModelAndView("add");  	        
	    }	 		 
	       
	 @RequestMapping(value="/addsave",method=RequestMethod.POST)  
	    public ModelAndView saveimage(@ModelAttribute("command") @Valid SinhVien sv, BindingResult result,
				@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws Exception{  
		 if(result.hasErrors()) {
				return new ModelAndView("add");
		}
	    ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	  
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	    sv.setHinhAnh(filename);
	    dao.add(sv);;  
        return new ModelAndView("redirect:/");  
	   
	    } 
}
