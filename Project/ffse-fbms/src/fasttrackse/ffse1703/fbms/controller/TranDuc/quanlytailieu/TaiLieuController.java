package fasttrackse.ffse1703.fbms.controller.TranDuc.quanlytailieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu.TaiLieuService;

@Controller
@RequestMapping("/TranDuc-QuanLyTaiLieu/TaiLieu")
public class TaiLieuController {
	@Autowired
	private TaiLieuService serviceTL;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewTaiLieu(Model model,@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = serviceTL.listAll().size();
		int recordsPerPage = 10;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);
		model.addAttribute("listTaiLieu", serviceTL.listAllPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);
		return "TranDuc-QuanLyTaiLieu/TaiLieu/TaiLieuList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addFormTL(Model model) {
		model.addAttribute("TaiLieu", new TaiLieu());
		return "TranDuc-QuanLyTaiLieu/TaiLieu/add_formTL";
	}

	@RequestMapping(value = "/sua/{maTL}", method = RequestMethod.GET)
	public String editFormTL(@PathVariable("maTL") String maTL, Model model) {
		model.addAttribute("TaiLieu", serviceTL.getTLbyID(maTL));
		return "TranDuc-QuanLyTaiLieu/TaiLieu/edit_formTL";
	}

	@RequestMapping(value = "/xoa/{maTL}", method = RequestMethod.GET)
	public String delete(@PathVariable("maTL") String maTL, final RedirectAttributes redirectAttributes) {
		try {
			serviceTL.deleteTL(maTL);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa Thành Công !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Có lỗi, xin thử lại !");
		}
		return "TranDuc-QuanLyTaiLieu/TaiLieu/TaiLieuList";
	}

	@RequestMapping(value = "/view/{maTL}", method = RequestMethod.GET)
	public String viewOneTL(@PathVariable("maTL") String maTL, Model model) {
		model.addAttribute("TaiLieu", serviceTL.getTLbyID(maTL));
		return "TranDuc-QuanLyTaiLieu/TaiLieu/view_oneTL";
	}
	
	
}
