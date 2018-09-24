package fasttrackse.ffse1703.fbms.controller.qlvn1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.qlvn1.QuanLyVangNghiService;

@Controller
@RequestMapping("/QuanLyVangNghi")
public class DonXinNghiCotroller {
	@Autowired
	private QuanLyVangNghiService service;
	
	
	public void setService(QuanLyVangNghiService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/donxinnghi", method = RequestMethod.GET)
	public String viewChucDanh(Model model, Authentication auth) {
		UserAccount user = service.getThongTinUser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		model.addAttribute("nhanVien", nhanVien );
		TinhTrangNghi tinhTrang = service.getTinhTrang(nhanVien.getMaNhanVien());
		model.addAttribute("tinhTrang", tinhTrang );
		List<LyDo> arrLyDo = new ArrayList<LyDo>();
		arrLyDo = service.listLyDo();
		model.addAttribute("arrLyDo", arrLyDo );
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

	@RequestMapping(value = "/savenhap", method = RequestMethod.GET)
	public String saveNhap(Model model, @ModelAttribute("donNghi") DonNghi dn,
			final RedirectAttributes redirectAttributes) {
		dn.setTinh_trang("lưu nháp");
		service.addDon(dn);
		return "QuanLyVangNghi/luunhap";
	}
	
	@RequestMapping(value = "/luunhap", method = RequestMethod.GET)
	public String viewLuuNhap(Model model) {
		return "QuanLyVangNghi/luunhap";
	}

	@RequestMapping(value = "/choduyet", method = RequestMethod.GET)
	public String viewChoDuyet(Model model) {
		return "QuanLyVangNghi/choduyet";
	}

}