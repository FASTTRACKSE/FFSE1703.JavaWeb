package fasttrackse.ffse1703.fbms.controller.qlvn1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/QuanLyVangNghi/")
public class QuanLyVangNghiController {
	
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
	@RequestMapping(value = "/saveluunhap")
	public String saveLuuNhap() {
		
		return "redirect:/danhsach";
	}
	
}
