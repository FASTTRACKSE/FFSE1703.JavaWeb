package fasttrackse.ffse1703.fbms.controller.quanlyduan;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.DuAnTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.DatabaseTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.DomainTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.DuAnTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.FrameworkTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.KhachHangTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.TechnicalTeam1Service;
import fasttrackse.ffse1703.fbms.service.quanlyduan.TrangThaiTeam1Service;

@Controller
@RequestMapping("/qlda/DuAn")
public class DuAnTeam1Controller {
	@Autowired
	DuAnTeam1Service duAnTeam1Service;
	@Autowired
	DatabaseTeam1Service databaseTeam1Service;
	@Autowired
	KhachHangTeam1Service khachHangTeam1Service;
	@Autowired
	TrangThaiTeam1Service trangThaiTeam1Service;
	@Autowired
	DomainTeam1Service domainTeam1Service;
	@Autowired
	FrameworkTeam1Service frameTeam1Service;
	@Autowired
	TechnicalTeam1Service technicalTeam1Service;

	@RequestMapping(value = { "/list", "" })
	public String list(Model model) {
		model.addAttribute("list", duAnTeam1Service.getAll());
		return "QuanLyDuAn/DuAn/list";
	}

	@RequestMapping(value = { "/delete/{maDuAn}" })
	public String delete(Model model, @PathVariable("maDuAn") String maDuAn) {
		duAnTeam1Service.delete(maDuAn);

		return "redirect:/qlda/DuAn";
	}

	@RequestMapping(value = { "/add_form" })
	public String redirect(Model model) {
		model.addAttribute("duAn", new DuAnTeam1());
		model.addAttribute("database", databaseTeam1Service.getAll());
		model.addAttribute("khachhang", khachHangTeam1Service.getAll());
		model.addAttribute("TrangThai", trangThaiTeam1Service.getAll());
		model.addAttribute("Domain", domainTeam1Service.getAll());
		model.addAttribute("Framework", frameTeam1Service.getAll());
		model.addAttribute("Technical", technicalTeam1Service.getAll());


		

		return "QuanLyDuAn/DuAn/add_form";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("duAn") @Valid DuAnTeam1 duAn, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {

		if (result.hasErrors()) {
			return "QuanLyDuAn/DuAn/add_form";
		}
		int checkTen = duAnTeam1Service.getName(duAn.getTenDuAn());
		System.out.println(checkTen);
		if (checkTen >= 1) {
			redirectAttributes.addFlashAttribute("message", "<script>alert('Tên Dự Án đã tồn tại.');</script>");
			return "redirect:/qlda/DuAn/add_form";
		}

		if (duAnTeam1Service.getById(duAn.getMaDuAn()) != null) {
			DuAnTeam1 db = duAnTeam1Service.getById(duAn.getMaDuAn());
			if (db.getIsDelete() == 1) {
				duAnTeam1Service.update(duAn);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã dự án đã tồn tại.');</script>");
				return "redirect:/qlda/DuAn/add_form";
			}
		}

		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		duAnTeam1Service.save(duAn);
		return "redirect:list";
	}

	/*
	 * @ModelAttribute public void addAttributes(Model model) {
	 * model.addAttribute("msg", "Welcome to the Netherlands!"); }
	 */
	@RequestMapping(value = "/edit/{maDuAn}")
	public String edit(Model model, @PathVariable("maDuAn") String maDuAn) {
		model.addAttribute("duAn", duAnTeam1Service.getById(maDuAn));
		return "QuanLyDuAn/DuAn/edit_form";

	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("duAn") @Valid DuAnTeam1 duAn, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/DuAn/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		duAnTeam1Service.update(duAn);
		return "redirect:list";

	}

	@RequestMapping(value = "/view/{maDuAn}")
	public String demo(Model model, @PathVariable("maDuAn") String maDuAn) {
		model.addAttribute("duAn", duAnTeam1Service.getById(maDuAn));
		model.addAttribute("database", databaseTeam1Service.getAll());
		model.addAttribute("khachhang", khachHangTeam1Service.getAll());
		model.addAttribute("TrangThai", trangThaiTeam1Service.getAll());

		return "QuanLyDuAn/DuAn/demo";

	}
	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// binder.registerCustomEditor(DatabaseTeam1.class, "database", new
	// PropertyEditorSupport() {
	// @Override
	// public void setAsText(String text) throws IllegalArgumentException {
	// setValue(databaseTeam1Service.getById(text));
	// }
	// });
	// }

}
