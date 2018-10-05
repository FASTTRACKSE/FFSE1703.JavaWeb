package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.PhongNhanSuService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping("/quantridanhgia/phongnhansu")
public class PhongNhanSuController {

	private int start = 1;

	private int maxItems = 3;

	private int currentPage = 1;

	private PhongBanService phongBanService;

	private PhongNhanSuService service;

	public UserAccountService accountService;

	@Autowired
	@Qualifier(value = "userAccountServiceImpl")
	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	public void setPhongBanService(PhongBanService phongBanService) {
		this.phongBanService = phongBanService;
	}

	@Autowired
	@Qualifier(value = "phongNhanSuServiceImpl")
	public void setService(PhongNhanSuService service) {
		this.service = service;
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
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia")
	private String redirectListKyDanhgia(HttpSession session) {
		getInfo(session);
		if (session.getAttribute("pageKy") != null) {
			currentPage = (int) session.getAttribute("pageKy");
		}
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia/" + currentPage;
	}

	@RequestMapping("/kydanhgia/{page}")
	private String showListKyDanhgia(@PathVariable(required = false) int page, Model model, HttpSession session) {
		start = (page - 1) * maxItems;
		model.addAttribute("kyDanhGia", new KyDanhGia());
		model.addAttribute("total", Math.ceil((double) service.getListKyDanhGia().size() / (double) maxItems));
		session.setAttribute("pageKy", page);
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia(start, maxItems));
		return "QuanTriDanhGia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/edit/{maKy}")
	private String showEdit(Model model, @PathVariable String maKy) {
		model.addAttribute("command", service.getKyDanhGia(maKy));
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		return "QuanTriDanhGia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/save")
	private String insertKyDanhgia(Model model,@ModelAttribute("command") @Valid KyDanhGia kyDanhGia,
			HttpSession session, BindingResult result) {
		if (result.hasErrors()) {
			start = (int) session.getAttribute("pageKy");
			model.addAttribute("listKyDanhGia", service.getListKyDanhGia(start, maxItems));
			model.addAttribute("total", Math.ceil((double) service.getListKyDanhGia().size() / (double) maxItems));
			return "QuanTriDanhGia/phongnhansu/kydanhgia";
		}
		if (service.checkKyDanhGia(kyDanhGia.getMaKy()) < 1) {
			this.service.insertKyDanhGia(kyDanhGia);
		} else {
			this.service.updateKyDanhGia(kyDanhGia);
		}
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/kydanhgia/delete/{maKy}")
	private String deletegDanhgia(Model model, @PathVariable String maKy) {
		KyDanhGia kyDanhGia = service.getKyDanhGia(maKy);
		kyDanhGia.setIsDelete(1);
		service.deleteKyDanhGia(kyDanhGia);
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia";
	}

	@RequestMapping("/lichdanhgia")
	private String redirectListLichDanhgia(HttpSession session) {
		getInfo(session);
		if (session.getAttribute("pageLich") != null) {
			currentPage = (int) session.getAttribute("pageLich");
		}
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia/" + currentPage;
	}

	@RequestMapping("/lichdanhgia/{page}")
	private String showListLichDanhgia(Model model, @PathVariable(required = false) int page, HttpSession session) {
		start = (page - 1) * maxItems;
		model.addAttribute("command", new DanhGiaNhanVien());
		session.setAttribute("pageLich", page);
		model.addAttribute("total", Math.ceil((double) service.getListLichDanhGia().size() / (double) maxItems));
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listLichDanhGia", service.getListLichDanhGia(start, maxItems));
		return "QuanTriDanhGia/phongnhansu/lichdanhgia";
	}

	@RequestMapping("/lichdanhgia/create")
	private String createLichDanhgia(@ModelAttribute("command") @Valid LichDanhGia lichDanhGia, BindingResult result,
			Model model, HttpSession session) {
		if (result.hasErrors()) {
			start = (int) session.getAttribute("pageLich");
			model.addAttribute("total", Math.ceil((double) service.getListLichDanhGia().size() / (double) maxItems));
			model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
			model.addAttribute("listPhongBan", phongBanService.findAll());
			model.addAttribute("listLichDanhGia", service.getListLichDanhGia(start, maxItems));
			return "QuanTriDanhGia/phongnhansu/lichdanhgia";
		}
		if (service.checkLichDanhGia(lichDanhGia) < 1) {
			service.insertLichDanhGia(lichDanhGia);
		}
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia";
	}

	@RequestMapping("/lichdanhgia/start/{id}")
	private String activeLichDanhgia(RedirectAttributes model, @PathVariable int id) {
		LichDanhGia lich = service.getLichDanhGia(id);
		PhongBan phongBan = lich.getPhongBan();
		if (service.checkActiveLichDanhGia(phongBan.getMaPhongBan()) < 1) {
			lich.setIsActive(1);
			service.activeLichDanhGia(lich);
		} else {
			model.addFlashAttribute("message", "<script>alert('Đã có hoạt động đánh giá tồn tại')</script>");
		}
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia";
	}

	@RequestMapping("/lichdanhgia/end/{id}")
	private String deactiveLichDanhgia(Model model, @PathVariable int id) {
		LichDanhGia lich = service.getLichDanhGia(id);
		PhongBan phongBan = lich.getPhongBan();
		if (service.countDanhGiaPhongBan(phongBan.getMaPhongBan()) == service
				.countNhanVienPhongBan(phongBan.getMaPhongBan())) {
			lich.setIsActive(2);
			service.activeLichDanhGia(lich);
		}
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia";
	}

	@RequestMapping("/danhsachdanhgia")
	private String redirectListDanhgiaBanThan(HttpSession session) {
		getInfo(session);
		if (session.getAttribute("pageKy") != null) {
			currentPage = (int) session.getAttribute("pageDanhGia");
		}
		return "redirect:/quantridanhgia/phongnhansu/danhsachdanhgia/" + currentPage;
	}

	@RequestMapping("/danhsachdanhgia/{page}")
	private String showListDanhgiaBanThan(Model model, @PathVariable(required = false) int page, HttpSession session) {
		start = (page - 1) * maxItems;
		model.addAttribute("command", new LichDanhGia());
		session.setAttribute("pageDanhGia", page);
		model.addAttribute("total", Math.ceil((double) service.getListDanhGiaBanThan().size() / (double) maxItems));
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listDanhgia", service.getListDanhGiaBanThan(start, maxItems));
		return "QuanTriDanhGia/phongnhansu/danhsachdanhgia";
	}

}
