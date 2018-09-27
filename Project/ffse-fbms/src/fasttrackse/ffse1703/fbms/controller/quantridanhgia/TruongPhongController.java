package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.quantridanhgia.TruongPhongService;

@Controller
@RequestMapping("/quantridanhgia/truongphong")
public class TruongPhongController {

	@Autowired
	TruongPhongService service;

	public void setService(TruongPhongService service) {
		this.service = service;
	}

	@RequestMapping(value = "")
	public String getListDanhGiaNhanVien(Model model) {
		return "QuanTriDanhGia/truongphong/danhgianhanvien";
	}
}
