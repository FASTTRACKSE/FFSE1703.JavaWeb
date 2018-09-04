package Spring.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Spring.Dao.Dao;
import Spring.entity.Emp;

@SessionAttributes("visitor")
@Controller
public class SinhVienController {
	@Autowired
	Dao dao;// will inject dao from xml file

	@RequestMapping("/")
	public String view(HttpSession session) {
		int id;
		if (session.getAttribute("pageIds") == null) {
			id = 1;
		} else {
			id = (int) session.getAttribute("pageIds");
		}
		return "redirect:/viewemp/" + id;

	}

	@RequestMapping("/viewemp/{pageid}")
	public ModelAndView viewemp(@PathVariable int pageid, Model model, HttpSession session) {
		double perPage = 2;
		double pageTotal = (int) Math.ceil(dao.countSV() / perPage);
		int start = (pageid - 1) * (int) perPage;
		List<Emp> list = dao.getEmployeesByPage(start, (int) perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal", pageTotal);
		session.setAttribute("pageIds", pageid);

		return new ModelAndView("viewemp", "list", list);
	}

	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView edit(@PathVariable int id,Model model) {
		Emp emp = dao.getEmpById(id);
		return new ModelAndView("empeditform", "command", emp); // "command" mặc định của spring frame work
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("command") Emp emp , Model model,HttpServletRequest request) {
		if (!emp.getMyFile().isEmpty()) {
			String nameFile = emp.getMyFile().getOriginalFilename();
			String dirFile = request.getServletContext().getRealPath("image");
			File fileDir = new File(dirFile);
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			try {
				emp.getMyFile().transferTo(new File(fileDir + File.separator + nameFile));
				System.out.println("Upload file thành công!");
				System.out.println(nameFile);
				model.addAttribute("filename", nameFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Upload file thất bại!");
			}
			emp.setNameFile(nameFile);
		}
		dao.update(emp);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/");// mặc định trở về trang index. đã đc định nghĩa ở web.xml
	}

	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform", "command", new Emp());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("command") @Valid Emp Emp, BindingResult rs,
			HttpServletRequest request, Model model) {
		if (rs.hasErrors()) {
			return "empform";
		} else {
			String nameFile = Emp.getMyFile().getOriginalFilename();
			if (!"".equals(nameFile)) {
				String dirFile = request.getServletContext().getRealPath("image");
				System.out.println(dirFile);
				File fileDir = new File(dirFile);
				if (!fileDir.exists()) {
					fileDir.mkdir();
				}
				try {
					Emp.getMyFile().transferTo(new File(fileDir + File.separator + nameFile));
					System.out.println("Upload file thành công!");
					System.out.println(nameFile);
					model.addAttribute("filename", nameFile);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Upload file thất bại!");
				}
				Dao.save(Emp,nameFile);
			}
		}
		return "redirect:/";
	}



}
