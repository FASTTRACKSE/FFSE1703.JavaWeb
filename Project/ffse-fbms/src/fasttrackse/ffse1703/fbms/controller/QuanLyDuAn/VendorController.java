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
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Vendor;
import fasttrackse.ffse1703.fbms.service.QuanLyDuAn.VendorService;



@Controller
@RequestMapping("/QuanLyDuAn/vendor")
public class VendorController {
	@Autowired
	VendorService vendorService;
	
	@RequestMapping(value = { "/list", "" })
	public String list(Model model) {
		model.addAttribute("list", vendorService.getAll());
		return "QuanLyDuAn/Vendor/list";

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("command", new Vendor());
		return "QuanLyDuAn/Vendor/addVendor";
	}
	
	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("vendor") @Valid Vendor vendor, BindingResult result , RedirectAttributes redirectAttributes) {
		if(vendorService.getById(vendor.getMavd())!=null) {
			vendorService.setIsDelete(vendor.getMavd());
			vendorService.update(vendor);
			return "redirect:list";
			}	

		
		if (result.hasErrors()) {
			return "QuanLyDuAn/Vendor/addVendor";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");

		vendorService.addNew(vendor);
		return "redirect:list";
	}
	@RequestMapping(value = "/edit/{mavd}")
	public String edit(Model model, @PathVariable("mavd") String mavd) {
		model.addAttribute("vendor", vendorService.getById(mavd));
		return "QuanLyDuAn/Vendor/editVendor";

	}
	
	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("vendor") @Valid Vendor vendor, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Vendor/editVendor";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		vendorService.update(vendor);
		return "redirect:list";

	}
	@RequestMapping(value = { "/delete/{mavd}" })
	public String delete(Model model, @PathVariable("mavd") String mavd) {
		vendorService.delete(mavd);
		return "redirect:/QuanLyDuAn/vendor";

	}
	
}
