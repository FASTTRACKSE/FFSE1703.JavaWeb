package fasttrackse.ffse1703.fbms.controller.qlvn1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.service.qlvn.QuanLyVangNghiService;

@Controller
@RequestMapping("/QuanLyVangNghi/")
public class DonXinNghiCotroller {
	@Autowired
	private QuanLyVangNghiService service;

	public void setService(QuanLyVangNghiService service) {
		this.service = service;
	}

	@RequestMapping(value = "/donxinnghi", method = RequestMethod.GET)
	public String viewChucDanh(Model model) {
		return "QuanLyVangNghi/donxinnghi";
	}

	@RequestMapping(value = "/danhsach", method = RequestMethod.GET)
	public String viewDanhSach(Model model) {
		return "QuanLyVangNghi/danhsach";
	}

	@RequestMapping(value = "/daduyet", method = RequestMethod.GET)
	public String viewDaDuyet(Model model) {
		return "QuanLyVangNghi/daduyet";
	}

	@RequestMapping(value = "/luunhap", method = RequestMethod.GET)
	public String viewLuuNhap(Model model) {
		return "QuanLyVangNghi/luunhap";
	}

	@RequestMapping(value = "/choduyet", method = RequestMethod.GET)
	public String viewChoDuyet(Model model) {
		return "QuanLyVangNghi/choduyet";
	}
//
//	@RequestMapping(value = "danhsach")
//	public String listDon(Model model) {
//		model.addAttribute("donnghi", new QuanLyVangNghiEntity());
//		return "QuanLyVangNghi/danhsach";
//	}
//
//	@RequestMapping(value = "donnghi/addDon", method = RequestMethod.POST)
//	public String addDon(@ModelAttribute("donnghi") QuanLyVangNghiEntity dn) {
//		return "redirect:/danhsach";
//
//	}
}