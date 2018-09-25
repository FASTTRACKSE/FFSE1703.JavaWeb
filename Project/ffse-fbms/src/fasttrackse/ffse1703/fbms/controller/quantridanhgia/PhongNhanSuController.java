package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.PhanCongDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.PhongNhanSuService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/quantridanhgia/phongnhansu")
public class PhongNhanSuController {

	private PhongBanService phongBanService;

	private PhongNhanSuService service;

	@Autowired
	public void setPhongBanService(PhongBanService phongBanService) {
		this.phongBanService = phongBanService;
	}

	@Autowired
	@Qualifier(value ="phongNhanSuServiceImpl")
	public void setService(PhongNhanSuService service) {
		this.service = service;
	}

	@RequestMapping("/kydanhgia")
	private String showListKyDanhgia(Model model) {
		model.addAttribute("command", new KyDanhGia());
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		return "QuanTriDanhGia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/edit/{maKy}")
	private String showEdit(Model model, @PathVariable int maKy) {
		model.addAttribute("command", service.getKyDanhGia(maKy));
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		return "QuanTriDanhGia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/save")
	private String insertKyDanhgia(Model model, @ModelAttribute("command") KyDanhGia kyDanhGia) {
		if (kyDanhGia.getId() == 0) {
			this.service.insertKyDanhGia(kyDanhGia);
		} else {
			this.service.updateKyDanhGia(kyDanhGia);
			;
		}
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/delete/{maKy}")
	private String deletegDanhgia(Model model) {
		model.addAttribute("command", new KyDanhGia());
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/lichdanhgia")
	private String showListLichDanhgia(Model model) {
		model.addAttribute("command", new PhanCongDanhGia());
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listLichDanhGia", service.getListLichDanhGia());
		return "QuanTriDanhGia/phongnhansu/lichdanhgia";
	}

	@RequestMapping("/lichdanhgia/create")
	private String createLichDanhgia(@ModelAttribute("command") LichDanhGia lichDanhGia, RedirectAttributes model) {
		if (service.checkLichDanhGia(lichDanhGia) < 1) {
			service.insertLichDanhGia(lichDanhGia);
		}
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia";
	}

	@RequestMapping("/lichdanhgia/start/{id}")
	private String activeLichDanhgia(RedirectAttributes model, @PathVariable int id) {
		LichDanhGia lich = service.getLichDanhGia(id);
		lich.setIsActive(1);
		service.activeLichDanhGia(lich);
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia";
	}

	@RequestMapping("/lichdanhgia/end/{id}")
	private String deactiveLichDanhgia(Model model, @PathVariable int id) {
		LichDanhGia lich = service.getLichDanhGia(id);
		lich.setIsActive(2);
		service.activeLichDanhGia(lich);
		createPhanCongDanhgia(lich.getKyDanhGia(), lich.getPhongBan());
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia";
	}

	private void createPhanCongDanhgia(String kyDanhGia, String phongBan) {
		List<Integer> listNhanVien = service.getNhanVienPhongBan(phongBan);
		List<PhanCongDanhGia> listPhanCong = new ArrayList<>();
		for (int i = 0; i < listNhanVien.size(); i++) {
			int nhanvien = listNhanVien.get(i);
			for (int j = 1; j < 4; j++) {
				PhanCongDanhGia pc = new PhanCongDanhGia();
				pc.setKyDanhGia(kyDanhGia);
				pc.setPhongBan(phongBan);
				pc.setNhanVienDanhGia(nhanvien);
				if (i + j < listNhanVien.size()) {
					pc.setNhanVien(listNhanVien.get(i + j));
				} else {
					pc.setNhanVien(listNhanVien.get(i + j - listNhanVien.size()));
				}
				listPhanCong.add(pc);
			}
		}
		service.insertPhanCongDanhGia(listPhanCong);
	}

	@RequestMapping("/danhsachdanhgia")
	private String showListDanhgiaBanThan(Model model) {
		model.addAttribute("command", new LichDanhGia());
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listDanhgia", service.getListDanhGiaBanThan());
		return "QuanTriDanhGia/phongnhansu/danhsachdanhgia";
	}
	
	@RequestMapping("/danhsachdanhgia/search")
	private String showSearchDanhgiaBanThan(Model model, @ModelAttribute(name="command") LichDanhGia lich) {
		if (lich.getKyDanhGia() == "" && lich.getPhongBan() == "") {
			model.addAttribute("listDanhgia", service.getListDanhGiaBanThan());
		} else if (lich.getKyDanhGia() == "") {
			model.addAttribute("listDanhgia", service.getListDanhGiaBanThanByPhongBan(lich.getPhongBan()));
		} else if (lich.getPhongBan() == "") {
			model.addAttribute("listDanhgia", service.getListDanhGiaBanThanByKyDanhGia(lich.getKyDanhGia()));
		} else {
			model.addAttribute("listDanhgia", service.getListDanhGiaBanThan(lich.getKyDanhGia(), lich.getPhongBan()));
		}
		model.addAttribute("command", lich);
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		return "QuanTriDanhGia/phongnhansu/danhsachdanhgia";
	}
}
