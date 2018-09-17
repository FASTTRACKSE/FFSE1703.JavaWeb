package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.VendorService;

@Controller
@RequestMapping("/mvpquanliduan/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;
	
	public void setVendorService(VendorService vendorService) {
		this.vendorService = vendorService;
	}
	@RequestMapping(value="/list-vendor")
	public String listVendor(Model model) {
		List<Vendor> list = vendorService.findAll();
		model.addAttribute("listVendor", list);
		return "MvpQuanLiDuAn/vendor/listvendor";
	}
	@RequestMapping(value= "/show-form-add")
	public String showAdd(Model model) {
		model.addAttribute("command", new Vendor());
		return "MvpQuanLiDuAn/vendor/addvendor";
	}
	
}
