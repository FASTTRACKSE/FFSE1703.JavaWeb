package fasttrackse.ffse1703.fbms.controller.qttl;

//import java.io.File;
//import java.io.IOException;

//import java.text.SimpleDateFormat;
//import java.util.Date;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
import fasttrackse.ffse1703.fbms.entity.qttl.*;
import fasttrackse.ffse1703.fbms.service.qttl.*;

@Controller
@RequestMapping("QuanTriTaiLieu/DanhMuc")
public class CategoryController {

	CategoryService categoryService;

	@Autowired
	@Qualifier(value = "categoryServiceImpl")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

//	@RequestMapping("/home")
//	public String index(Model model,
//			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
//		int totalRecords = categoryService.listCategory().size();
//		int recordsPerPage = 2;
//		int totalPages = 0;
//		if ((totalRecords / recordsPerPage) % 2 == 0) {
//			totalPages = totalRecords / recordsPerPage;
//		} else {
//			totalPages = totalRecords / recordsPerPage + 1;
//		}
//		int startPosition = recordsPerPage * (currentPage - 1);
//
//		model.addAttribute("listStudent", categoryService.findAllForPaging(startPosition, recordsPerPage));
//		model.addAttribute("lastPage", totalPages);
//		model.addAttribute("currentPage", currentPage);
//
//		return "home";
//	}

	@RequestMapping(value = { "/list", ""})
	public String showForm(Model model) {
		model.addAttribute("category", categoryService.listCategory());
		return "QuanTriTaiLieu/DanhMuc/ListDanhMuc";
	}

	//@RequestMapping(value = "/create", method = RequestMethod.POST)
	//public String createStudent(Model model, @ModelAttribute("category") @Valid Category sv, HttpServletRequest request,
			//MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		//if (bindingResult.hasErrors()) {
			//return "create";
		//}
		//System.out.println(sv.getMa_danh_muc());
		//sv.setAvatar(uploadFile(file, request));
		//sinhVienService.add(sv);
		//;
		//return "redirect:/list";
	//}

	//@RequestMapping("/delete/{id}")
	//public String delete(@PathVariable int id, HttpServletRequest request, Model model) {
		//categoryService.delete(id);
		//return "redirect:/QuanTriTaiLieu/DanhMuc";
	//}
//
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	public String edit_view(@PathVariable("id") int id, Model model) {
//		model.addAttribute("category", categoryService.findById(id));
//		return "edit";
//	}

	//@RequestMapping(value = "/update", method = RequestMethod.POST)
	//public String edit(Model model, @ModelAttribute("category") @Valid Category category, HttpServletRequest request,
			//@RequestParam("file") MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		//if (bindingResult.hasErrors()) {
			//return "edit";
		//}
		//sinhvien.setAvatar(uploadFile(file, request));
		//sinhVienService.update(sinhvien);
		//return "redirect:/list";
	//}

	//public String uploadFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		//Date date = new Date();
		//SimpleDateFormat fm = new SimpleDateFormat("hhmmssddMMyyyy");
		//String fileName = fm.format(date) + "_" + file.getOriginalFilename();
		//String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\upload\\";
		//if (fileName.isEmpty()) {
			//fileName = "default.png";
		//} else {
			//File dir = new File(path);
			//if (!dir.exists())
				//dir.mkdirs();
			//File fileSave = new File(dir, fileName);
			//file.transferTo(fileSave);
		//}
		//return fileName;
	//}

	//public boolean deleteFile(String fileName, HttpServletRequest request) {
		//String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\upload\\";
		//File file = new File(path, fileName);
		//boolean result = file.delete();
		//return result;
	//}
}