package vn.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import vn.model.*;  
import vn.dao.*;  
@Controller  
public class StudentController {  
    @Autowired  
    StudentDao dao;//will inject dao from xml file 
    public static int pageIndex;
	public static double totalPage;
	public static double totalRecord;
	public static double recordPerPage;
	
	List<Student> list = new ArrayList<>();
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
//    @RequestMapping("/empform")  
//    public ModelAndView showform(){  
//        return new ModelAndView("empform","command",new Student());  
//    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("command") @Valid Student emp, BindingResult res){
    	if(res.hasErrors()) {
    		return new ModelAndView("/empform");
    	}
    	redirectedUrl("utf-8");
        dao.save(emp);  
        return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml 
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/{pageid}")  
    public ModelAndView viewemp(@PathVariable int pageid){  
//    	 int total=3;  
//         if(pageid==1){}  
//         else{  
//             pageid=(pageid-1)*total+1;  
//         }  
//         List<Student> list=dao.getEmployees(pageid,total);  
//           
//         return new ModelAndView("viewemp","list",list); 
    	totalRecord = dao.totalRecord();
		recordPerPage = 2.0;
		totalPage = Math.ceil(totalRecord / recordPerPage);
		
		pageIndex = pageid;
		
		int start = (pageid - 1) * (int)recordPerPage;
		
		System.out.println("page index: " + pageid);
		list = dao.getEmployees(start, (int)recordPerPage);
		ModelAndView model = new ModelAndView("index");
		model.addObject("list", list);
		model.addObject("totalPage", (int)totalPage);
		model.addObject("pageIndex", pageid);
		return model ;
     }   
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editemp/{id}")  
    public ModelAndView edit(@PathVariable int id){  
    	redirectedUrl("utf-8");
    	Student emp=dao.getEmpById(id);  
        return new ModelAndView("empeditform","command",emp);  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("emp") Student emp){  
    	redirectedUrl("utf-8");
        dao.update(emp);  
        return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml   
    }  
  
}  
