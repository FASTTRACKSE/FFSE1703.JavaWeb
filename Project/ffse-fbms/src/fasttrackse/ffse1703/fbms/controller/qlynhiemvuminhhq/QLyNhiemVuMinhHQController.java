package fasttrackse.ffse1703.fbms.controller.qlynhiemvuminhhq;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViec;
import fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq.*;




@Controller
@RequestMapping("/QuanLyNhiemVuMinhHQ/")
public class QLyNhiemvuMinhHQController {
	CongViecService congViecService;

	@Autowired
	public void setStudentService(CongViecService congViecService) {
		this.congViecService = congViecService;
	}

	@RequestMapping(value= {"/","/list"})
	public String index(Model model) {
		model.addAttribute("listCongViec", congViecService.findAll());
		return "/QuanLyNhiemVuMinhHQ/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("CongViec", new CongViec());
		return "/QuanLyNhiemVuMinhHQ/add_form";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("CongViec") @Valid CongViec cv, HttpServletRequest request) throws IllegalStateException {
		cv.setIsDelete(1);
		congViecService.addNew(cv);
		;
		return "redirect:/QuanLyNhiemVuMinhHQ/list";
	}

	@RequestMapping("/delete/{ID}")
	public String delete(@PathVariable("ID") int id, HttpServletRequest request, Model model) {
		CongViec cv = congViecService.findByID(id);
		cv.setIsDelete(0);
		congViecService.delete(cv);
		return "redirect:/QuanLyNhiemVuMinhHQ/list";
	}

	@RequestMapping(value = "/edit/{ID}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("ID") int id, Model model) {
		model.addAttribute("CongViec", congViecService.findByID(id));
		return "/QuanLyNhiemVuMinhHQ/edit_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("CongViec") @Valid CongViec CongViec, HttpServletRequest request
			)
			throws IllegalStateException {
		congViecService.update(CongViec);
		return "redirect:/QuanLyNhiemVuMinhHQ/list";
	}

}
