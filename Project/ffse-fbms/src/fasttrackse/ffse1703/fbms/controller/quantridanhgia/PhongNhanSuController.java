package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.PhongNhanSuService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/quantridanhgia/phongnhansu")
public class PhongNhanSuController {

	private int maxItems = 3;

	private int currentPageKy = 1;

	private int currentPageLich = 1;

	private int currentPageDanhGia = 1;

	private PhongBanService phongBanService;

	private PhongNhanSuService service;

	@Autowired
	public void setPhongBanService(PhongBanService phongBanService) {
		this.phongBanService = phongBanService;
	}

	@Autowired
	@Qualifier(value = "phongNhanSuServiceImpl")
	public void setService(PhongNhanSuService service) {
		this.service = service;
	}

	@RequestMapping("/kydanhgia")
	private String redirectListKyDanhgia(HttpSession session) {
		if (session.getAttribute("pageKy") != null) {
			currentPageKy = (int) session.getAttribute("pageKy");
		}
		return "redirect:/quantridanhgia/phongnhansu/kydanhgia/" + currentPageKy;
	}

	@RequestMapping("/kydanhgia/{page}")
	private String showListKyDanhgia(@PathVariable(required = false) int page, Model model, HttpSession session) {
		int start = (page - 1) * maxItems;
		model.addAttribute("command", new KyDanhGia());
		model.addAttribute("total", Math.ceil((double) service.getListKyDanhGia().size() / (double) maxItems));
		session.setAttribute("pagaKy", page);
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia(start, maxItems));
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
	private String redirectListLichDanhgia(HttpSession session) {
		if (session.getAttribute("pageLich") != null) {
			currentPageLich = (int) session.getAttribute("pageLich");
		}
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia/" + currentPageLich;
	}

	@RequestMapping("/lichdanhgia/{page}")
	private String showListLichDanhgia(Model model, @PathVariable(required = false) int page, HttpSession session) {
		int start = (page - 1) * maxItems;
		model.addAttribute("command", new DanhGiaNhanVien());
		session.setAttribute("pageLich", page);
		model.addAttribute("total", Math.ceil((double) service.getListLichDanhGia().size() / (double) maxItems));
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listLichDanhGia", service.getListLichDanhGia(start, maxItems));
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
		String phongBan = lich.getPhongBan();
		if (service.checkActiveLichDanhGia(phongBan) < 1) {
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
		String phongBan = lich.getPhongBan();
		if (service.countDanhGiaPhongBan(phongBan) == service.countNhanVienPhongBan(phongBan)) {
			lich.setIsActive(2);
			service.activeLichDanhGia(lich);
		}
		return "redirect:/quantridanhgia/phongnhansu/lichdanhgia";
	}

	@RequestMapping("/danhsachdanhgia")
	private String redirectListDanhgiaBanThan(HttpSession session) {
		if (session.getAttribute("pageKy") != null) {
			currentPageDanhGia = (int) session.getAttribute("pageDanhGia");
		}
		return "redirect:/quantridanhgia/phongnhansu/danhsachdanhgia/" + currentPageDanhGia;
	}

	@RequestMapping("/danhsachdanhgia/{page}")
	private String showListDanhgiaBanThan(Model model, @PathVariable(required = false) int page, HttpSession session) {
		int start = (page - 1) * maxItems;
		model.addAttribute("command", new LichDanhGia());
		session.setAttribute("pageDanhGia", page);
		model.addAttribute("total", Math.ceil((double) service.getListDanhGiaBanThan().size() / (double) maxItems));
		model.addAttribute("listKyDanhGia", service.getListKyDanhGia());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listDanhgia", service.getListDanhGiaBanThan(start, maxItems));
		return "QuanTriDanhGia/phongnhansu/danhsachdanhgia";
	}

}
