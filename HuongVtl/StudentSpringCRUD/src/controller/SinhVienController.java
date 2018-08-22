package controller;

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

import bean.SinhVien;
import dao.SinhVienDB;

@Controller  
public class SinhVienController {
	  @Autowired  
	  SinhVienDB db;
	  @RequestMapping("/")  
	   public ModelAndView showform(){  
		  List<SinhVien> sv = db.listSinhVien();
	        return new ModelAndView("danhsach","list",sv);  
	    }
	  @RequestMapping("/them") 
	  public ModelAndView themSv(){  
		 
	        return new ModelAndView("themsv", "command", new SinhVien());  
	    }
	  @RequestMapping(value="/themSv",method = RequestMethod.POST)
	  public ModelAndView luuSv( @ModelAttribute("command") @Valid SinhVien sv, BindingResult res){  
		   if(res.hasErrors()) {
	            return new ModelAndView("themsv");
	        }
			db.save(sv);
	        return new ModelAndView("redirect:/");  
	    }
	  @RequestMapping(value="/edit/{id}")  
	    public ModelAndView suasv(@PathVariable int id){  
	        SinhVien sv= db.edit(id);  
	        return new ModelAndView("suasv","command",sv);  
	    }  
	  @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("sv")  @Valid  SinhVien sv, BindingResult res){ 
		  if(res.hasErrors()) {
			  return new ModelAndView("redirect:/edit/"+sv.getId());  
	        }
		 
	        db.update(sv);  
	        return new ModelAndView("redirect:/");  
	    }  
	  @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
		  db.delete(id);  
	        return new ModelAndView("redirect:/");  
	    } 
	  
	  @RequestMapping(value="uploadfile")
	  public class UploadFileController {
	  	
	  	@RequestMapping(method=RequestMethod.GET)
	  	public String index(){
	  		return "upload";
	  	}
	  }
	  
	  private static final String UPLOAD_DIRECTORY ="/images";  
      
	    @RequestMapping("uploadform")  
	    public ModelAndView uploadForm(){  
	        return new ModelAndView("uploadform");    
	    }  
	      
	    @RequestMapping(value="savefile",method=RequestMethod.POST)  
	    public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws Exception{  
	  
	    ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	  
	    System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();  
	           
	    return new ModelAndView("uploadform","filesuccess","File successfully saved!");  
	    }  
}
