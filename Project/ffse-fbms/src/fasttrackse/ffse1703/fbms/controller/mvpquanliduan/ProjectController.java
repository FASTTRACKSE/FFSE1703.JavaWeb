package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;

@Controller
@RequestMapping("/mvpquanliduan/project")
public class ProjectController {
	
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Domain());
		return "MvpQuanLiDuAn/project/addproject";
	}
}
