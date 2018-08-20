package spring.main;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		return new ModelAndView("svForm", "command", new SinhVien());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("command") @Valid SinhVien SinhVien, BindingResult rs) {
		if (rs.hasErrors()) {
			return "svForm";
		} else {
			SVDao.save(SinhVien);
		}
		return "redirect:/viewSV2";
	}
	@RequestMapping(value="/viewSV2")
	public String viewSVlist () {
		return "redirect:/viewSV/1";
	}

	@RequestMapping(value="/viewSV/{pageid}")
	public ModelAndView viewSV(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 2;
		double pageTotal = (int) Math.ceil(dao.countSV()/perPage);
 		int start = (pageid-1)*(int)perPage;
		List<SinhVien> listsv = dao.getSVbyPage(start,(int)perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal",pageTotal);
		return new ModelAndView("viewSV", "listsv", listsv);
	}

	@RequestMapping(value = "/editForm/{masv}")
	public ModelAndView edit(@PathVariable int masv) {
		SinhVien sv = dao.getSV(masv);
		return new ModelAndView("editFormSV", "command", sv);
	}

	@RequestMapping(value = "/editSave", method = RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("sv") SinhVien sv) {
		dao.update(sv);
		return new ModelAndView("redirect:/viewSV2");
	}

	@RequestMapping(value = "/deleteSV/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewSV2");
	}
}
