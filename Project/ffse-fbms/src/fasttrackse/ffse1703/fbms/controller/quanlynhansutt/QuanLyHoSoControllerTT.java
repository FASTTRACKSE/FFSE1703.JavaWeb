package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuanLyHoSoServiceTT;

@Controller
@RequestMapping("/quanlyhoso/")
public class QuanLyHoSoControllerTT {
	@Autowired
	private QuanLyHoSoServiceTT quanLyHoSoServiceTT;

	public QuanLyHoSoServiceTT getQuanLyHoSoServiceTT() {
		return quanLyHoSoServiceTT;
	}

	public void setQuanLyHoSoServiceTT(QuanLyHoSoServiceTT quanLyHoSoServiceTT) {
		this.quanLyHoSoServiceTT = quanLyHoSoServiceTT;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHoSo(Model model) {
		model.addAttribute("listHoSo", quanLyHoSoServiceTT.getAllHoSo());
		return "QuanLyNhanSuTT/QuanLyHoSoTT/list";
	}
}
