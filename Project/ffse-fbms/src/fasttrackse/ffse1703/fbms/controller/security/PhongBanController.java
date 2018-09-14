package fasttrackse.ffse1703.fbms.controller.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.service.security.DatatableService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/quantrihethong/phong_ban")
public class PhongBanController {

	@Autowired
	private PhongBanService phongBanService;
	
	@Autowired
	private DatatableService datatableService;

	@RequestMapping(value = "/view/danhSachPhongBan", method = RequestMethod.GET)
	public String viewPhongBan(Model model) {
		return "quantrihethong/phongban/list";
	}
	
	@RequestMapping(value = "/view/{maPhongBan}", method = RequestMethod.GET)
	public String viewOnePhongBan(@PathVariable("maPhongBan") String maPhongBan, Model model) {
		model.addAttribute("phongBan", phongBanService.findByMaPhongBan(maPhongBan));
		return "quantrihethong/phongban/viewOne";
	}
	
	@RequestMapping(value = "/view/getListPhongBan", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getListPhongBan(Model model, HttpServletRequest request) {
		
		int iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
		int iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));
		String sql = phongBanService.getSQL(request);
		List<PhongBan> listPhongBan = phongBanService.findAll(iDisplayStart, iDisplayLength, sql);

		String recordsTotal = phongBanService.getRecordsTotal();
		String recordsFiltered = phongBanService.getRecordsFiltered(sql);
		String json = datatableService.getJsonPhongBan(recordsTotal, recordsFiltered, listPhongBan);
		return json;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("phongBan", new PhongBan());
		return "quantrihethong/phongban/add_form";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAdd(Model model, @ModelAttribute("phongBan") PhongBan pb,
			final RedirectAttributes redirectAttributes) {
		try {
			phongBanService.addNew(pb);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thêm mới thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/quantrihethong/phong_ban/view/danhSachPhongBan";
	}

	@RequestMapping(value = "/edit/{maPhongBan}", method = RequestMethod.GET)
	public String editForm(@PathVariable("maPhongBan") String maPhongBan, Model model) {
		model.addAttribute("phongBan", phongBanService.findByMaPhongBan(maPhongBan));
		return "quantrihethong/phongban/edit_form";
	}

	@RequestMapping(value = "/edit/{maPhongBan}", method = RequestMethod.POST)
	public String doEdit(Model model, @ModelAttribute("phongBan") PhongBan pb,
			final RedirectAttributes redirectAttributes) {
		try {
			phongBanService.update(pb);
			redirectAttributes.addFlashAttribute("messageSuccess", "Thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/quantrihethong/phong_ban/view/danhSachPhongBan";
	}

	@RequestMapping(value = "/delete/{maPhongBan}", method = RequestMethod.GET)
	public String delete(@PathVariable("maPhongBan") String maPhongBan, final RedirectAttributes redirectAttributes) {
		try {
			phongBanService.delete(maPhongBan);
			redirectAttributes.addFlashAttribute("messageSuccess", "Xóa thành công..");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("messageError", "Lỗi. Xin thử lại!");
		}
		return "redirect:/quantrihethong/phong_ban/view/danhSachPhongBan";
	}
}
