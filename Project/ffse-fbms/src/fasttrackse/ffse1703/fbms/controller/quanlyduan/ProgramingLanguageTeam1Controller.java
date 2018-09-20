package fasttrackse.ffse1703.fbms.controller.quanlyduan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.quanlyduan.ProgramingLanguageTeam1Service;

@Controller
@RequestMapping("/QuanLyDuAn/Languege")
public class ProgramingLanguageTeam1Controller {
	@Autowired
	ProgramingLanguageTeam1Service languageService;
	
	@RequestMapping(value = { "/list", "" })
	public String list(Model model) {
		model.addAttribute("list", languageService.getAll());
		return "QuanLyDuAn/ProgramingLanguage/listLanguage";

	}
}
