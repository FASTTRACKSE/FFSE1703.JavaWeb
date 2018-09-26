package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.NhanVienService;

@Controller
@RequestMapping("/quantridanhgia/nhanvien")
public class NhanVienController {

	NhanVienService nhanVienService;

	@Autowired
	@Qualifier(value = "nhanVienServiceImpl")
	public void setNhanVienService(NhanVienService nhanVienService) {
		this.nhanVienService = nhanVienService;
	}

	@RequestMapping(value = { "", "/danhgiabanthan" })
	public String getDanhGiaBanThan(Model model, Authentication auth, HttpSession session) {
		int nhanVien = (int) session.getAttribute("nhanVien");
		model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(nhanVien));
		return "QuanTriDanhGia/nhanviendanhgia/danhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/add")
	public String createDanhGiaBanThan(Model model) {
		model.addAttribute("command", new DanhGiaBanThan());
		return "QuanTriDanhGia/nhanviendanhgia/formdanhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/edit/{id}")
	public String editDanhGiaBanThan(Model model, @PathVariable int id) {
		model.addAttribute("command", nhanVienService.getDanhGiaBanThan(id));
		return "QuanTriDanhGia/nhanviendanhgia/formdanhgiabanthan";
	}

	@RequestMapping(value = "/danhgiabanthan/submit", method = RequestMethod.POST)
	public String submitDanhGiaBanThan(Model model, @ModelAttribute("command") DanhGiaBanThan danhGia) {
		if (danhGia.getId() == 0) {
			danhGia.setTrangThai(2);
			nhanVienService.insertDanhGiaBanThan(danhGia);
		} else {
			nhanVienService.updateDanhGiaBanThan(danhGia);
		}
		return "redirect:/quantridanhgia/nhanvien";
	}
	
	@RequestMapping(value = "/danhgiabanthan/draft", method = RequestMethod.POST)
	public String addDraftDanhGiaBanThan(Model model, @ModelAttribute("command") DanhGiaBanThan danhGia) {
		if (danhGia.getId() == 0) {
			danhGia.setTrangThai(1);
			nhanVienService.insertDanhGiaBanThan(danhGia);
		} else {
			nhanVienService.updateDanhGiaBanThan(danhGia);
		}
		return "redirect:/quantridanhgia/nhanvien";
	}

	@RequestMapping(value = { "/danhgianhanvien" })
	public String getListDanhGiaNhanVien(Model model, HttpSession session, Authentication auth) {
		int nhanVien = (int) session.getAttribute("nhanVien");
		List<DanhGiaNhanVien> list = nhanVienService.getListDanhGiaNhanVien(nhanVien);
		model.addAttribute("listDanhGiaNhanVien", list);
		return "QuanTriDanhGia/nhanviendanhgia/danhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/add/{id}")
	public String createDanhGiaNhanVien(Model model, @PathVariable int id) {
		model.addAttribute("nhanVien", nhanVienService.getDanhGiaBanThan(id));
		model.addAttribute("command", new DanhGiaNhanVien());
		return "QuanTriDanhGia/nhanviendanhgia/formdanhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/edit/{id}")
	public String editDanhGiaNhanVien(Model model, @PathVariable int id) {
		model.addAttribute("command", nhanVienService.getDanhGiaNhanVien(id));
		return "QuanTriDanhGia/nhanviendanhgia/formdanhgianhanvien";
	}

	@RequestMapping(value = "/danhgianhanvien/save", method = RequestMethod.POST)
	public String saveDanhGiaNhanVien(Model model, @ModelAttribute("command") DanhGiaNhanVien danhGia) {
		if (danhGia.getId() == 0) {
			nhanVienService.insertDanhGiaNhanVien(danhGia);
		} else {
			nhanVienService.updateDanhGiaNhanVien(danhGia);
		}
		return "redirect:/quantridanhgia/nhanvien/danhgianhanvien";
	}
}
