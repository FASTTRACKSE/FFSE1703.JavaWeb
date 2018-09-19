package fasttrackse.ffse1703.fbms.controller.quantrinhansupikalong;

import java.io.IOException;

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

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.BangCapPikalong;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.BangCapPikalongService;

@Controller
@RequestMapping(value = "/QuanTriNhanSuPikalong/QuanLiBangCap")
public class BangCapPikalongController {
	// Trang index
	public int currentPage = 1;
	// Số sinh viên trên 1 trang
	public int soBanGhi = 4;

	@RequestMapping("/listBangCapPikalong")
	public String redirect(HttpSession session) {
		if (session.getAttribute("page") != null) {
			currentPage = (int) session.getAttribute("page");
		}
		return "redirect:/QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong/" + currentPage;
	}
	
	@Autowired
	private BangCapPikalongService bangCapPikalongService;


	public void setBangCapPikalongService(BangCapPikalongService bangCapPikalongService) {
		this.bangCapPikalongService = bangCapPikalongService;
	}

	@RequestMapping(value = "/listBangCapPikalong/{pageid}", method = RequestMethod.GET)
	public String listBangCapPikalong(Model model, HttpSession session, @PathVariable int pageid) {
		int tongTrang = (int) Math.ceil((long) bangCapPikalongService.total() / (double) soBanGhi);

		int start = (int) ((pageid - 1) * soBanGhi);
		model.addAttribute("total", tongTrang);
		//model.addAttribute("page", pageid);
		session.setAttribute("page", pageid);
		model.addAttribute("listBangCap", this.bangCapPikalongService.listBangCapPikalong(start, soBanGhi));
		return "QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong";
	}

	@RequestMapping(value = "/addBangCap/{maNV}", method = RequestMethod.GET)
	public String showFormAdd(Model model, HttpSession session, @PathVariable String maNV) {
		// model.addAttribute("listNhanVien",
		// hoSoNhanVienPikalongService.listNhanVien());
		//
		BangCapPikalong hsnv = new BangCapPikalong();
		hsnv.setMaNV(maNV);
		model.addAttribute("command", hsnv);
		return "QuanTriNhanSuPikalong/QuanLiBangCap/formAddBangCapPikalong";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBangCap(@ModelAttribute("command") @Valid BangCapPikalong p, BindingResult result) {

		if (p.getId() == 0) {
			// new person, add it
			if (result.hasErrors()) {
				return "QuanTriNhanSuPikalong/QuanLiBangCap/formAddBangCapPikalong";
			}
			bangCapPikalongService.addBangCapPikalong(p);
		} else {
			// existing person, call update
			if (result.hasErrors()) {
				return "QuanTriNhanSuPikalong/QuanLiBangCap/formUpdateBangCapPikalong";
			}
			bangCapPikalongService.updateBangCapPikalong(p);
		}
		return "redirect:/QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong";

	}

	@RequestMapping("/edit/{maNV}")
	public String showFormUpdate(@PathVariable("maNV") int id, Model model) throws IllegalStateException, IOException {
		model.addAttribute("command", bangCapPikalongService.getBangCapPikalongById(id));
		return "QuanTriNhanSuPikalong/QuanLiBangCap/formUpdateBangCapPikalong";
	}

	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id) {
		bangCapPikalongService.removeBangCapPikalong(id);
		return "redirect:/QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong";
	}
	@RequestMapping("/viewOneBangCap/{maNV}")
	public String viewOneBangCap( @PathVariable String maNV,Model model) {
		model.addAttribute("viewOne",this.bangCapPikalongService.viewOne(maNV));
		return "QuanTriNhanSuPikalong/QuanLiBangCap/viewOneBangCapPikalong";
	}
}
