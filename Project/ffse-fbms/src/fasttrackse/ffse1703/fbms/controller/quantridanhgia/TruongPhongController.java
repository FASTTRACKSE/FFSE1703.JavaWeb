package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.TruongPhongService;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping("/quantridanhgia/truongphong")
public class TruongPhongController {

	public int currentPage = 1;

	public int maxItems = 10;

	@Autowired
	public TruongPhongService service;

	@Autowired
	public UserAccountService accountService;

	public void setService(TruongPhongService service) {
		this.service = service;
	}

	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	public void getInfo(HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserAccount user = accountService.loadUserByUsername(auth.getName());
		HoSoNhanVien hoSo = user.getNhanVien();
		ChucDanh chucDanh = hoSo.getChucDanh();
		PhongBan phongBan = hoSo.getPhongBan();
		session.setAttribute("chucDanh", chucDanh);
		session.setAttribute("nhanVien", hoSo);
		session.setAttribute("phongBan", phongBan);
	}

	@RequestMapping(value = { "","/" })
	public String redirectPage(Model model, HttpSession session) {
		getInfo(session);
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia";
	}

	@RequestMapping(value = "/duyetdanhgia")
	public String redirectDuyetDanhGia(Model model, HttpSession session) {
		getInfo(session);
		if (session.getAttribute("pageDDG") != null) {
			currentPage = (int) session.getAttribute("pageDDG");
		}
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia/" + currentPage;
	}

	@RequestMapping(value = "/duyetdanhgia/{page}")
	public String getListDanhGiaBanThan(Model model, @PathVariable int page, HttpSession session) {
		PhongBan phongBan = (PhongBan) session.getAttribute("phongBan");
		int start = (page - 1) * maxItems;
		model.addAttribute("start", start);
		session.setAttribute("pageDDG", page);
		model.addAttribute("total",
				Math.ceil((double) service.getListDanhGiaBanThan(phongBan).size() / (double) maxItems));
		model.addAttribute("listNhanVien", service.getListDanhGiaBanThan(start, maxItems, phongBan));
		return "QuanTriDanhGia/truongphong/duyetdanhgia";
	}

	@RequestMapping(value = "/duyetdanhgia/duyet/{id}")
	public String acceptDanhGiaNhanVien(Model model, @PathVariable int id) {
		DanhGiaBanThan danhGia = service.getNhanVienTuDanhGia(id);
		danhGia.getTrangThai().setMaTrangThai(3);
		service.updateNhanVienTuDanhGia(danhGia);
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia";
	}

	@RequestMapping(value = "/duyetdanhgia/huy/{id}")
	public String ignoreDanhGiaNhanVien(Model model, @PathVariable int id) {
		DanhGiaBanThan danhGia = service.getNhanVienTuDanhGia(id);
		danhGia.getTrangThai().setMaTrangThai(4);
		service.updateNhanVienTuDanhGia(danhGia);
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia";
	}

	@RequestMapping(value = "/duyetdanhgia/view/{id}")
	public String showDanhGiaNhanVien(Model model, @PathVariable int id) {
		model.addAttribute("command", service.getNhanVienTuDanhGia(id));
		return "QuanTriDanhGia/truongphong/viewdanhgia";
	}

	@RequestMapping(value = "/danhgianhanvien")
	public String redirectDanhGiaNhanVien(Model model, HttpSession session) {
		getInfo(session);
		if (session.getAttribute("pageTPDG") != null) {
			currentPage = (int) session.getAttribute("pageTPDG");
		}
		return "redirect:/quantridanhgia/truongphong/danhgianhanvien/" + currentPage;
	}

	@RequestMapping(value = "/danhgianhanvien/{page}")
	public String getListDanhGiaNhanVien(@PathVariable int page, Model model, HttpSession session) {
		PhongBan phongBan = (PhongBan) session.getAttribute("phongBan");
		List<LichDanhGia> lich = service.getActiveLichDanhGia(phongBan);
		if (lich.size() > 0) {
			for (LichDanhGia x : lich) {
				if (x.getIsActive() == 1) {
					KyDanhGia kyDanhGia = x.getKyDanhGia();
					if (service.getListNhanVienPhongBan(phongBan).size() < 1) {
						createListDanhGiaNhanVien(kyDanhGia, phongBan);
						return "redirect:/quantridanhgia/truongphong/danhgianhanvien";
					}
				}
			}
		}
		int start = (page - 1) * maxItems;
		session.setAttribute("pageTPDG", page);
		model.addAttribute("start", start);
		model.addAttribute("total",
				Math.ceil((double) service.getListNhanVienPhongBan(phongBan).size() / (double) maxItems));
		model.addAttribute("listDanhGia", service.getListNhanVienPhongBan(start, maxItems, phongBan));
		return "QuanTriDanhGia/truongphong/danhgianhanvien";
	}

	@RequestMapping(value = "/danhgianhanvien/danhgia/{id}")
	public String showFormDanhGiaNhanVien(Model model, @PathVariable int id) {
		model.addAttribute("command", service.getDanhGiaNhanVien(id));
		return "QuanTriDanhGia/truongphong/formdanhgianhanvien";
	}

	@RequestMapping(value = "/danhgianhanvien/update", method = RequestMethod.POST)
	public String updateDanhGiaNhanVien(Model model, @ModelAttribute("command") TruongPhongDanhGia danhGia) {
		service.updateDanhGiaNhanVien(danhGia);
		return "redirect:/quantridanhgia/truongphong/danhgianhanvien";
	}

	public void createListDanhGiaNhanVien(KyDanhGia kyDanhGia, PhongBan phongBan) {
		List<HoSoNhanVien> hoSo = service.getNhanVienPhongBan(phongBan);
		if (hoSo.size() > 0) {
			List<TruongPhongDanhGia> listDanhGia = new ArrayList<>();
			for (HoSoNhanVien x : hoSo) {
				TruongPhongDanhGia danhGia = new TruongPhongDanhGia();
				danhGia.setKyDanhGia(kyDanhGia);
				danhGia.setPhongBan(phongBan);
				danhGia.setNhanVien(x);
				listDanhGia.add(danhGia);
			}
			service.createListNhanVienPhongBan(listDanhGia);
		}
	}
}
