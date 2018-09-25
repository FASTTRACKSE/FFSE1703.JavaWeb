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

import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.VaiTroThanhVienTeam1;
import fasttrackse.ffse1703.fbms.service.quanlyduan.ProgramingLanguageTeam1Service;

@Controller
@RequestMapping("/QuanLyDuAn/Language")
public class ProgramingLanguageTeam1Controller {
	@Autowired
	ProgramingLanguageTeam1Service languageService;
	
	@RequestMapping(value = { "/list", "" })
	public String list(Model model) {
		model.addAttribute("list", languageService.getAll());
		return "QuanLyDuAn/ProgramingLanguage/listLanguage";

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		model.addAttribute("language", new ProgramingLanguageTeam1());
		return "QuanLyDuAn/ProgramingLanguage/addLanguage";
	}
	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("language") @Valid ProgramingLanguageTeam1 language1, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuanLyDuAn/Language/add";
		}

		if (languageService.getById(language1.getMaNn()) != null) {
			ProgramingLanguageTeam1 db = languageService.getById(language1.getMaNn());
			if (db.getIsDelete() == 1) {
				languageService.update(language1);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã Ngôn Ngữ Đã Tồn Tại.');</script>");
				return "redirect:/QuanLyDuAn/Language/add";
			}
		}
		
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		languageService.addNew(language1);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/edit/{maNn}")
	public String edit(Model model, @PathVariable("maNn") String maNn) {
		model.addAttribute("language", languageService.getById(maNn));
		return "QuanLyDuAn/ProgramingLanguage/editLanguage";

	}
	
	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("language") @Valid ProgramingLanguageTeam1 vendorTeam1, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/ProgramingLanguage/editLanguage";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		languageService.update(vendorTeam1);
		return "redirect:list";

	}
	
	@RequestMapping(value = { "/delete/{maNn}" })
	public String delete(Model model, @PathVariable("maNn") String maNn) {
		languageService.delete(maNn);
		return "redirect:/QuanLyDuAn/Language";

	}
}
