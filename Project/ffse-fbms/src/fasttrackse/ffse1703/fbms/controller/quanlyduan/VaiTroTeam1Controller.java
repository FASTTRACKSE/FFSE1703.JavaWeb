package fasttrackse.ffse1703.fbms.controller.quanlyduan;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.VaiTroThanhVienTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.VaiTroTeam1Service;

@Controller
@RequestMapping("QuanLyDuAn/VaiTro")
public class VaiTroTeam1Controller {
@Autowired
VaiTroTeam1Service vaiTroService;

@RequestMapping(value = { "/list", "" })
public String list(Model model) {
	model.addAttribute("list", vaiTroService.getAll());
	return "QuanLyDuAn/VaiTro/listVaiTro";

}

@RequestMapping(value = "/add", method = RequestMethod.GET)
public String addForm(Model model, final RedirectAttributes redirectAttributes) {
	model.addAttribute("vaitro", new VaiTroThanhVienTeam1());
	return "QuanLyDuAn/VaiTro/addVaiTro";
}

@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
public String creat(@ModelAttribute("vaitro") @Valid VaiTroThanhVienTeam1 vendorTeam1, BindingResult result , RedirectAttributes redirectAttributes) {
	if(vaiTroService.getById(vendorTeam1.getMavt())!=null) {
		vaiTroService.setIsDelete(vendorTeam1.getMavt());
		vaiTroService.update(vendorTeam1);
		return "redirect:list";
		}	

	
	if (result.hasErrors()) {
		return "QuanLyDuAn/VaiTro/addVaiTro";
	}
	redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");

	vaiTroService.addNew(vendorTeam1);
	return "redirect:list";
}

@RequestMapping(value = "/edit/{mavt}")
public String edit(Model model, @PathVariable("mavt") String mavt) {
	model.addAttribute("vaitro", vaiTroService.getById(mavt));
	return "QuanLyDuAn/VaiTro/editVaiTro";
}

@RequestMapping(value = "/update")
public String update(@ModelAttribute("vendor") @Valid VaiTroThanhVienTeam1 vendorTeam1, BindingResult result, RedirectAttributes redirectAttributes) {
	if (result.hasErrors()) {
		return "QuanLyDuAn/VaiTro/editVaiTro";
	}
	redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
	vaiTroService.update(vendorTeam1);
	return "redirect:list";

}

@RequestMapping(value = { "/delete/{mavt}" })
public String delete(Model model, @PathVariable("mavt") String mavt) {
	vaiTroService.delete(mavt);
	return "redirect:/QuanLyDuAn/VaiTro";

}
}
