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
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HopDongPikalong;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HoSoNhanVienPikalongService;
import fasttrackse.ffse1703.fbms.service.quantrinhansupikalong.HopDongPikalongSevice;

@Controller
@RequestMapping("/QuanTriNhanSu/quanlihopdong/")
public class HopDongPikalongController {
	@Autowired
	private HoSoNhanVienPikalongService hoSoNhanVienPikalongService;
	
	
	@Autowired
	private HopDongPikalongSevice hopDongPikalongService;

	@RequestMapping("/")
	public String listHopDong(Model model) {
		List<HopDongPikalong> listHopDong = hopDongPikalongService.listHopDong();
		System.out.println(listHopDong);
		model.addAttribute("listHopDong", listHopDong);
		return "QuanTriNhanSuPikalong/ThongTinHopDong/HopDong";
	}
	
	@RequestMapping(value= "view/{maNv}", method = RequestMethod.GET)
	public String viewThongTinHopDong(@PathVariable("maNv") String maNv, Model model) {
		HoSoNhanVienPikalong hsnv = this.hoSoNhanVienPikalongService.getEdit(maNv);
		model.addAttribute("hsnv", hsnv);
		HopDongPikalong hdById = this.hopDongPikalongService.getHopDongById(maNv);
		model.addAttribute("hopDong", hdById);
			return "QuanTriNhanSuPikalong/ThongTinHopDong/view/ViewThongTinHopDong";
	}
	
	@RequestMapping(value = "formaddhd/{maNv}" + "", method = RequestMethod.GET)
	public String addFormHd(@PathVariable String maNv, Model model) {
		String lastMaHd = this.hopDongPikalongService.getLastMaHd();
		System.out.println(lastMaHd);
		
		model.addAttribute("hsnv", hoSoNhanVienPikalongService.getEdit(maNv));
		model.addAttribute("hopDongPikalong", new HopDongPikalong());
		model.addAttribute("lastMaHd", lastMaHd);
		return "QuanTriNhanSuPikalong/ThongTinHopDong/FormAddHd"; 
	}
	
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String addSaveHd(@ModelAttribute("formHopDong") HopDongPikalong hd, Model model) {
		
		String maNv= hd.getHoSoNhanVienPikalong().getMaNv();
		HoSoNhanVienPikalong hsnv = this.hoSoNhanVienPikalongService.getEdit(maNv);
	
		hd.setMaHopDong(Integer.valueOf(this.hopDongPikalongService.getAutoId()));
		this.hopDongPikalongService.insert(hd);
		model.addAttribute("hoSoNhanVien", hsnv);
		return "redirect:/QuanTriNhanSu/quanlihopdong/";
	}
	
//	@RequestMapping(value = "formedithd", method = RequestMethod.GET)
//	public String editFormHd(Model model) {
//		
//	}
	
}

