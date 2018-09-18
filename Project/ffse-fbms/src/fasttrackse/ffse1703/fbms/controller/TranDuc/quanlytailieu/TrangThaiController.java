package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/TrangThai")
public class TrangThaiController {
//	@Autowired
//	private DanhMucService serviceDM;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewTaiLieu(Model model) {
		return "TranDuc-QuanLyTaiLieu/TrangThai/TrangThaiList";
	}
	
}
