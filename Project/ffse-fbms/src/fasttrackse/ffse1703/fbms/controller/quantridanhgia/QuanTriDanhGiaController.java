package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;


@Controller
@RequestMapping("/quantridanhgia")
public class QuanTriDanhGiaController {
	@RequestMapping("/home")
	private String showHome(Model model) {
		return "QuanTriDanhGia/nhanvien/home";
	}
	@RequestMapping("/danhgiabanthan")
	private String showDanhGiaBanThan(Model model) {
//		model.addAttribute("tudanhgia", "test");
		return "QuanTriDanhGia/nhanvien/danhgiabanthan";
	}
	@RequestMapping("/danhgiabanthan/showform")
	private String showFormDanhGiaBanThan(Model model) {
		model.addAttribute("command", new DanhGiaBanThan());
		return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
	}
	@RequestMapping("/danhgianhanvien")
	private String showListDanhGiaNhanVien(Model model) {
		model.addAttribute("command", new DanhGiaBanThan());
		return "QuanTriDanhGia/nhanvien/danhgianhanvien";
	}
	@RequestMapping("/danhgianhanvien/showform")
	private String showFormDanhGiaNhanVien(Model model) {
		model.addAttribute("command", new DanhGiaBanThan());
		return "QuanTriDanhGia/nhanvien/formdanhgianhanvien";
	}
}
