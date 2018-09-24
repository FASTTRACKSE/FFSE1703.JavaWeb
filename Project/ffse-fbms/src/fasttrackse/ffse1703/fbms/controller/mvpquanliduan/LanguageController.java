package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.LanguageService;

@Controller
@RequestMapping("/mvpquanliduan/language")
public class LanguageController {
	@Autowired
	private LanguageService languageService;
	public void setLanguageService(LanguageService languageService) {
		this.languageService=languageService;
	}
	@RequestMapping(value = "/list-language")
	public String listLanguage(Model model) {
		List<Language> list = languageService.getAll();
		model.addAttribute("listLanguage", list);
		return "MvpQuanLiDuAn/programlanguage/list";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Language());
		return "MvpQuanLiDuAn/programlanguage/add_form";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Language language, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/programlanguage/add_form";
		}
		
		
		language.setStatus(1);
		languageService.add(language);
		;
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-language";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable int id) {
		Language language= 		languageService.getById(id);
		model.addAttribute("language", language);
		return "MvpQuanLiDuAn/programlanguage/update_form";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/programlanguage/update_form";
		}
		language.setStatus(1);
		languageService.update(language);
		return "redirect: /ffse-fbms/mvpquanliduan/language/list-language";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		Language language = languageService.getById(id);
		language.setStatus(0);
		languageService.update(language);
		return "redirect: /ffse-fbms/mvpquanliduan/language/list-language";
	}
}
