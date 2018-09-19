package fasttrackse.ffse1703.fbms.controller.qlvn2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.service.qlvn2.DonXinPhepService;
@Controller
public class DonXinPhepController {
	@Autowired
	DonXinPhepService DonXinPhepService;
	
	@RequestMapping(value ="/danhsachnhap003")
	public String danhsachnhap003(Model model ) {
		model.addAttribute("danhsachnhap003", DonXinPhepService.danhsachnhap003());
		return "QuanlyvangnghiDanhLT/danhsachnhap003";
    }
	@RequestMapping(value ="/danhsachdaduyet003")
	public String danhsachdaduyet003(Model model ) {
		model.addAttribute("danhsachdaduyet003", DonXinPhepService.danhsachdaduyet003());
		return "QuanlyvangnghiDanhLT/danhsachdaduyet003";
    }
	@RequestMapping(value ="/danhsachchoduyet003")
	public String danhsachchoduyet003(Model model ) {
		model.addAttribute("danhsachchoduyet003", DonXinPhepService.danhsachchoduyet003());
		return "QuanlyvangnghiDanhLT/danhsachchoduyet003";
    }
	@RequestMapping(value ="/danhsachbituchoi003")
	public String danhsachbituchoi003(Model model ) {
		model.addAttribute("danhsachbituchoi003", DonXinPhepService.danhsachbituchoi003());
		return "QuanlyvangnghiDanhLT/danhsachbituchoi003";
    }

}
