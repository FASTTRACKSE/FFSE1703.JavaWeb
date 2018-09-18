package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.DanhMucService;
@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/DanhMuc")
public class DanhMucController {
	@Autowired
	private DanhMucService serviceDM;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewDanhMuc(Model model) {
		return "TranDuc-QuanLyTaiLieu/DanhMuc/DanhMucList";
	}
	
}
