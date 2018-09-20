package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;


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
		model.addAttribute("command", new DanhGiaNhanVien());
		return "QuanTriDanhGia/nhanvien/danhgianhanvien";
	}
	@RequestMapping("/danhgianhanvien/showform")
	private String showFormDanhGiaNhanVien(Model model) {
		model.addAttribute("command", new DanhGiaNhanVien());
		return "QuanTriDanhGia/nhanvien/formdanhgianhanvien";
	}
	@RequestMapping("/danhgiacuatruongphong")
	private String showDanhGiaTruongPhong(Model model) {
		model.addAttribute("command", new TruongPhongDanhGia());
		return "QuanTriDanhGia/nhanvien/danhgiacuatruongphong";
	}
	@RequestMapping("/truongphongdanhgia/home")
	private String showListDanhGia(Model model) {
		return "QuanTriDanhGia/truongphong/danhgianhanvien";
	}
	@RequestMapping("/truongphongdanhgia/danhgia")
	private String showFormDanhGia(Model model) {
		model.addAttribute("command", new TruongPhongDanhGia());
		return "QuanTriDanhGia/truongphong/formdanhgianhanvien";
	}
}
