package fasttrackse.ffse1703.fbms.controller.qlynhiemvuhieulp;

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


import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;
import fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp.QLyNhiemVuService;

@Controller
@RequestMapping("/HieuLP")
public class QLyNhiemVuController {
	@Autowired
	private QLyNhiemVuService qLyNhiemVuService;
	
	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public String viewOneChucDanh(@PathVariable("ID") int id, Model model) {
		model.addAttribute("nv", qLyNhiemVuService.findById(id));
		return "QuanLyNhiemVuHieuLP/viewOne";
	}
	@RequestMapping(value = {"/","/danhsach"})
	public String danhSach(Model model) {
		model.addAttribute("danhsach",qLyNhiemVuService.getAll());
		return "QuanLyNhiemVuHieuLP/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpServletRequest request, Model model) {		
		QLyNhiemVuEntity entity = qLyNhiemVuService.findById(id);
		entity.setIsDelete(0);
		qLyNhiemVuService.delete(entity);
		return "redirect:/HieuLP/danhsach";
	}
	@RequestMapping(value = "/create")
	public String showForm(Model model) {
		model.addAttribute("add", new QLyNhiemVuEntity());
		model.addAttribute("trangthai", "Mới");
		model.addAttribute("congviec", qLyNhiemVuService.congViec());
		model.addAttribute("duan", qLyNhiemVuService.duAn());
		return "QuanLyNhiemVuHieuLP/create";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createNhiemVu(Model model, @ModelAttribute("add") @Valid QLyNhiemVuEntity nv, HttpServletRequest request,
		 BindingResult bindingResult) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "create";
		};
		nv.setIsDelete(1);
		qLyNhiemVuService.add(nv);
		return "redirect:/HieuLP/danhsach";
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("edit", qLyNhiemVuService.findById(id));
		model.addAttribute("trangthai", qLyNhiemVuService.trangThai());
		model.addAttribute("congviec", qLyNhiemVuService.congViec());
		model.addAttribute("duan", qLyNhiemVuService.duAn());
		return "/QuanLyNhiemVuHieuLP/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("edit") @Valid QLyNhiemVuEntity nv, HttpServletRequest request) throws IllegalStateException, IOException {
		nv.setIsDelete(1);
		qLyNhiemVuService.update(nv);
		return "redirect:/HieuLP/danhsach";
	}
}
