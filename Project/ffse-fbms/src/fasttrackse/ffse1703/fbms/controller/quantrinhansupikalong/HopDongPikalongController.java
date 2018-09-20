package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HopDongPikalong;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HopDongPikalongSevice;

@Controller
@RequestMapping("/QuanTriNhanSu/quanlihopdong/")
public class HopDongPikalongController {
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	
	
	
	@Autowired
	private HopDongPikalongSevice hopDongPikalongService;

	@RequestMapping("/")
	public String listHopDong(Model model) {
		List<HopDongPikalong> listHopDong = hopDongPikalongService.listHopDong();
		System.out.println(listHopDong);
		model.addAttribute("listHopDong", listHopDong);
		return "QuanTriNhanSuPikalong/ThongTinHopDong/HopDong";
	}
	
	@RequestMapping(value = "formaddhd", method = RequestMethod.GET)
	public String addHd(Model model) {
		model.addAttribute("formHopDong", new HopDongPikalong());
		model.addAttribute("listNhanVien", hoSoNhanVienPikalongService.listNhanVien());
		
		return "QuanTriNhanSuPikalong/ThongTinHopDong/FormAddHd"; 
	}
	
	
}

