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

	@Autowired
	private BangCapPikalongService bangCapPikalongService;

	public void setBangCapPikalongService(BangCapPikalongService bangCapPikalongService) {
		this.bangCapPikalongService = bangCapPikalongService;
	}

	@RequestMapping(value = "/listBangCapPikalong", method = RequestMethod.GET)
	public String listBangCapPikalong(Model model, HttpSession session) {
		// it tongTrang = (int) Math.ceil((long) studentService.total() / (double)
		// soBanGhi);
		// Ä�iá»ƒm báº¯t Ä‘áº§u láº¥y báº£n ghi trong database
		// int start = (int) ((pageid - 1) * soBanGhi);
		// model.addAttribute("total", tongTrang);
		// model.addAttribute("page", pageid);
		// session.setAttribute("page", pageid);
		model.addAttribute("listBangCap", this.bangCapPikalongService.listBangCapPikalong());
		return "QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong";
	}

	@RequestMapping(value = "/addBangCap", method = RequestMethod.GET)
	public String showFormAdd(Model model) {
		model.addAttribute("command", new BangCapPikalong());
		return "QuanTriNhanSuPikalong/QuanLiBangCap/formAddBangCapPikalong";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBangCap(@ModelAttribute("command")@Valid BangCapPikalong p,BindingResult result)	
	{

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
	@RequestMapping("/edit/{id}")
	public String showFormUpdate(@PathVariable("id") int id, Model model) throws IllegalStateException, IOException {
		model.addAttribute("BangCap", bangCapPikalongService.getBangCapPikalongById(id));
		return "QuanTriNhanSuPikalong/QuanLiBangCap/formUpdateBangCapPikalong";
	}
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id) {
		bangCapPikalongService.removeBangCapPikalong(id);
		return "redirect:/QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong";
	}
}
