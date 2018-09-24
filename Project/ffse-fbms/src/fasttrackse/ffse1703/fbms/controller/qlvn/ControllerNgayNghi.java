package fasttrackse.ffse1703.fbms.controller.qlvn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fasttrackse.ffse1703.fbms.service.qlvn.QuanLyNgayNghiService;
import fasttrackse.ffse1703.fbms.service.qlvn.QuanLyVangNghiService;
import net.bytebuddy.asm.Advice.This;

@Controller
@RequestMapping("/Quanlyvangnghi1703004")
public class ControllerNgayNghi {

	@Autowired
	private QuanLyNgayNghiService service;
	@Autowired
	private QuanLyVangNghiService serviceVN;
	
	@RequestMapping(value = {"/danhsachngaynghi" }, method = RequestMethod.GET)
	public String danhSachChoDuyet(Model model) {
		
		model.addAttribute("danhsachngaynghi", this.serviceVN.danhSachXinNghiDuyet());
		return "Quanlyvangnghi1703004/danhsachngaynghi";
	}
}
