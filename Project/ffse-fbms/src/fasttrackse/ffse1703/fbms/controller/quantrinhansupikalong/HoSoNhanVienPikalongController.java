package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.PhuongPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.QuanHuyenPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.QuocTichPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.ThanhPhoPikalongService;
import fasttrackse.ffse1703.fbms.service.security.ChucDanhService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/quantrinhansu/hosonhanvien/")
public class HoSoNhanVienPikalongController {
	
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	
	@Autowired 
	private QuocTichPikalongService quocTichPikalongService;
	
	@Autowired
	private ThanhPhoPikalongService thanhPhoPikalongService;
	
	@Autowired
	private QuanHuyenPikalongService quanHuyenPikalongService;
	
	@Autowired
	private PhuongPikalongService phuongPikalongService;
	
	@Autowired
	private ChucDanhService chucDanhService;
	
	@Autowired
	private PhongBanService phongBanService;
	
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
		model.addAttribute("formHosopkl", new HoSoNhanVienPikalong());
		model.addAttribute("listQuocTich", quocTichPikalongService.listQuocTich());
		model.addAttribute("listThanhPho", thanhPhoPikalongService.listTinhThanh());
		model.addAttribute("listQuanHuyen", quanHuyenPikalongService.listQuanHuyen());
		model.addAttribute("listPhuong", phuongPikalongService.listPhuong());
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listChucDanh", chucDanhService.findAll());
		return "QuanTriNhanSuPikalong/ThongTinHoSo/thongtinhosoaddform";
	}
	
	@RequestMapping(value= "insert", method= RequestMethod.POST)
	public String addsave(@ModelAttribute("formHosopkl") HoSoNhanVienPikalong hoSoNhanVien, BindingResult result) {
		hoSoNhanVienPikalongService.insert(hoSoNhanVien);
		return "redirect:/quantrinhansu/hosonhanvien/";
	}
	
	@RequestMapping(value= "test", method= RequestMethod.GET)
	public String test() {
		return "redirect:/quantrinhansu/hosonhanvien/";
	}
	
}
