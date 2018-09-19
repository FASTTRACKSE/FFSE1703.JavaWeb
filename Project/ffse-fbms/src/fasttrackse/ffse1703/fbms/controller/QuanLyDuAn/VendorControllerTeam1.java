package fasttrackse.ffse1703.fbms.controller.QuanLyDuAn;

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

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Database;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.VendorTeam1;
import fasttrackse.ffse1703.fbms.service.QuanLyDuAn.VendorServiceTeam1;



@Controller
@RequestMapping("/QuanLyDuAn/vendor")
public class VendorControllerTeam1 {
	@Autowired
	VendorServiceTeam1 vendorServiceTeam1;
	
	@RequestMapping(value = { "/list", "" })
	public String list(Model model) {
		model.addAttribute("list", vendorServiceTeam1.getAll());
		return "QuanLyDuAn/Vendor/list";

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("command", new VendorTeam1());
		return "QuanLyDuAn/Vendor/addVendor";
	}
	
	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("vendor") @Valid VendorTeam1 vendorTeam1, BindingResult result , RedirectAttributes redirectAttributes) {
		if(vendorServiceTeam1.getById(vendorTeam1.getMavd())!=null) {
			vendorServiceTeam1.setIsDelete(vendorTeam1.getMavd());
			vendorServiceTeam1.update(vendorTeam1);
			return "redirect:list";
			}	

		
		if (result.hasErrors()) {
			return "QuanLyDuAn/Vendor/addVendor";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");

		vendorServiceTeam1.addNew(vendorTeam1);
		return "redirect:list";
	}
	@RequestMapping(value = "/edit/{mavd}")
	public String edit(Model model, @PathVariable("mavd") String mavd) {
		model.addAttribute("vendor", vendorServiceTeam1.getById(mavd));
		return "QuanLyDuAn/Vendor/editVendor";

	}
	
	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("vendor") @Valid VendorTeam1 vendorTeam1, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Vendor/editVendor";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		vendorServiceTeam1.update(vendorTeam1);
		return "redirect:list";

	}
	@RequestMapping(value = { "/delete/{mavd}" })
	public String delete(Model model, @PathVariable("mavd") String mavd) {
		vendorServiceTeam1.delete(mavd);
		return "redirect:/QuanLyDuAn/vendor";

	}
	
}
