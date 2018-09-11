package spring.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import spring.model.entity.SinhVien;
import spring.service.SinhVienService;

@Controller
public class SinhVienControllers {
	SinhVienService sinhVienService;

	@Autowired
	@Qualifier(value = "sinhVienServiceIPM")
	public void setStudentService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	@RequestMapping("/list")
	public String index(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage) {
		int totalRecords = sinhVienService.listStudent().size();
		int recordsPerPage = 2;
		int totalPages = (int)Math.ceil((double)totalRecords/recordsPerPage);
		int startPosition = recordsPerPage * (currentPage - 1);

		model.addAttribute("listStudent", sinhVienService.findAllForPaging(startPosition, recordsPerPage));
		model.addAttribute("lastPage", totalPages);
		model.addAttribute("currentPage", currentPage);

		return "list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("sinhvien", new SinhVien());
		return "create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createStudent(Model model, @ModelAttribute("sinhvien") @Valid SinhVien sv, HttpServletRequest request,
			MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "create";
		}
		sv.setAvatar(uploadFile(file, request));
		sinhVienService.add(sv);
		;
		return "redirect:/list";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpServletRequest request, Model model) {
		sinhVienService.delete(id);
		return "redirect:/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("sinhvien", sinhVienService.findById(id));
		return "edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("sinhvien") @Valid SinhVien sinhvien, HttpServletRequest request,
			@RequestParam("file") MultipartFile file, BindingResult bindingResult)
			throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		sinhvien.setAvatar(uploadFile(file, request));
		sinhVienService.update(sinhvien);
		return "redirect:/list";
	}

	public String uploadFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("hhmmssddMMyyyy");
		String fileName = fm.format(date) + "_" + file.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\upload\\";
		if (fileName.isEmpty()) {
			fileName = "default.png";
		} else {
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;
	}

	public boolean deleteFile(String fileName, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/") + "\\resources\\upload\\";
		File file = new File(path, fileName);
		boolean result = file.delete();
		return result;
	}
}
