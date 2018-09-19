package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TaiLieuService;

@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/TaiLieu")
public class TaiLieuController {
	@Autowired
	private TaiLieuService serviceDM;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewTaiLieu(Model model) {
		return "TranDuc-QuanLyTaiLieu/TaiLieu/TaiLieuList";
	}
	
}
