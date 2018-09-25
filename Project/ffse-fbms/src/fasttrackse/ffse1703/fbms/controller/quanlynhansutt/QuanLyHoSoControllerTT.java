package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuanHuyenTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.XaPhuongTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.DanTocServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuanHuyenServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuanLyHoSoServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuocTichServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.TinhThanhServiceTT;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.XaPhuongServiceTT;
import fasttrackse.ffse1703.fbms.service.security.ChucDanhService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/quanlynhansutt/ho_so/")
public class QuanLyHoSoControllerTT {

	@Autowired
	private QuanLyHoSoServiceTT quanLyHoSoServiceTT;

	@Autowired
	private QuocTichServiceTT quocTichServiceTT;

	@Autowired
	private DanTocServiceTT danTocServiceTT;

	@Autowired
	private TinhThanhServiceTT tinhThanhServiceTT;

	
	@Autowired
	private QuanHuyenServiceTT quanHuyenServiceTT;


	@Autowired
	private XaPhuongServiceTT xaPhuongServiceTT;

	@Autowired
	private ChucDanhService chucDanhService;

	@Autowired
	private PhongBanService phongBanService;

	public QuanLyHoSoServiceTT getQuanLyHoSoServiceTT() {
		return quanLyHoSoServiceTT;
	}

	public void setQuanLyHoSoServiceTT(QuanLyHoSoServiceTT quanLyHoSoServiceTT) {
		this.quanLyHoSoServiceTT = quanLyHoSoServiceTT;
	}

	public void setQuocTichServiceTT(QuocTichServiceTT quocTichServiceTT) {
		this.quocTichServiceTT = quocTichServiceTT;
	}

	public void setDanTocServiceTT(DanTocServiceTT danTocServiceTT) {
		this.danTocServiceTT = danTocServiceTT;
	}

	public void setTinhThanhServiceTT(TinhThanhServiceTT tinhThanhServiceTT) {
		this.tinhThanhServiceTT = tinhThanhServiceTT;
	}

	public void setQuanHuyenServiceTT(QuanHuyenServiceTT quanHuyenServiceTT) {
		this.quanHuyenServiceTT = quanHuyenServiceTT;
	}

	public void setXaPhuongServiceTT(XaPhuongServiceTT xaPhuongServiceTT) {
		this.xaPhuongServiceTT = xaPhuongServiceTT;
	}

	public void setChucDanhService(ChucDanhService chucDanhService) {
		this.chucDanhService = chucDanhService;
	}

	public void setPhongBanService(PhongBanService phongBanService) {
		this.phongBanService = phongBanService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHoSo(Model model) {
		model.addAttribute("listHoSo", quanLyHoSoServiceTT.getAllHoSo());
		return "QuanLyNhanSuTT/QuanLyHoSoTT/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String formAdd(Model model, final RedirectAttributes redirectAttributes) {

		model.addAttribute("hoSoNhanVienTT", new HoSoNhanVienTT());                              
		model.addAttribute("listPhongBan", phongBanService.findAll());
		model.addAttribute("listQuocTich", quocTichServiceTT.getAllQuocTich());
		model.addAttribute("listChucDanh", chucDanhService.findAll());
		model.addAttribute("listDanToc", danTocServiceTT.listDanTocTT()); 
		model.addAttribute("listThanhPho", tinhThanhServiceTT.getAllTinhThanh()); 
		return "QuanLyNhanSuTT/QuanLyHoSoTT/add_hoso";
	}
	@RequestMapping(value= "selectquan/{maThanhPho}", method= RequestMethod.GET, produces= "text/plain;charset=UTF-8")
	@ResponseBody 
	public String selectQuan(@PathVariable String maThanhPho) {
		List<QuanHuyenTT> listQuanHuyen =  quanHuyenServiceTT.listQuanHuyen(maThanhPho);
		
		String json = "[";
		
		for(int i =0; i < listQuanHuyen.size(); i++) {
			
			if (i == listQuanHuyen.size() - 1) {
				json += "{\"maQuanHuyen\":" + "\"" + listQuanHuyen.get(i).getMaQuanHuyen() + "\"" + ", \"tenQuanHuyen\" :" + "\"" + listQuanHuyen.get(i).getTenQuanHuyen() + "\"" + "}";
			} else {
				json += "{\"maQuanHuyen\":" + "\"" + listQuanHuyen.get(i).getMaQuanHuyen() + "\"" + ", \"tenQuanHuyen\" :" + "\"" + listQuanHuyen.get(i).getTenQuanHuyen() + "\"" + "},";
			}
		}
		json += "]";
		
		return json;
		
	}
	@RequestMapping(value= "selectphuong/{maQuanHuyen}", method= RequestMethod.GET,  produces= "text/plain;charset=UTF-8")
	@ResponseBody 
	public String selectPhuong(@PathVariable String maQuanHuyen) {
		List<XaPhuongTT> listPhuong= xaPhuongServiceTT.getAllXaPhuong(maQuanHuyen);
		
		String json = "[";
		
		for(int i= 0; i < listPhuong.size(); i++) {
			if(i == listPhuong.size() - 1) {
				json += "{\"maXa\": \"" + listPhuong.get(i).getMaXa() + "\", " + "\"tenXa\": \"" + listPhuong.get(i).getTenXa() + "\"}" ;
			}
			else {
				json += "{\"maXa\": \"" + listPhuong.get(i).getMaXa() + "\", " + "\"tenXa\": \"" + listPhuong.get(i).getTenXa() + "\"}" + "," ;
			}
		}
		json+= "]";
		
		return json;
	}
}
