package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;

import fasttrackse.ffse1703.fbms.service.mvpquanliduan.KhachHangService;


@Controller
@RequestMapping("/mvpquanliduan/khachhang")
public class KhachHangController {
	@Autowired
	private KhachHangService khachHangService;

	public void setKhachHangService(KhachHangService khachHangService) {
		this.khachHangService = khachHangService;
	}
	@RequestMapping(value="/list-khachhang")
	public String  listKhachHang(Model model) {
		List<KhachHang> list= khachHangService.getAll() ;
		model.addAttribute("listKhachHang", list);
		return "MvpQuanLiDuAn/khachhang/listkhachhang";
	}
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new KhachHang());
		return "MvpQuanLiDuAn/khachhang/addkhachhang";
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") KhachHang khachHang, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/khachhang/addkhachhang";
		}
		int check= khachHangService.checkKhachHang(khachHang.getFullname());
		if(check >=1) {
			model.addAttribute("message", "Kĩ thuật đã tồn tại");
			return "MvpQuanLiDuAn/khachhang/addkhachhang";
		}
		khachHang.setStatus(1);
		khachHangService.add(khachHang);;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Th�m th�nh c�ng');</script>");
		return "redirect: list-khachhang";
	}
	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable int id) {
		KhachHang khachHang = khachHangService.getById(id);
		model.addAttribute("technical", khachHang);
		return "MvpQuanLiDuAn/khachhang/updatekhachhang";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("KhachHang") KhachHang khachHang, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/khachhang/updatekhachhang";
		}
		khachHang.setStatus(1);
		khachHangService.update(khachHang);
		return "redirect: list-khachhang";
	}
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		 KhachHang khachHang =  khachHangService.getById(id);
		 khachHang.setStatus(0);
		 khachHangService.update(khachHang);
		return "redirect: /ffse-fbms/mvpquanliduan/khachhang/list-khachhang";
	}
}
