package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.SinhVienDao;
import entity.SinhVien;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienDao sinhVienDao;
	
	public static int pageIndex;
	public static double totalPage;
	public static double totalRecord;
	public static double recordPerPage;
	public static SinhVien getSv = new SinhVien();
	
	// đường dẫn upload file
	private static final String UPLOAD_DIRECTORY ="/upload";  
	
	
	List<SinhVien> listSinhVien = new ArrayList<>();
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/1";
	}
	
	@RequestMapping(value= "/{pageid}")
	public ModelAndView sinhvienlist(@PathVariable int pageid) {
		totalRecord = sinhVienDao.totalRecord();
		recordPerPage = 2.0;
		totalPage = Math.ceil(totalRecord / recordPerPage);
		
		pageIndex = pageid;
		
		int start = (pageid - 1) * (int)recordPerPage;
		if(start < 0) {
			start =0;
		}
		
		System.out.println("page index: " + pageid);
		listSinhVien = sinhVienDao.sinhVienList(start, (int)recordPerPage);
		ModelAndView model = new ModelAndView("index");
		model.addObject("listSinhVien", listSinhVien);
		model.addObject("totalPage", (int)totalPage);
		model.addObject("pageIndex", pageid);
		model.addObject("stt", 1);
		return model ;
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("command") @Valid SinhVien sv, BindingResult result,
			@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException{
		sv.setHinhAnh(getSv.getHinhAnh()); // thuộc tính hình ảnh đang null -> phải set dữ liệu
		if(result.hasErrors()) {
			return new ModelAndView("editform");
		}
		System.out.println("file: " + file);
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();
		System.out.println("file name: " + filename);
		if(!filename.isEmpty()) {
		System.out.println(path + " " + filename);
		byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));
	    sv.setHinhAnh(filename);
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
		}
		sinhVienDao.update(sv);
        return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml  
    }  
	
	@RequestMapping("/editSv/{maSv}")
	public ModelAndView getSv(@PathVariable String maSv) {
		getSv = sinhVienDao.getEdit(maSv);
		return new ModelAndView("editform", "command", getSv); // "command" mặc định của spring frame work
	}
	
	@RequestMapping("deleteSv/{maSv}")
	public ModelAndView delete(@PathVariable String maSv) {
		sinhVienDao.delete(maSv);
		totalRecord = sinhVienDao.totalRecord();
		totalPage = Math.ceil(totalRecord / recordPerPage);
		if(pageIndex > (int)totalPage) {
			pageIndex = (int)totalPage;
		}
		return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml
	}
	
	@RequestMapping(value= {"/addSv"}, method=RequestMethod.GET)
	public ModelAndView addSv() {
		return new ModelAndView("addform", "command", new SinhVien()); // "command" mặc định của spring frame work
	}
	
	@RequestMapping(value= "/addSave", method=RequestMethod.POST)
	public @ResponseBody ModelAndView addSave(@ModelAttribute("command") @Valid SinhVien sv ,BindingResult result, 
			@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException {
		
		System.out.println("mã sinh viên: " + sv.getMaSv());
		int check = sinhVienDao.checkExistMaSv(sv.getMaSv());
		System.out.println("check: " + check);
		if(result.hasErrors()) {
			return new ModelAndView("addform");
		}
		
		if(check > 0) {
			String message = "Mã sinh viên đã tồn tại";
			return new ModelAndView("addform", "mess", message);
		} else {
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);
			String filename = file.getOriginalFilename();
			System.out.println(path + " " + filename);
			byte[] bytes = file.getBytes();  
		    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
		         new File(path + File.separator + filename))); 
		    sv.setHinhAnh(filename);
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();
			sinhVienDao.insert(sv);
			return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml
		}
		
	}
	
	
}
