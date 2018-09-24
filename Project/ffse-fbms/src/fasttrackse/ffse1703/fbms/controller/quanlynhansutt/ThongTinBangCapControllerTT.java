package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinBangCapTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.ThongTinBangCapServiceTT;

@Controller
@RequestMapping("/quanlybangcap/")
public class ThongTinBangCapControllerTT {
	@Autowired
	private ThongTinBangCapServiceTT thongTinBangCapServiceTT;
	
	public void setThongTinBangCapServiceTT(ThongTinBangCapServiceTT thongTinBangCapServiceTT) {
		this.thongTinBangCapServiceTT = thongTinBangCapServiceTT;
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewBangCap(Model model) {
		model.addAttribute("listBangCap", thongTinBangCapServiceTT.listBangCap());
		return "QuanLyNhanSuTT/QuanLyBangCapTT/viewBangCap";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showFormAdd(Model model, final RedirectAttributes redirectAttributes) {
		ThongTinBangCapTT hsnv = new ThongTinBangCapTT();
		model.addAttribute("ttbc", hsnv);
		return "QuanLyNhanSuTT/QuanLyBangCapTT/add_form";
	}
	
	@RequestMapping("/edit/{id}")
	public String showFormUpdate(@PathVariable("id") int id, Model model)
			throws IllegalStateException, IOException {
		model.addAttribute("ttbc", thongTinBangCapServiceTT.findByBangCap(id));
		return "QuanLyNhanSuTT/QuanLyBangCapTT/edit_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHopDong(@ModelAttribute("ttbc") @Valid ThongTinBangCapTT ttbc, BindingResult result) {
		if (ttbc.getId() == 0) {
			// new person, add it
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/QuanLyBangCapTT/add_form";

			}
			thongTinBangCapServiceTT.addThongTinBangCap(ttbc);
		} else {
			// existing person, call update
		if (result.hasErrors()) {
				return "QuanLyNhanSuTT/QuanLyBangCapTT/edit_form";
			}
		thongTinBangCapServiceTT.updateThongTinBangCap(ttbc);
		}
		return "redirect:/quanlybangcap/";
	}
	
}
