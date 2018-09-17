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

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.DomainService;

@Controller
@RequestMapping("/mvpquanliduan/domain")
public class DomainController {
	@Autowired
	private DomainService domainService;
	

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	@RequestMapping("/listdomain")
	public String listDomain(Model model) {
		List<Domain> list = domainService.findAll();
		model.addAttribute("listDomain", list);
		return "MvpQuanLiDuAn/domain/listdomain";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Domain());
		return "MvpQuanLiDuAn/domain/adddomain";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Domain domain, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		int check= domainService.checkDomain(domain.getNameDomain());
		
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/domain/adddomain";
		}
		if(check >=1) {
			model.addAttribute("message", "Nghệp vụ đã tồn tại");
			return "MvpQuanLiDuAn/domain/adddomain";
		}
		domain.setStatus(1);
		domainService.addNew(domain);
		return "redirect: listdomain";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable int id) {
		Domain dm = domainService.findById(id);
		System.out.println("domainla" + dm);
		model.addAttribute("domain", dm);
		return "MvpQuanLiDuAn/domain/updatedomain";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Domain") Domain domain, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/domain/updatedomain";
		}
		domain.setStatus(1);
		domainService.update(domain);
		return "redirect: listdomain";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		Domain dm = domainService.findById(id);
		dm.setStatus(0);
		domainService.update(dm);
		return "redirect: /ffse-fbms/mvpquanliduan/domain/listdomain";
	}
}
