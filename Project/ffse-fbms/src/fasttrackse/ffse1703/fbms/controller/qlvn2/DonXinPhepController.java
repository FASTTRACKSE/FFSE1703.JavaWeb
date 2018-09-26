package fasttrackse.ffse1703.fbms.controller.qlvn2;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.service.qlvn2.DonXinPhepService;
@Controller
@RequestMapping(value ="/QuanlyvangnghiDanhLT")
public class DonXinPhepController {
	@Autowired
	DonXinPhepService DonXinPhepService;
	
	@RequestMapping(value = {"/danhsachnhap003"}, method = RequestMethod.GET)
	public String danhsachnhap003(Model model ) {
		model.addAttribute("danhsachnhap003", DonXinPhepService.danhsachnhap003());
		return "QuanlyvangnghiDanhLT/danhsachnhap003";
    }
	
	@RequestMapping(value = {"/danhsachchoduyet003"}, method = RequestMethod.GET)
	public String danhsachchoduyet003(Model model ) {
		model.addAttribute("danhsachchoduyet003", DonXinPhepService.danhsachchoduyet003());
		return "QuanlyvangnghiDanhLT/danhsachchoduyet003";
    }
	@RequestMapping(value = {"/danhsachdaduyet003"}, method = RequestMethod.GET)
	public String danhsachdaduyet003(Model model ) {
		model.addAttribute("danhsachdaduyet003", DonXinPhepService.danhsachdaduyet003());
		return "QuanlyvangnghiDanhLT/danhsachdaduyet003";
    }
	@RequestMapping(value = {"/danhsachbituchoi003"}, method = RequestMethod.GET)
	public String danhsachbituchoi003(Model model ) {
		model.addAttribute("danhsachbituchoi003", DonXinPhepService.danhsachbituchoi003());
		return "QuanlyvangnghiDanhLT/danhsachbituchoi003";
    }
	@RequestMapping(value = "/donxinphep003", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("donxinphep003", new DonXinPhepEntity());
		return "QuanlyvangnghiDanhLT/donxinphep003";
	}
	@RequestMapping(value = "/suadonduyet", method = RequestMethod.GET)
	public String edit(Model model) {
		model.addAttribute("suadonduyet", new DonXinPhepEntity());
		return "QuanlyvangnghiDanhLT/suadonduyet";
	}
	@ModelAttribute("lyDo")
	public List<LyDoEntity> danhSachLyDo() {
		return this.DonXinPhepService.danhSachLyDo();
	}
	
	@ModelAttribute("trangthai")
	public List<TrangThaiEntity> danhSachTrangThai() {
		return this.DonXinPhepService.danhSachTrangThai();
	}
	
	@ModelAttribute("hoso")
	public List<HoSoNhanVien> danhSachHoSoNhanVien() {
		return this.DonXinPhepService.danhSachHoSo();
	}
	
	@RequestMapping(value = {"/delete/{id}","/donxinphep003/nhap"})
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		DonXinPhepService.delete(id);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachnhap003";
	}
	
	@RequestMapping(value = {"/deleteBrowse/{id}"})
	public String deleteBrowse(@PathVariable int id, HttpSession session, Model model) {
		DonXinPhepService.delete(id);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachduyet003";
	}
	
	//đơn mới
	@RequestMapping(value = {"/donxinphep003/nhap"}, method = RequestMethod.POST)
	public String listDonNhap( @ModelAttribute("donxinphep003") @Valid DonXinPhepEntity nv,
			BindingResult result,Model model,final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanlyvangnghiDanhLT/donxinphep003";
		} 
		DonXinPhepService.create(nv);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachnhap003";
	}
	@RequestMapping(value = {"/donxinphep003/choduyet"}, method = RequestMethod.POST)
	public String listDoncho( @ModelAttribute("donxinphep003") @Valid DonXinPhepEntity nv,
			BindingResult result,Model model,final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanlyvangnghiDanhLT/donxinphep003";
		} 
		DonXinPhepService.createcho(nv);
		return "redirect:/QuanlyvangnghiDanhLT/danhsachchoduyet003";
	}
//	//sửa chờ
//	@RequestMapping(value = "/suadonduyet/{id}", method = RequestMethod.GET)
//	public String edit_walk(@PathVariable("id") int id, Model model) {
//		model.addAttribute("suadonduyet", DonXinPhepService.findById(id));
//		DonXinPhepService.delete(id);
//		return "QuanlyvangnghiDanhLT/suadonduyet";
//	}
//	@RequestMapping(value = "/updateduyet/duyet", method = RequestMethod.POST)
//	public String listDonDuyet( @ModelAttribute("suadonduyet") @Valid DonXinPhepEntity nv,
//			BindingResult result,Model model) {
//		if(result.hasErrors()) {
//			return "/QuanlyvangnghiDanhLT/suadonduyet";
//		} 
//		DonXinPhepService.createduyet(nv);
//		return "redirect:/QuanlyvangnghiDanhLT/danhsachdaduyet003";
//	}
}
