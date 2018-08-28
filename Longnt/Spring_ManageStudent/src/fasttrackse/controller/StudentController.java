package fasttrackse.controller; 
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import fasttrackse.dao.EmpDao;
import fasttrackse.entity.Student;   
@Controller  
public class StudentController {  
    @Autowired  
    EmpDao dao; 
    @RequestMapping(value="/list") 
   public String getList() {
	   return "redirect:/1";
   }
    @RequestMapping(value="/{pageid}")  
    public ModelAndView listStudent(@PathVariable int pageid,Model model) throws SQLException{  
    	double total=2; 
    	double totalStudent = dao.countStudent();
    	int totalPage = (int) Math.ceil(totalStudent/total);
    	if (pageid  == 0 ) {
			pageid = 1;
		}
    	int start = (pageid -1)*(int)total;
    	
        List<Student> list = dao.getAllStudent(start,(int)total);
        model.addAttribute("pageId", pageid);
        model.addAttribute("totalPage", totalPage);
		return new ModelAndView("list", "list", list); 
    } 
    
    @RequestMapping("/forminsert")
	public ModelAndView showFormInsert() throws SQLException {
		return new ModelAndView("forminsert", "command", new Student());
	}
    
    @RequestMapping(value="/insert",method = RequestMethod.POST)  
    public ModelAndView insertStudent(@ModelAttribute("command") @Valid Student sinhvien, BindingResult errors,
    		@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{ 
    	sinhvien.setAvatar(uploadFile(file, request));
    	 if (errors.hasErrors()) {
    	        return new ModelAndView("forminsert");
    	    }
    	 System.out.println("mã sinh viên: " + sinhvien.getMaSV());
    	 int check = dao.check(sinhvien.getMaSV());
    	 System.out.println("check: " + check);
    	 if(check > 0) {
 			String message = "Mã sinh viên đã tồn tại";
 			return new ModelAndView("forminsert", "mess", message);
 		} else {
 			dao.insertStudent(sinhvien);
 	      
 		}
    	  return new ModelAndView("redirect:/list"); 
        
    }  

    @RequestMapping(value = "/formupdate/{maSV}")
    public ModelAndView showFormEdit(@PathVariable String maSV) throws SQLException{
    Student sv = dao.getStudent(maSV);
    return new ModelAndView("formupdate","command",sv);
    }
    
    @RequestMapping(value = "/formupdate", method = RequestMethod.POST)
    public ModelAndView updateStident(@ModelAttribute("sinhvien") Student student) throws SQLException{
    	dao.updateStudent(student);
    	return new ModelAndView("redirect:/list");
    }
    
    @RequestMapping(value = "/list/{maSV}")
    public ModelAndView deleteStudent(@PathVariable String maSV, HttpServletRequest request) throws SQLException{
    	 Student sv = dao.getStudent(maSV);
    	dao.deleteStudent(maSV);
    	deleteFile(sv.avatar, request);
    	return new ModelAndView("redirect:/list");
    }


	public String uploadFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("hhmmssddMMyyyy");
		String fileName = fm.format(date)+"_"+file.getOriginalFilename();
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
	
	public boolean deleteFile(String fileName,HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\upload\\";
		File file = new File(path , fileName);
		boolean result = file.delete();
		return result;
	}
    
  
}  