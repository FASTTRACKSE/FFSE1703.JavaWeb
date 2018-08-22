package controller;

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
import org.springframework.web.context.annotation.SessionScope;
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
	
	List<SinhVien> listSinhVien = new ArrayList<>();
	
	@RequestMapping(value= "/{pageid}")
	public ModelAndView sinhvienlist(@PathVariable int pageid) {
		totalRecord = sinhVienDao.totalRecord();
		recordPerPage = 2.0;
		totalPage = Math.ceil(totalRecord / recordPerPage);
		
		pageIndex = pageid;
		
		int start = (pageid - 1) * (int)recordPerPage;
		
		System.out.println("page index: " + pageid);
		listSinhVien = sinhVienDao.sinhVienList(start, (int)recordPerPage);
		ModelAndView model = new ModelAndView("index");
		model.addObject("listSinhVien", listSinhVien);
		model.addObject("totalPage", (int)totalPage);
		model.addObject("pageIndex", pageid);
		return model ;
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("command") @Valid SinhVien sv, BindingResult result){ 
		if(result.hasErrors()) {
			return new ModelAndView("editform");
		}
		sinhVienDao.update(sv);
        return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml  
    }  
	
	@RequestMapping("/editSv/{maSv}")
	public ModelAndView getSv(@PathVariable String maSv) {
		SinhVien sv = sinhVienDao.getEdit(maSv);
		return new ModelAndView("editform", "command", sv); // "command" mặc định của spring frame work
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
	public ModelAndView addSave(@ModelAttribute("command") @Valid SinhVien sv, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("addform");
		}
		
		System.out.println("mã sinh viên: " + sv.getMaSv());
		int check = sinhVienDao.checkExistMaSv(sv.getMaSv());
		System.out.println("check: " + check);
		
		if(check > 0) {
			String message = "Mã sinh viên đã tồn tại";
			return new ModelAndView("addform", "mess", message);
		} else {
			sinhVienDao.insert(sv);
			totalRecord = sinhVienDao.totalRecord();
			recordPerPage = 2.0;
			totalPage = Math.ceil(totalRecord / recordPerPage);
			if(pageIndex < (int)totalPage) {
				pageIndex = (int)totalPage;
			}
			return new ModelAndView("redirect:/" + pageIndex); // mặc định trở về trang index. đã đc định nghĩa ở web.xml
		}
		
	}
	
	
}
