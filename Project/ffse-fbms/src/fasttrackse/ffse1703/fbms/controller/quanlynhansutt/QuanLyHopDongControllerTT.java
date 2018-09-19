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

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.HopDongServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.LoaiHopDongServiceTT;
import fasttrackse.ffse1703.fbms.service.security.ChucDanhService;

@Controller
@RequestMapping("/quanlynhansutt/")
public class QuanLyHopDongControllerTT {

	@Autowired
	private LoaiHopDongServiceTT loaiHopDongServiceTT;

	@Autowired
	private ChucDanhService chucDanhService;
	@Autowired
	private HopDongServiceTT hopDongServiceTT;

	public LoaiHopDongServiceTT getLoaiHopDongServiceTT() {
		return loaiHopDongServiceTT;
	}

	public void setLoaiHopDongServiceTT(LoaiHopDongServiceTT loaiHopDongServiceTT) {
		this.loaiHopDongServiceTT = loaiHopDongServiceTT;
	}

	public HopDongServiceTT getHopDongServiceTT() {
		return hopDongServiceTT;
	}

	public void setHopDongServiceTT(HopDongServiceTT hopDongServiceTT) {
		this.hopDongServiceTT = hopDongServiceTT;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHopDong(Model model) {
		model.addAttribute("listHopDong", hopDongServiceTT.getAllHopDong());
		return "QuanLyNhanSuTT/QuanLyHopDongTT/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showFormAdd(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("hopDongTT", new HopDongTT());
		model.addAttribute("listChucDanh", chucDanhService.findAll());
		model.addAttribute("listLoaiHopDong", loaiHopDongServiceTT.findAll());
		return "QuanLyNhanSuTT/QuanLyHopDongTT/add_form";
	}

	@RequestMapping("/edit/{maHopDong}")
	public String showFormUpdate(@PathVariable("maHopDong") int maHopDong, Model model)
			throws IllegalStateException, IOException {
		model.addAttribute("hopDongTT", hopDongServiceTT.findByMaHopDong(maHopDong));
		return "QuanLyNhanSuTT/QuanLyHopDongTT/edit_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHopDong(@ModelAttribute("hopDongTT") @Valid HopDongTT hd, BindingResult result) {
		if (hd.getMaHopDong() == 0) {
			// new person, add it
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/QuanLyHopDongTT/add_form";

			}
			hopDongServiceTT.addHopDong(hd);
		} else {
			// existing person, call update
			if (result.hasErrors()) {
				return "QuanLyNhanSuTT/QuanLyHopDongTT/edit_form";
			}
			hopDongServiceTT.updateHopDong(hd);
		}
		return "redirect:/quanlynhansutt/";
	}
}
