package fasttrackse.ffse1703.fbms.controller.qttl;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qttl.*;
import fasttrackse.ffse1703.fbms.service.qttl.*;



@Controller
@RequestMapping("/QuanTriTaiLieu/TaiLieu")
public class DocumentController {
	@Autowired
	DocumentService documentService;
	
	@Autowired
	@Qualifier(value = "documentServiceImpl")
	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}
	
	
	@RequestMapping({"/list" , ""})
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = documentService.getAll().size();
		int recordsPerPage = 3;
		int totalPages = 0;
		if ((totalRecords / recordsPerPage) % 2 == 0) {
			totalPages = totalRecords / recordsPerPage;
		} else {
			totalPages = totalRecords / recordsPerPage + 1;
		}
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("list", documentService.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "QuanTriTaiLieu/TaiLieu/listTaiLieu";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model, final RedirectAttributes redirectAttributes) {
		List<Category> listcategory = documentService.listCategory();
		model.addAttribute("listCategory", listcategory);
		List<Status> liststatus = documentService.listStatus();
		model.addAttribute("listStatus", liststatus);
		List<Room> listroom = documentService.listRoom();
		model.addAttribute("listRoom", listroom);
		model.addAttribute("command", new Document());
		return "QuanTriTaiLieu/TaiLieu/addTaiLieu";
	}
	
	@RequestMapping(value = { "/creat" }, method = RequestMethod.POST)
	public String creat(@ModelAttribute("document") @Valid Document document, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuanTriTaiLieu/TaiLieu/add";
		}

		if (documentService.getById(document.getId()) != null) {
			Document db = documentService.getById(document.getId());
			if (db.getId() == 1) {
				documentService.update(document);
				return "redirect:list";

			} else {
				redirectAttributes.addFlashAttribute("message", "<script>alert('Mã đã tồn tại.');</script>");
				return "redirect:/QuanTriTaiLieu/TaiLieu/add";
			}
		}
		
		redirectAttributes.addFlashAttribute("message", "<script>alert('Creat successfully.');</script>");
		documentService.addNew(document);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		List<Category> listcategory = documentService.listCategory();
		model.addAttribute("listCategory", listcategory);
		List<Status> liststatus = documentService.listStatus();
		model.addAttribute("listStatus", liststatus);
		List<Room> listroom = documentService.listRoom();
		model.addAttribute("listRoom", listroom);
		model.addAttribute("document", documentService.getById(id));
		return "QuanTriTaiLieu/TaiLieu/editTaiLieu";

	}
	@RequestMapping(value = "/update")
	public String update(@ModelAttribute("document") @Valid Document document, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "QuanTriTaiLieu/TaiLieu/editTaiLieu";
		}
		redirectAttributes.addFlashAttribute("message", "<script>alert('Update successfully.');</script>");
		documentService.update(document);
		return "redirect:list";

	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") int id) {
		documentService.delete(id);
		return "redirect:/QuanTriTaiLieu/TaiLieu";

	}
	
}