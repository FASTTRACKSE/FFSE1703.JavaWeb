package fasttrackse.ffse1703.fbms.controller.qlvn;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThai;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.service.qlvn.QuanLyVangNghiService;

@Controller
public class ControllerQLVN {

	@Autowired
	private QuanLyVangNghiService service;

	public void setService(QuanLyVangNghiService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value = {"/danhsachcho" }, method = RequestMethod.GET)
	public String danhSachChoDuyet(Model model) {
		model.addAttribute("danhsachcho", this.service.danhSachXinNghiChoDuyet());
		return "Quanlyvangnghi1703004/danhsachcho";
	}
	
	@RequestMapping(value = {"/danhsachduyet" }, method = RequestMethod.GET)
	public String danhSachDuyet(Model model) {
		model.addAttribute("danhsachduyet", this.service.danhSachXinNghiDuyet());
		return "Quanlyvangnghi1703004/danhsachduyet";
	}
	
	@RequestMapping(value = {"/danhsachnhap" }, method = RequestMethod.GET)
	public String danhSachNhap(Model model) {
		model.addAttribute("danhsachnhap", this.service.danhSachXinNghiNhap());
		return "Quanlyvangnghi1703004/danhsachnhap";
	}
	
	
	@RequestMapping(value = {"/soandonmoi" }, method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("taodonmoi", new ThongKeDonXinPhep());
		
		return "Quanlyvangnghi1703004/soandonmoi";
	}
	
	@RequestMapping(value = "/taodonmoi/nhap", method = RequestMethod.POST)
	public String listDonNhap(Model model, @ModelAttribute("taodonmoi") @Valid ThongKeDonXinPhep nv,HttpSession session) {
		service.create(nv);
		return "redirect:/danhsachnhap";
	}
	
	@RequestMapping(value = "/taodonmoi/choduyet", method = RequestMethod.POST)
	public String listDonChoDuyet(Model model, @ModelAttribute("taodonmoi") @Valid ThongKeDonXinPhep nv,HttpSession session) {
		service.createWalk(nv);
		return "redirect:/danhsachcho";
	}
	
	
	@ModelAttribute("lydo")
	public List<LyDoXinNghi> danhSachLyDo() {
		return this.service.loadAllLyDo();
	}
	
	@ModelAttribute("trangthai")
	public List<TrangThai> danhSachTrangThai() {
		return this.service.loadAllTrangThai();
	}
	
	@ModelAttribute("hoso")
	public List<HoSoNhanVien> danhSachHoSoNhanVien() {
		return this.service.loadAllHoSo();
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		service.delete(id);
		return "redirect:/danhsachnhap";
	}
	
	@RequestMapping(value = "/suanhap/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("suanhap", service.findById(id));
		return "Quanlyvangnghi1703004/suanhap";
	}

	@RequestMapping(value = "/updatenhap/nhap", method = RequestMethod.POST)
	public String editNhap(Model model,  @ModelAttribute("suadon") @Valid ThongKeDonXinPhep nv)
			throws SQLException {
		service.updateNhap(nv);
		return "redirect:/danhsachnhap";
	}
	
	@RequestMapping(value = "/updatenhap/choduyet", method = RequestMethod.POST)
	public String editNapChoDuyet(Model model,  @ModelAttribute("suadon") @Valid ThongKeDonXinPhep nv)
			throws SQLException {
		service.updateNhap(nv);
		return "redirect:/danhsachcho";
	}
}
