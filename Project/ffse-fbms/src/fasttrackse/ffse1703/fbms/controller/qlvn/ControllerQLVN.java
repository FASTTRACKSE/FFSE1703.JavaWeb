package fasttrackse.ffse1703.fbms.controller.qlvn;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThai;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.service.qlvn.QuanLyVangNghiService;

@Controller
@RequestMapping("/Quanlyvangnghi1703004")
public class ControllerQLVN {

	@Autowired
	private QuanLyVangNghiService service;

	public void setService(QuanLyVangNghiService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value = {"/danhsachcho" }, method = RequestMethod.GET)
	public String danhSachChoDuyet(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = service.danhSachXinNghiChoDuyet().size();
		int recordsPerPage = 2;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachcho", service.findAllForPagingCD(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		
		return "Quanlyvangnghi1703004/danhsachcho";
	}
	
	@RequestMapping(value = {"/danhsachduyet" }, method = RequestMethod.GET)
	public String danhSachDuyet(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = service.danhSachXinNghiDuyet().size();
		int recordsPerPage = 2;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachduyet", service.findAllForPagingD(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "Quanlyvangnghi1703004/danhsachduyet";
	}
	
	@RequestMapping(value = {"/danhsachnhap" }, method = RequestMethod.GET)
	public String danhSachNhap(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = service.danhSachXinNghiNhap().size();
		int recordsPerPage = 2;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachnhap", service.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "Quanlyvangnghi1703004/danhsachnhap";
	}
	
	@RequestMapping(value = {"/danhsachbituchoi" }, method = RequestMethod.GET)
	public String danhSachTuChoi(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = service.danhSachXinNghiTuChoi().size();
		int recordsPerPage = 2;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachtuchoi", service.findAllForPagingTC(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "Quanlyvangnghi1703004/danhsachbituchoi";
	}
	
	@RequestMapping(value = {"/danhsachngaynghi" }, method = RequestMethod.GET)
	public String danhSachNgayNghi(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = service.danhSachNgayNghi().size();
		int recordsPerPage = 2;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("danhsachngaynghi", service.findAllForPagingNN(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "Quanlyvangnghi1703004/danhsachngaynghi";
	}
	
	@RequestMapping(value = {"/deleteDate/${maNhanVien}"})
	public String deleteDateOff(@PathVariable int maNhanVien, HttpSession session, Model model) {
		service.delete(maNhanVien);
		return "Quanlyvangnghi1703004/danhsachngaynghi";
	}
	
	
	@RequestMapping(value = "/soandonmoi", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("taodonmoi", new ThongKeDonXinPhep());
		return "Quanlyvangnghi1703004/soandonmoi";
	}
	
	@RequestMapping(value = {"/taodonmoi/nhap"}, method = RequestMethod.POST)
	public String listDonNhap( @ModelAttribute("taodonmoi") @Valid ThongKeDonXinPhep nv,
			BindingResult result,Model model,final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "Quanlyvangnghi1703004/soandonmoi";
		} 
		service.create(nv);
		return "redirect:/Quanlyvangnghi1703004/danhsachnhap";
	}
	
	@RequestMapping(value = "/taodonmoi/choduyet", method = RequestMethod.POST)
	public String listDonChoDuyet(@Valid @ModelAttribute("taodonmoi")  ThongKeDonXinPhep nv,BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "Quanlyvangnghi1703004/soandonmoi";}
		service.createWait(nv);
		return "redirect:/Quanlyvangnghi1703004/danhsachcho";
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
	
	@RequestMapping(value = {"/delete/{id}","/taodonmoi/choduyet"})
	public String delete(@PathVariable int id, HttpSession session, Model model) {
		service.delete(id);
		return "redirect:/Quanlyvangnghi1703004/danhsachnhap";
	}
	
	@RequestMapping(value = {"/deleteBrowse/{id}"})
	public String deleteBrowse(@PathVariable int id, HttpSession session, Model model) {
		service.delete(id);
		return "redirect:/Quanlyvangnghi1703004/danhsachduyet";
	}
	
	@RequestMapping(value = "/suanhap/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("suadon", service.findById(id));
		service.delete(id);
		return "Quanlyvangnghi1703004/suanhap";
	}

	@RequestMapping(value = "/trove/nhap", method = RequestMethod.POST)
	public String editNhap( @ModelAttribute("suadon") @Valid ThongKeDonXinPhep nv,
			BindingResult result,Model model)
			throws SQLException {
		if(result.hasErrors()) {
			return "/Quanlyvangnghi1703004/suanhap";
		}
		service.create(nv);
		return "redirect:/Quanlyvangnghi1703004/danhsachnhap";
	}
	
	@RequestMapping(value = "/updatenhap/choduyet", method = RequestMethod.POST)
	public String editChoDuyet(  @ModelAttribute("suadon") @Valid ThongKeDonXinPhep nv,Model model,
			BindingResult result)
			throws SQLException {
		if(result.hasErrors()) {
			return "/Quanlyvangnghi1703004/suanhap";
		}
		service.updateNhap(nv);
		return "redirect:/Quanlyvangnghi1703004/danhsachcho";
	}
	
	@RequestMapping(value = "/suachoduyet/{id}", method = RequestMethod.GET)
	public String edit_wait(@PathVariable("id") int id, Model model) {
		model.addAttribute("suachoduyet", service.findById(id));
		service.delete(id);
		return "Quanlyvangnghi1703004/suachoduyet";
	}
	
	@RequestMapping(value = "/updateduyet/duyet", method = RequestMethod.POST)
	public String listDonDuyet( @ModelAttribute("suachoduyet") @Valid ThongKeDonXinPhep nv,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "/Quanlyvangnghi1703004/suachoduyet";
		} 
		service.createBrowse(nv);
		return "redirect:/Quanlyvangnghi1703004/danhsachduyet";
	}
	
	@RequestMapping(value = "/updatenhap/tuchoi", method = RequestMethod.POST)
	public String listDonTuChoi( @ModelAttribute("suachoduyet") @Valid ThongKeDonXinPhep nv,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "/Quanlyvangnghi1703004/suachoduyet";
		}
		service.createfeedback(nv);
		return "redirect:/Quanlyvangnghi1703004/danhsachbituchoi";
	}
}
