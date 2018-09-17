package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import fasttrackse.ffse1703.fbms.service.quanlynhansutt.HopDongServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.LoaiHopDongServiceTT;

@Controller
@RequestMapping("/quanlynhansutt/")
public class QuanLyHopDongControllerTT {
	
	@Autowired
    private LoaiHopDongServiceTT loaiHopDongServiceTT;
    @Autowired
	private HopDongServiceTT hopDongServiceTT;
	
	
	public LoaiHopDongServiceTT getLoaiHopDongServiceTT() {
		return loaiHopDongServiceTT;
	}


	public void setLoaiHopDongServiceTT(LoaiHopDongServiceTT loaiHopDongServiceTT) {
		this.loaiHopDongServiceTT = loaiHopDongServiceTT;
	}


	public HopDongServiceTT getHopDongServiceTT() {
		return hopDongServiceTT;
	}


	public void setHopDongServiceTT(HopDongServiceTT hopDongServiceTT) {
		this.hopDongServiceTT = hopDongServiceTT;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHopDong(Model model) {
		model.addAttribute("listHopDong", hopDongServiceTT.getAllHopDong());
		return "QuanLyNhanSuTT/QuanLyHopDongTT/HopDong";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
//		model.addAttribute("hopDongTT", new HopDongTT());
		return "QuanLyNhanSuTT/QuanLyHopDongTT/add_form";
	}

	
}
