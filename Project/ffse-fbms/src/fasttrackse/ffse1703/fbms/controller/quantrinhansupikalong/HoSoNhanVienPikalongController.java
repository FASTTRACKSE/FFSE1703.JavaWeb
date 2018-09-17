package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.QuocTichPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.ThanhPhoPikalongService;

@Controller
@RequestMapping("/quantrinhansu/hosonhanvien/")
public class HoSoNhanVienPikalongController {
	
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	
	@Autowired 
	private QuocTichPikalongService quocTichPikalongService;
	
	@Autowired
	private ThanhPhoPikalongService thanhPhoPikalongService;
	
	@RequestMapping("/")
	public String test(Model model) {
		List<HoSoNhanVienPikalong> nhanVienList = hoSoNhanVienPikalongService.listNhanVien();
		model.addAttribute("nhanVienList", nhanVienList);
		return "QuanTriNhanSuPikalong/ThongTinHoSo/index";
	}
	
	@RequestMapping("delete/{maNv}") // delete employee
	public String delete(@PathVariable int maNv) {
		hoSoNhanVienPikalongService.delete(maNv);
		return "redirect:/quantrinhansu/hosonhanvien/";
	}
	
	@RequestMapping(value= "addform", method= RequestMethod.GET)
	public String addform(Model model) {
		model.addAttribute("formHoSoNhanVien", new HoSoNhanVienPikalong());
		model.addAttribute("listQuocTich", quocTichPikalongService.listQuocTich());
		model.addAttribute("listThanhPho", thanhPhoPikalongService.listTinhThanh());
		return "QuanTriNhanSuPikalong/ThongTinHoSo/thongtinhosoaddform";
	}
}
