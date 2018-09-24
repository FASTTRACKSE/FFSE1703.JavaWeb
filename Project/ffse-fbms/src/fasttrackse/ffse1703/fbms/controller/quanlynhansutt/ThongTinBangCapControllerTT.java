package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

	
}
