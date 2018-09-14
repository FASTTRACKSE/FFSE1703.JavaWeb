package ducdeptrai.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ducdeptrai.model.SinhVien;
import ducdeptrai.service.SVService;

@Controller
public class SVController {
	
	public int perPage = 2;
	public int currentPage = 0;
	public int totalPage;
	private SVService service;

	@Autowired
	@Qualifier(value = "sVServiceImpl")
	public void setService(SVService service) {
		this.service = service;
	}

	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) service.countSV() / (double) perPage);
		return totalPage;
	}

	@RequestMapping(value = "/")
	public String redirectPage(HttpSession session, Model model) {
		if (session.getAttribute("page") != null) {
			currentPage = (int) session.getAttribute("page");
		}
		if (totalPage(perPage) < 1) {
			model.addAttribute("emptyStudent", "Rỗng");
			return "EmptySinhVien";
		}
		return "redirect:/list/" + currentPage;
	}

	@RequestMapping(value = "/list/{page}")
	public String listSV(Model model, @PathVariable("page") int page) {
		int start = (page - 1) * perPage;
		List<SinhVien> listsv = service.listSV(start, perPage);
		model.addAttribute("listsv", listsv);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		return "SinhVienList";
	}

	@RequestMapping(value = "/add")
	public String showFormAdd(Model model) {
		model.addAttribute("sv", new SinhVien());
		return "StudentFormAdd";
	}

	public String insertSV(@ModelAttribute("sv") SinhVien sv, BindingResult brs, Model model, HttpSession session,
			@RequestParam("file") MultipartFile file) {
		if (service.checkSV(sv.getId()) == false) {
			service.addSV(sv);
			model.addAttribute("page", totalPage(perPage));
		} else {
			if (LocaleContextHolder.getLocale().toString().equals("vi")) {
				model.addAttribute("message", "Id exist!");
			} else {
				model.addAttribute("message", "Id available");
			}
			return "SVFormAdd";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/edit/{maSV}")
	public String showFormEdit(@PathVariable Integer id, Model model) {
		SinhVien sv = service.getSVbyId(id);
		model.addAttribute("command", sv);
		return "SVFormUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateSV(@ModelAttribute("command") SinhVien sv, BindingResult brs) {
		if (brs.hasErrors()) {
			return "SVFormUpdate";
		}
		service.update(sv);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{maSV}")
	public String deleteStudent(@PathVariable Integer maSV, Model model, HttpSession session) throws SQLException {
		SinhVien sv = service.getSVbyId(maSV);
		service.deleteSV(sv.getId());
		deleteFile(sv.getAvatar(), session);
		if ((int) session.getAttribute("page") > totalPage(perPage)) {
			model.addAttribute("page", totalPage(perPage));
		}
		return "redirect:/";
	}

	private boolean deleteFile(String fileName, HttpSession session) {
		String path = session.getServletContext().getRealPath("/") + "\\resources\\upload\\";
		File file = new File(path, fileName);
		boolean result = file.delete();
		return result;
	}

	public String uploadFile(MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
		Date date = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("hhmmssddMMyyyy");
		String fileName = "";
		String path = session.getServletContext().getRealPath("/") + "\\resources\\upload\\";
		if (!file.isEmpty()) {
			fileName = fm.format(date) + "_" + file.getOriginalFilename();
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs();
			File fileSave = new File(dir, fileName);
			file.transferTo(fileSave);
		}
		return fileName;
	}
}
