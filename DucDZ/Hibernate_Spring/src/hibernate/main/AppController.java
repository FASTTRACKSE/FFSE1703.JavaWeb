package hibernate.main;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hibernate.model.SinhVien;
import hibernate.service.SVService;

@Controller
public class AppController {

	private SVService sVService;

	@Autowired(required = true)
	@Qualifier(value = "sVService")
	public void setSVService(SVService sVService) {
		this.sVService = sVService;
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:/sinhvien";
	}

	@RequestMapping(value = "/sinhvien", method = RequestMethod.GET)
	public String listSV(Model model) {
		model.addAttribute("sv", new SinhVien());
		model.addAttribute("listsv", this.sVService.listSV());
		return "sinhvien";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSV(@ModelAttribute("sv") SinhVien sv) {
		if (sv.getId() == null) {
			this.sVService.addSV(sv);
		} else {
			this.sVService.updateSV(sv);
		}
		return "redirect:/sinhvien";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteSV(@PathVariable("id") int id) {
		this.sVService.deleteSV(id);
		return "redirect:/sinhvien";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editSV(@PathVariable("id") int id, Model model) {
		model.addAttribute("sv", this.sVService.getSVbyID(id));
		model.addAttribute("listsv", this.sVService.listSV());
		return "sinhvien";
	}
}
