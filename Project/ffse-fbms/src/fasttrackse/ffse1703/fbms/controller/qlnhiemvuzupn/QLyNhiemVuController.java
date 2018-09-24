package fasttrackse.ffse1703.fbms.controller.qlnhiemvuzupn;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuzupn.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuzupn.QLyNhiemVuEntityzupn;
import fasttrackse.ffse1703.fbms.service.qlynhiemvuzupn.QLyNhiemVuServicezupn;

@Controller
@RequestMapping("/zupn")
public class QLyNhiemVuController {
	@Autowired
	private QLyNhiemVuServicezupn qLyNhiemVuService;
	
	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public String viewOneChucDanh(@PathVariable("ID") int id, Model model) {
		model.addAttribute("nv", qLyNhiemVuService.findById(id));
		return "QuanLyNhiemVuzupn/viewOne";
	}
	
	@RequestMapping(value = {"/","/danhsach"})
	public String danhSach(Model model) {
		model.addAttribute("danhsach",qLyNhiemVuService.getAll());
		return "QuanLyNhiemVuzupn/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpServletRequest request, Model model) {		
		QLyNhiemVuEntityzupn entity = qLyNhiemVuService.findById(id);
		entity.setIsDelete(0);
		qLyNhiemVuService.delete(entity);
		return "redirect:/zupn/danhsach";
	}
	@RequestMapping(value = "/create")
	public String showForm(Model model) {
		model.addAttribute("add", new QLyNhiemVuEntity());
		model.addAttribute("trangthai", "Mới");
		model.addAttribute("congviec", qLyNhiemVuService.congViec());
		return "QuanLyNhiemVuzupn/create";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createNhiemVu(Model model, @ModelAttribute("add") @Valid QLyNhiemVuEntityzupn nv, HttpServletRequest request,
		 BindingResult bindingResult) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "create";
		};
		nv.setIsDelete(1);
		qLyNhiemVuService.add(nv);
		return "redirect:/zupn/danhsach";
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("edit", qLyNhiemVuService.findById(id));
		model.addAttribute("trangthai", qLyNhiemVuService.trangThai());
		model.addAttribute("congviec", qLyNhiemVuService.congViec());
		return "/QuanLyNhiemVuzupn/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("edit") @Valid QLyNhiemVuEntityzupn nv, HttpServletRequest request) throws IllegalStateException, IOException {
		nv.setIsDelete(1);
		qLyNhiemVuService.update(nv);
		return "redirect:/zupn/danhsach";
	}
}
