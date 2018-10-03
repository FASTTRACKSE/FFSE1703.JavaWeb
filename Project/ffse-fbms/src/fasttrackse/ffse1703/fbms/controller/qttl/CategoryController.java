package fasttrackse.ffse1703.fbms.controller.qttl;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qttl.*;
import fasttrackse.ffse1703.fbms.service.qttl.*;

@Controller
@RequestMapping("/QuanTriTaiLieu/DanhMuc")
public class CategoryController {

	CategoryService categoryService;

	@Autowired
	@Qualifier(value = "categoryServiceImpl")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = { "/","/list"})
	public String showForm(Model model) {
		model.addAttribute("category", categoryService.listCategory());
		return "QuanTriTaiLieu/DanhMuc/listDanhMuc";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.GET)
	public String addFrom(Model model, final RedirectAttributes redirecAttributes ) {
		model.addAttribute("category", new Category());
		return "QuanTriTaiLieu/DanhMuc/add_form";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("category") @Valid Category sv, HttpServletRequest request,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "create";
		}
		System.out.println(sv.getId());
		categoryService.add(sv);
		;
		return "redirect:/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(Model model,@PathVariable("id") int id) {
		categoryService.delete(id);
		return "redirect:/QuanTriTaiLieu/DanhMuc/list";
	}
}