package fasttrackse.ffse1703.fbms.controller.qttl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

//import fasttrackse.ffse1702a.fbms.quanlytailieu.dto.DocumentDTO;
import fasttrackse.ffse1703.fbms.service.qttl.*;
import fasttrackse.ffse1703.fbms.entity.qttl.*;

@Controller
@SessionAttributes({"quyenTruyCap"})
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	// -------------- my document ----------//
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model ,Integer offset, Integer maxResults) {
		
		List<Document> list =  documentService.getAll(offset, maxResults);
        model.addAttribute("count", documentService.count());
        model.addAttribute("offset", offset);
        model.addAttribute("listDocument", list);		
		return "index";
	}

	// approve document
	@RequestMapping(value = "/documentAccept/{id}", method = RequestMethod.GET)
	public String documentAccept(@PathVariable int id, Model model) {
		documentService.accept(id);
		return "redirect:/";
	}
	// approve document
		@RequestMapping(value = "/documentRefuse/{id}", method = RequestMethod.GET)
		public String documentRefuse(@PathVariable int id, Model model) {
			documentService.refuse(id);
			return "redirect:/";
		}

	// ----------------- delete ----------------//
	@RequestMapping(value = "/documentDelete/{id}", method = RequestMethod.GET)
	public String documentDelete(@PathVariable int id, Model model) {
		documentService.delete(id);
		return "redirect:/";
	}

	// edit document
	@RequestMapping(value = "/documentEdit/{id}", method = RequestMethod.GET)
	public String documentEdit(@PathVariable int id, Model model) {
		model.addAttribute("document", documentService.findById(id));
		return "documentUpdate";
	}
	// view document
		@RequestMapping(value = "/documentView/{id}", method = RequestMethod.GET)
		public String documentView(@PathVariable int id, Model model) {
			model.addAttribute("document", documentService.findById(id));
			return "documentView";
		}

	// ------------- insert --------------//
	// redirect page add document
	@RequestMapping(value = "/documentInsert")
	public String documentInsert(Model model) {
		model.addAttribute("document", new Document());
		return "documentInsert";
	}

	
	// ------------------------------------//

	// -------------- my draft document ----------//
	@RequestMapping(value = "/myDraft", method = RequestMethod.GET)
	public String mydraft(Model model) {
		model.addAttribute("listDraft", documentService.getAllDraft());
		return "mydraft";
	}

	// ----------- document pending approve -------//
	@RequestMapping(value = "/pendingApprove", method = RequestMethod.GET)
	public String pendingApprove(Model model) {
		model.addAttribute("listPendingApprove", documentService.getAllPendingApprove());
		return "pendingapprove";
	}

	// ----------- document public -------//
	@RequestMapping(value = "/documentPublic", method = RequestMethod.GET)
	public String documentPublic(Model model) {
		model.addAttribute("listPublicDocument", documentService.getAllPublicDocument());
		return "documentpublic";
	}

	// get tên danh mục
	@ModelAttribute("listCategory")
	public List<Category> listCategory() {
		return this.documentService.listCategory();
	}
	@ModelAttribute("listQuyen")
	public List<QuyenTruyCap> listQuyen() {
		return this.documentService.listQuyen();
	}
}