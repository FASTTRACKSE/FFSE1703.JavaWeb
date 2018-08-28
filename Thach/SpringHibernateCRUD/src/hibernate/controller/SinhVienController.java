package hibernate.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hibernate.entity.SinhVien;
import hibernate.service.SinhVienService;

@Controller
public class SinhVienController {

	public static int pageIndex;
	public static double totalPage;
	public static double totalRecord;
	public static double recordPerPage;

	public static SinhVien getSv = new SinhVien();

	// đường dẫn upload file
	private static final String UPLOAD_DIRECTORY = "/image";

	private SinhVienService sinhvienService;

	@Autowired(required = true)
	@Qualifier(value = "sinhVienServiceImpl")
	public void setSinhvienService(SinhVienService sinhvienService) {
		this.sinhvienService = sinhvienService;
	}

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/1");
	}

	@RequestMapping(value = "/{pageId}")
	public String listSinhVien(@PathVariable("pageId") int pageid, Model model) {
		totalRecord = this.sinhvienService.totalRecord();
		recordPerPage = 2.0;
		totalPage = Math.ceil(totalRecord / recordPerPage);
		pageIndex = pageid;

		int start = (pageid - 1) * (int) recordPerPage;
		if (start < 0) {
			start = 0;
		}
		List<SinhVien> listSinhVien = this.sinhvienService.listSinhVien(start, (int) recordPerPage);

		model.addAttribute("listSinhVien", listSinhVien);
		model.addAttribute("totalPage", (int) totalPage);
		model.addAttribute("pageIndex", pageid);
		return "index";
	}

	@RequestMapping(value = { "/addSv" }, method = RequestMethod.GET)
	public ModelAndView addSv() {
		return new ModelAndView("addSv", "command", new SinhVien()); // "command" mặc định của spring frame work
	}

	@RequestMapping(value = "/addSave", method = RequestMethod.POST)
	public ModelAndView addSave(@ModelAttribute("command") @Valid SinhVien sv, BindingResult result,
			@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException {
		if (result.hasErrors()) {
			return new ModelAndView("addSv");
		}

		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();
		System.out.println(path + " " + filename);
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));
		sv.setHinhAnh(filename);
		stream.write(bytes);
		stream.flush();
		stream.close();
		sinhvienService.insert(sv);
		return new ModelAndView("redirect:/"); // mặc định trở về trang index. đã đc định nghĩa ở web.xml

	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("command") @Valid SinhVien sv, BindingResult result,
			@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException {
		sv.setHinhAnh(getSv.getHinhAnh()); // thuộc tính hình sẽ trả về null -> phải set dữ liệu
		if (result.hasErrors()) {
			return new ModelAndView("addSv");
		}
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();
		if (!filename.isEmpty()) {
			System.out.println(path + " " + filename);
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			sv.setHinhAnh(filename);
			stream.write(bytes);
			stream.flush();
			stream.close();
		}
		sinhvienService.update(sv);
		return new ModelAndView("redirect:/"); // mặc định trở về trang index. đã đc định nghĩa ở web.xml
	}

	@RequestMapping("/editSv/{id}")
	public ModelAndView getSv(@PathVariable int id) {
		SinhVien sv = sinhvienService.getEdit(id);
		return new ModelAndView("editSv", "command", sv); // "command" mặc định của spring frame work
	}

	@RequestMapping("/deleteSv/{id}")
	public String delete(@PathVariable("id") int id, HttpSession session) {
		// xóa thông tin sinh viên
		sinhvienService.delete(id);
		totalRecord = sinhvienService.totalRecord();
		totalPage = Math.ceil(totalRecord / recordPerPage);
		if (pageIndex > (int) totalPage) {
			pageIndex = (int) totalPage;
		}
		return "redirect:/";
	}

}
