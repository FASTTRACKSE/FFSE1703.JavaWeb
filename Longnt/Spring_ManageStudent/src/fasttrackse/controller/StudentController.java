package fasttrackse.controller; 
import java.sql.SQLException;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
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
    public ModelAndView insertDtudent(@ModelAttribute("sinhvien") Student sinhvien){  
        dao.insertStudent(sinhvien);
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
    public ModelAndView deleteStudent(@PathVariable String maSV) throws SQLException{
    	dao.deleteStudent(maSV);
    	return new ModelAndView("redirect:/list");
    }
    
    
    
    
   
  
}  