package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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

	public String getInfo(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return "redirect:/login";
		} else {
			UserAccount user = accountService.loadUserByUsername(auth.getName());
			HoSoNhanVien hoSo = user.getNhanVien();
			ChucDanh chucDanh = hoSo.getChucDanh();
			PhongBan phongBan = hoSo.getPhongBan();
			session.setAttribute("chucDanh", chucDanh.getMaChucDanh());
			session.setAttribute("phongBan", phongBan.getMaPhongBan());
		}
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia";
	}

	@RequestMapping(value = "/duyetdanhgia")
	public String redirectDuyetDanhGia(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return "redirect:/login";
		}
		if (session.getAttribute("pageTPDG") != null) {
			currentPage = (int) session.getAttribute("pageDDG");
		}
		return "redirect:/quantridanhgia/truongphong/danhgianhanvien/" + currentPage;
	}

	@RequestMapping(value = "/duyetdanhgia/{page}")
	public String getListDanhGiaBanThan(Model model, @PathVariable int page, HttpSession session) {
		String phongBan = session.getAttribute("phongBan").toString();
		int start = (page - 1) * maxItems;
		session.setAttribute("pageDDG", page);
		model.addAttribute("total",
				Math.ceil((double) service.getListDanhGiaBanThan(phongBan).size() / (double) maxItems));
		model.addAttribute("listNhanVien", service.getListDanhGiaBanThan(start, maxItems, phongBan));
		return "QuanTriDanhGia/truongphong/duyetdanhgia";
	}

	@RequestMapping(value = "/duyetdanhgia/duyet")
	public String acceptDanhGiaNhanVien(Model model, @ModelAttribute("command") DanhGiaBanThan danhGia) {
		service.updateNhanVienTuDanhGia(danhGia);
		return "redirect:/quantridanhgia/truongphong/duyetdanhgia";
	}

	@RequestMapping(value = "/duyetdanhgia/view/{id}")
	public String showDanhGiaNhanVien(Model model, @PathVariable int id) {
		model.addAttribute("danhGia", service.getNhanVienTuDanhGia(id));
		return "QuanTriDanhGia/truongphong/viewdanhgia";
	}

	@RequestMapping(value = "/danhgianhanvien")
	public String redirectDanhGiaNhanVien(Model model, HttpSession session) {
		if (session.getAttribute("pageTPDG") != null) {
			currentPage = (int) session.getAttribute("pageTPDG");
		}
		return "redirect:/quantridanhgia/truongphong/danhgianhanvien/" + currentPage;
	}

	@RequestMapping(value = "/danhgianhanvien/{page}")
	public String getListDanhGiaNhanVien(@PathVariable int page, Model model, HttpSession session) {
		PhongBan phongBan = (PhongBan) session.getAttribute("phongBan");
		LichDanhGia lich = service.getActiveLichDanhGia(phongBan.getMaPhongBan());
		KyDanhGia kyDanhGia = lich.getKyDanhGia();
		if (service.getListNhanVienPhongBan(phongBan.getMaPhongBan()).size() < 1) {
			createListDanhGiaNhanVien(kyDanhGia, phongBan);
			return "redirect:/quantridanhgia/truongphong/danhgianhanvien";
		} else {
			int start = (page - 1) * maxItems;
			session.setAttribute("pageTPDG", page);
			model.addAttribute("total", Math.ceil(
					(double) service.getListNhanVienPhongBan(phongBan.getMaPhongBan()).size() / (double) maxItems));
			model.addAttribute("listDanhGia",
					service.getListNhanVienPhongBan(start, maxItems, phongBan.getMaPhongBan()));
		}
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
		List<HoSoNhanVien> hoSo = service.getNhanVienPhongBan(phongBan.getMaPhongBan());
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
