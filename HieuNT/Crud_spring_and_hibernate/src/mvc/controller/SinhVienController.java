package mvc.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mvc.entity.Student;
import mvc.service.SinhVienService;

@Controller
public class SinhVienController {
	private int perPage = 2;
	private SinhVienService sinhVienService;

	@Autowired
	public void setSinhVienService(SinhVienService sinhVienService) {
		this.sinhVienService = sinhVienService;
	}

	@RequestMapping("/")
	public String view(HttpSession session) {
		int currentPage;
		if (session.getAttribute("page") == null) {
			currentPage = 1;
		} else {
			currentPage = (int) session.getAttribute("page");
		}
		return "redirect:/list/" + currentPage;
	}

	@RequestMapping(value = "/list/{page}")
	public String listCustomer(Model model, @PathVariable("page") int page) {
		int start = (page - 1) * perPage;
		List<Student> list = sinhVienService.findAll(start, perPage);
		model.addAttribute("list", list);
		model.addAttribute("total", totalPage(perPage));
		model.addAttribute("page", page);
		return "list";
	}

	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) sinhVienService.count() / (double) perPage);
		return totalPage;
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("command") @Valid Student p, BindingResult rs,HttpServletRequest request
			, Model model,HttpSession session, @RequestParam("myFile") MultipartFile myFile ) {
		if (rs.hasErrors()) {
			return "add";
		} else {
			String nameFile = myFile.getOriginalFilename();
			System.out.println(nameFile);

			if (!"".equals(nameFile)) {
				String dirFile = request.getServletContext().getRealPath("image");
				System.out.println(dirFile);
				File fileDir = new File(dirFile);
				if (!fileDir.exists()) {
					fileDir.mkdir();
				}
				try {
					myFile.transferTo(new File(fileDir + File.separator + nameFile));
					System.out.println("Upload file thành công!");
					System.out.println(nameFile);
					p.setNameFile(nameFile);

					model.addAttribute("filename", nameFile);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Upload file thất bại!");
				}
				sinhVienService.addSV(p);
			}
		}
		
		return "redirect:/";
		
//		if (rs.hasErrors()) {
//			return "add";
//		} else {
//			sinhVienService.addSV(p);
//		Dao.save(Emp,nameFile);
//			return "redirect:/";
//		}
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("command", new Student());
		return "add";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		sinhVienService.deleteSinhVien(id);
		return "redirect:/";
	}

	@RequestMapping("/getID/{id}")
	public String getID(@PathVariable("id") int id, Model model) {
		model.addAttribute("command", sinhVienService.getSinhVienByID(id));
		return "edit";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute("command") Student p, Model model) {
		sinhVienService.updateSV(p);
		return "redirect:/";
	}
}
