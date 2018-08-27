package hibernate.controller;

import java.io.BufferedOutputStream;
import java.io.File;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hibernate.entity.SinhVien;
import hibernate.service.SinhVienService;

@Controller
public class SinhVienController {
	private SinhVienService sinhVienService;
	
	@Autowired(required=true)
	@Qualifier(value="sinhVienServiceImpl")
	public void setSinhVienService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}
	
	public static int pageIndex;
	public static double totalPage;
	public static double totalRecord;
	public static double recordPerPage;
	public static SinhVien getSv = new SinhVien();
	
	// đường dẫn upload file
	private static final String UPLOAD_DIRECTORY ="/images";  
	
	
	List<SinhVien> listSinhVien = new ArrayList<>();
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/1";
	}
	
	@RequestMapping(value= "/{pageid}")
	public ModelAndView sinhvienlist(@PathVariable int pageid) {
		totalRecord = sinhVienService.totalRecord() ;
		System.out.println("total: " + totalRecord);
		recordPerPage = 2.0;
		totalPage = Math.ceil(totalRecord / recordPerPage);
		
		pageIndex = pageid;
		
		int start = (pageid - 1) * (int)recordPerPage;
		if(start < 0) {
			start =0;
		}
		
		System.out.println("page index: " + pageid);
		listSinhVien = sinhVienService.sinhVienList(start, (int)recordPerPage);
		ModelAndView model = new ModelAndView("index");
		model.addObject("listSinhVien", listSinhVien);
		model.addObject("totalPage", (int)totalPage);
		model.addObject("pageIndex", pageid);
		model.addObject("stt", 1);
		return model ;
	}
	
	@RequestMapping(value= {"/addSv"}, method=RequestMethod.GET)
	public ModelAndView addSv() {
		return new ModelAndView("addform", "command", new SinhVien()); // "command" mặc định của spring frame work
	}
	
	@RequestMapping(value= "/addSave", method=RequestMethod.POST)
	public @ResponseBody ModelAndView addSave(@ModelAttribute("command") @Valid SinhVien sv ,BindingResult result, 
			@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException {
		
		if(result.hasErrors()) {
			return new ModelAndView("addform");
		}
		
		
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
			sinhVienService.insert(sv);
			return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml
		
		
	}
	
	@RequestMapping("/editSv/{id}")
	public ModelAndView getSv(@PathVariable int id) {
		getSv = sinhVienService.getEdit(id);
		return new ModelAndView("editform", "command", getSv); // "command" mặc định của spring frame work
	}
	
	@RequestMapping("deleteSv/{id}")
	public ModelAndView delete(@PathVariable int id, HttpSession session) {
		// xóa hình ảnh
//		getSv = sinhVienService.getEdit(maSv);
//		ServletContext context = session.getServletContext();
//		String path = context.getRealPath(UPLOAD_DIRECTORY);
//		String filename = getSv.getHinhAnh();
//		File file = new File(path + File.separator + filename);
//		file.delete();
		// xóa thông tin sinh viên
		sinhVienService.delete(id);
		totalRecord = sinhVienService.totalRecord();
		totalPage = Math.ceil(totalRecord / recordPerPage);
		if(pageIndex > (int)totalPage) {
			pageIndex = (int)totalPage;
		}
		return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml
	}
}
