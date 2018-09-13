package hibernate.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hibernate.entity.Student;
import hibernate.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;
	private static int  pageTrang =0;
	private static final String UPLOAD_DIRECTORY ="/images";  
	public StudentService getStudentService() {
		return studentService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="studentServiceImbl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping("/")
	public String index() {		
		return "redirect:/1";
	}
	
	@RequestMapping(value = "/{pageid}", method = RequestMethod.GET)
	public String listStudent(Model model,@PathVariable int pageid) {
		Long tongSv=studentService.countStudent();		 
		int total=2;
		int soTrang = (int)Math.ceil(tongSv/(total*1.0));
		pageTrang=pageid;
		model.addAttribute("page",pageid);
		model.addAttribute("soTrang",soTrang);
		model.addAttribute("student", new Student());		
		model.addAttribute("list", this.studentService.listStudent(((pageid-1)*total), total));
		return "index";
	}
	
	@RequestMapping("/add")
	public String add() {		
		return "add";
	}
	
	@RequestMapping(value= "/addSave", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student std,@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException{				
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();
		byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename))); 
	    std.setImage(filename);
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();			
		this.studentService.addStudent(std);	
			Long tongSv=studentService.countStudent();		 
			int total=2;
			int soTrang = (int)Math.ceil(tongSv/(total*1.0));			
		return "redirect:/"+soTrang;	
	}
	
	@RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable int id, Model model){
        model.addAttribute("command", this.studentService.getStudentById(id));        
        return "edit";
    }
	
	@RequestMapping(value= "/editSave", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute("student") Student std,@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException{	
		Student getSv = this.studentService.getStudentById(std.getId());
		System.out.println("file: " + file);
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();
		if(!filename.isEmpty()) {			
			byte[] bytes = file.getBytes();  
		    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
		         new File(path + File.separator + filename))); 
		    std.setImage(filename);
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();					
		}else {
			std.setImage(getSv.getImage());
		}			    
			this.studentService.updateStudent(std);				
		return "redirect:/"+pageTrang;	
	}
	
	@RequestMapping("/delete/{id}")
    public String removePerson(@PathVariable("id") int id, HttpSession session){		
		Student getSv = this.studentService.getStudentById(id);
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = getSv.getImage();
		File file = new File(path + File.separator + filename);
		file.delete();
		
        this.studentService.removeStudent(id);
		Long tongSv=studentService.countStudent();		 
		int total=2;
		int soTrang = (int)Math.ceil(tongSv/(total*1.0));
		if(pageTrang>=soTrang) {
			pageTrang=soTrang;
		}
		return "redirect:/"+pageTrang;
    }
}
