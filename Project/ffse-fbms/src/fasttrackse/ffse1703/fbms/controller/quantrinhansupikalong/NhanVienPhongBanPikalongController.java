package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;

@Controller
@RequestMapping("/quantrinhansu/nhanvienphongban/")
public class NhanVienPhongBanPikalongController {
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	
	@RequestMapping("{phongBan}")
	public String listNhanVienPhongBan(@PathVariable String phongBan, Model model) {
		model.addAttribute("listNhanVienByPhongBan", hoSoNhanVienPikalongService.listNhanVienByPhongBan(phongBan));
		
		return "QuanTriNhanSuPikalong/ThongTinHoSo/listnhanvienphongban";
	}
}
