package fasttrackse.ffse1703.fbms.controller.QuanLyDuAn;

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

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Database;
import fasttrackse.ffse1703.fbms.service.QuanLyDuAn.DatabaseService;

@Controller
@RequestMapping("/qlda/Famework")

public class FameworkController {
	@Autowired
	DatabaseService databaseService;

	@RequestMapping(value = { "/list", "" })
	public String list(Model model) {
		model.addAttribute("list", databaseService.getAll());
		return "QuanLyDuAn/Famework/list";

	}

	@RequestMapping(value = { "/delete/{maDatabase}" })
	public String delete(Model model, @PathVariable("maDatabase") String maDatabase) {
		databaseService.delete(maDatabase);
		return "redirect:/qlda/Famework";

	}

	@RequestMapping(value = { "/add_form" })
	public String redirect(Model model) {
		model.addAttribute("command", new Database());
		return "QuanLyDuAn/Famework/add_form";
	}

	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("database") @Valid Database database, BindingResult result , RedirectAttributes redirectAttributes) {
		if(databaseService.getById(database.getMa_database())!=null) {
			databaseService.setIsDelete(database.getMa_database());
			databaseService.update(database);
			return "redirect:list";
			}	

		
		if (result.hasErrors()) {
			return "QuanLyDuAn/Famework/add_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");

		databaseService.save(database);
		return "redirect:list";
	}

	/*
	 * @ModelAttribute public void addAttributes(Model model) {
	 * model.addAttribute("msg", "Welcome to the Netherlands!"); }
	 */
	@RequestMapping(value = "/edit/{maDatabase}")
	public String edit(Model model, @PathVariable("maDatabase") String maDatabase) {
		model.addAttribute("database", databaseService.getById(maDatabase));
		return "QuanLyDuAn/Famework/edit_form";

	}

	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("database") @Valid Database database, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanLyDuAn/Famework/edit_form";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		databaseService.update(database);
		return "redirect:list";

	}

}
