package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.KhachHangService;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {
	@Autowired
	KhachHangService khachHangService;

	@RequestMapping(value = { "/create" })
	public String index(ModelMap mm) {
		mm.put("khachHang", new KhachHang());
		return "MvpQuanLiDuAn/khachhang/add_form";
	}
	
}
