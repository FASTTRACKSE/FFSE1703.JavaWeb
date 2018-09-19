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

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Database;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.DatabaseServices;



@Controller
@RequestMapping("/mvpquanliduan/database")
public class DatabaseControllers {
	@Autowired
	private DatabaseServices databaseService;
	

	public void setDatabaseService(DatabaseServices databaseService) {
		this.databaseService = databaseService;
	}

	@RequestMapping("/list-database")
	public String listDatabase(Model model) {
		List<Database> list = databaseService.findAll();
		model.addAttribute("listDatabase", list);
		return "MvpQuanLiDuAn/database/listdatabase";
	}

	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Database());
		return "MvpQuanLiDuAn/database/adddatabase";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Database database, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		
		//validation form 
		if (result.hasErrors()) {
			return "MvpQuanLiDuAn/database/adddatabase";
		}
		//check trùng namedatabase
		int checkName= databaseService.checkNameDatabase(database.getNameDatabase());
		if(checkName >=1) {
			model.addAttribute("messageName", "Tên database đã được sử dụng");
			return "MvpQuanLiDuAn/database/adddatabase";
		}
		int checkMa= databaseService.checkMaDatabase(database.getIdDatabase());
		if(checkMa >=1) {
			model.addAttribute("messageMa", "Mã database đã được sử dụng");
			return "MvpQuanLiDuAn/database/adddatabase";
		}
		database.setStatus(1);
		databaseService.addNew(database);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-database";
	}

	@RequestMapping(value = "/show-form-edit/{id}")
	public String showFormEdit(Model model, @PathVariable String id) {
		Database dm = databaseService.findById(id);
		model.addAttribute("database", dm);
		return "MvpQuanLiDuAn/database/updatedatabase";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("Database") Database database, BindingResult result,
			final RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("database", database);
			return "MvpQuanLiDuAn/database/updatedatabase";
		}
		database.setStatus(1);
		databaseService.update(database);
		return "redirect: list-database";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable String id, final RedirectAttributes redirectAttributes) {
		Database dm = databaseService.findById(id);
		dm.setStatus(0);
		databaseService.update(dm);
		return "redirect: /ffse-fbms/mvpquanliduan/database/list-database";
	}
}
