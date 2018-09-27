package fasttrackse.ffse1703.fbms.controller.qlvn1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
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
		model.addAttribute("nhanVien", nhanVien);
		TinhTrangNghi tinhTrang = service.getTinhTrang(nhanVien.getMaNhanVien());
		model.addAttribute("tinhTrang", tinhTrang);
		List<LyDo> arrLyDo = new ArrayList<LyDo>();
		arrLyDo = service.listLyDo();
		model.addAttribute("arrLyDo", arrLyDo);
		return "QuanLyVangNghi/donxinnghi";
	}

	@RequestMapping(value = "/danhsach", method = RequestMethod.GET)
	public String viewDanhSach(Model model) {
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDonNghi();
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/danhsach";
	}

	@RequestMapping(value = "/daduyet", method = RequestMethod.GET)
	public String viewDaDuyet(Model model) {
		return "QuanLyVangNghi/daduyet";
	}

	@RequestMapping(value = "/savenhap", method = RequestMethod.POST)
	public String saveNhapPost(Model model, @ModelAttribute("donNghi") DonNghi dn,@RequestParam int ngay_da_nghi,@RequestParam int ngay_con_lai) {
		dn.setTinh_trang("lưu nháp");
		dn.getTg_bat_dau();
	//	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd")
		TinhTrangNghi tt = new TinhTrangNghi();
		tt.setId_nv(dn.getId_nv());
		service.addDon(dn);
		int days = (int) ((dn.getTg_ket_thuc().getTime() - dn.getTg_bat_dau().getTime()) / (1000 * 60 * 60 * 24));
		if(ngay_da_nghi==0) {
			tt.setNgay_da_nghi(days);
			tt.setNgay_con_lai((ngay_con_lai-days));
		}else {
			tt.setNgay_da_nghi((ngay_da_nghi+days));
			tt.setNgay_con_lai((ngay_con_lai-days));
		}
		service.insertUpdateTinhTrang(dn.getId_nv(), tt);
		return "QuanLyVangNghi/luunhap";
	}

	@RequestMapping(value = "/luunhap")
	public String viewLuuNhap(Model model) {

		return "QuanLyVangNghi/luunhap";
	}

	@RequestMapping(value = "/choduyet", method = RequestMethod.GET)
	public String viewChoDuyet(Model model) {
		return "QuanLyVangNghi/choduyet";
	}

}