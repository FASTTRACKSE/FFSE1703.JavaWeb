package spring.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.SVDao;
import spring.entity.SinhVien;

@Controller
public class AppController {
	
	@Autowired
	SVDao dao;
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/svForm")
	public ModelAndView showForm() {
		return new ModelAndView("svForm","command",new SinhVien());
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("SinhVien")SinhVien sv) {
		SVDao.save(sv);
		return new ModelAndView("redirect:/viewSV");
	}
	
	@RequestMapping("/viewSV")
	public ModelAndView viewSV() {
		List<SinhVien> listsv = dao.getSinhViens();
		return new ModelAndView("viewSV","listsv",listsv);
	}
	
	@RequestMapping(value="/editForm/{masv}")
	public ModelAndView edit(@PathVariable int masv) {
		SinhVien sv = dao.getSV(masv);
		return new ModelAndView("editFormSV","command",sv);
	}
	
	@RequestMapping(value="/editSave", method=RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("sv")SinhVien sv) {
		dao.update(sv);
		return new ModelAndView("redirect:/viewSV");
	}
	
	@RequestMapping(value="/deleteSV/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewSV");
	}
}
