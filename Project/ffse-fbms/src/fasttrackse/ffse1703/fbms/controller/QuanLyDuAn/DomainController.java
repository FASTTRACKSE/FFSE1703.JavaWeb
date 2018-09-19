package fasttrackse.ffse1703.fbms.controller.QuanLyDuAn;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Domain;
import fasttrackse.ffse1703.fbms.service.QuanLyDuAn.DomainService;
@Controller
@RequestMapping("/qlda/domain")
public class DomainController {
	DomainService domainService;

	@Autowired
	@Qualifier(value = "domainServiceImpl")
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	@RequestMapping(value = "/add_form", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("domain", new Domain());
		return "QuanLyDuAn/Domain/add_form";
	}
	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createDomain(@ModelAttribute("domain") @Valid Domain domain) {
		
		domainService.add(domain);
		return "redirect:/qlda/domain/list";
	}*/
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("domain") @Valid Domain domain, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (domainService.findById(domain.getMaNghiepVu()) != null) {
			return "redirect:/qlda/domain/edit_form/" + domain.getMaNghiepVu();
		} else {
			if (result.hasErrors()) {
				return "QuanLyDuAn/Domain/add_form";
			}
			domainService.add(domain);
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		return "redirect:list";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listDonNhap(Model model)  {
		model.addAttribute("list", domainService.getAll());
		return "QuanLyDuAn/Domain/list";
	}

	/*@RequestMapping("/delete/{maNghiepVu}")
	public String delete(@PathVariable String maNghiepVu, HttpServletRequest request, Model model) {
		domainService.delete(maNghiepVu);
		return "redirect:/qlda/domain/list";
	}*/
	@RequestMapping("/delete/{maNghiepVu}")
	public String delete(@PathVariable String maNghiepVu, HttpServletRequest request, Model model) {
		Domain domain = domainService.findById(maNghiepVu);
		domain.setIs_delete("1");
		domainService.delete(domain);
		return "redirect:/qlda/domain/list";
	}

	@RequestMapping(value = "/edit_form/{maNghiepVu}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("maNghiepVu") String maNghiepVu) {
		model.addAttribute("domain", domainService.findById(maNghiepVu));
		return "QuanLyDuAn/Domain/edit_form";
	}
	@RequestMapping(value = "/view/{maNghiepVu}", method = RequestMethod.GET)
	public String viewDomain(Model model, @PathVariable("maNghiepVu") String maNghiepVu) {
		model.addAttribute("domain", domainService.findById(maNghiepVu));
		return "QuanLyDuAn/Domain/info";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public String update(@ModelAttribute("domain") @Valid Domain domain, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Domain/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		domainService.update(domain);
		return "redirect:/qlda/domain/list";

	}


}
