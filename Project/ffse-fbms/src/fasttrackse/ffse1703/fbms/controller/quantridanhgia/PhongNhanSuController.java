package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.PhanCongDanhGia;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.PhongNhanSuService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/quantridanhgia/phongnhansu")
public class PhongNhanSuController {

	@Autowired
	private PhongBanService phongBanService;

	@Autowired
	private PhongNhanSuService nhanSuService;

	@RequestMapping("/kydanhgia")
	private String showListKyDanhgia(Model model) {
		model.addAttribute("command", new KyDanhGia());
		model.addAttribute("listKyDanhGia", nhanSuService.getListKyDanhGia());
		return "QuanTriDanhGia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/edit/{maKy}")
	private String showEdit(Model model, @PathVariable int maKy) {
		model.addAttribute("command", nhanSuService.getKyDanhGia(maKy));
		model.addAttribute("listKyDanhGia", nhanSuService.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		return "QuanTriDanhGia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/save")
	private String insertDanhgia(Model model, @ModelAttribute("command") KyDanhGia kyDanhGia) {
		if (kyDanhGia.getMaKy() == 0) {
			this.nhanSuService.insertKyDanhGia(kyDanhGia);
		} else {
			this.nhanSuService.updateKyDanhGia(kyDanhGia);
			;
		}
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/delete/{maKy}")
	private String deletegDanhgia(Model model) {
		model.addAttribute("command", new KyDanhGia());
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/phancongdanhgia")
	private String showListPhanCongDanhgia(Model model) {
		model.addAttribute("command", new PhanCongDanhGia());
		model.addAttribute("listKyDanhGia", nhanSuService.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		return "QuanTriDanhGia/phongnhansu/phancongdanhgia";
	}

	@SuppressWarnings("unused")
	@RequestMapping("/phancongdanhgia/create")
	private String createPhanCongDanhgia(@ModelAttribute("command") PhanCongDanhGia phanCong) {
		String kyDanhGia = phanCong.getKyDanhGia();
		String phongBan = phanCong.getPhongBan();
		List<Integer> listNhanVien = nhanSuService.getNhanVienPhongBan(phongBan);
		List<PhanCongDanhGia> listPhanCong = new ArrayList<>();
		return "QuanTriDanhGia/phongnhansu/phancongdanhgia";
	}

}
