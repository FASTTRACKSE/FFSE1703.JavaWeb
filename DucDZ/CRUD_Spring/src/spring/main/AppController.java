package spring.main;

import java.io.File;
import java.sql.SQLException;
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
	public String save(@ModelAttribute("command") @Valid SinhVien SinhVien, BindingResult rs,
			HttpServletRequest request, Model model) {
		if (rs.hasErrors()) {
			return "svForm";
		} else {
			String nameFile = SinhVien.getMyImage().getOriginalFilename();
			if (!"".equals(nameFile)) {
				String dirFile = request.getServletContext().getRealPath("upload");
				System.out.println(dirFile);
				File fileDir = new File(dirFile);
				if (!fileDir.exists()) {
					fileDir.mkdir();
				}
				try {
					SinhVien.getMyImage().transferTo(new File(fileDir+File.separator+nameFile));
					System.out.println("Upload file thành công!");
					System.out.println(nameFile);
					model.addAttribute("filename", nameFile);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Upload file thất bại!");
				}
				SVDao.save(SinhVien,nameFile);
			}
		}
		return "redirect:/viewSV2";
	}

	@RequestMapping(value = "/viewSV2")
	public String viewSVlist() {
		return "redirect:/viewSV/1";
	}

	@RequestMapping(value = "/viewSV/{pageid}")
	public ModelAndView viewSV(@PathVariable int pageid, Model model) throws SQLException {
		double perPage = 2;
		double pageTotal = (int) Math.ceil(dao.countSV() / perPage);
		int start = (pageid - 1) * (int) perPage;
		List<SinhVien> listsv = dao.getSVbyPage(start, (int) perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal", pageTotal);
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
