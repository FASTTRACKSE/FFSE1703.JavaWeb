package fasttrackse.controller; 
import java.sql.SQLException;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
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
      
   
    @RequestMapping("/list")  
    public ModelAndView listStudent() throws SQLException{  
        List<Student> list = dao.getAllStudent();
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
    
    @RequestMapping(value = "/delete/{maSV}")
    public ModelAndView deleteStudent(@PathVariable String maSV) throws SQLException{
    	dao.deleteStudent(maSV);
    	return new ModelAndView("redirect:/list");
    }
    
    
    
    
   
  
}  