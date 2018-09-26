package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.quanlynhansutt.ThongTinGiaDinhServiceTT;

@Controller
@RequestMapping("/quanlynhansutt/gia_dinh/")
public class ThongTinGiaDinhControllerTT {
	
	@Autowired 
	private ThongTinGiaDinhServiceTT thongTinGiaDinhServiceTT;

	public void setThongTinGiaDinhServiceTT(ThongTinGiaDinhServiceTT thongTinGiaDinhServiceTT) {
		this.thongTinGiaDinhServiceTT = thongTinGiaDinhServiceTT;
	}

	
	// viewOneHopDong Nhân Viên
		@RequestMapping("/viewOneGiaDinh/{maNhanVien}")
		public String viewOneGiaDinh(@PathVariable int maNhanVien, Model model) {
		    model.addAttribute("viewOne", this.thongTinGiaDinhServiceTT.viewOne(maNhanVien));
			model.addAttribute("maNhanVien", maNhanVien);
			return "QuanLyNhanSuTT/ThongTinGiaDinh/viewOneGiaDinh";
		}

}
