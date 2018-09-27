package fasttrackse.ffse1703.fbms.controller.qlynhiemvuhieulp;

import java.io.IOException;
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

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;
import fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp.QLyNhiemVuService;

@Controller
@RequestMapping("/HieuLP")
public class QLyNhiemVuController {
	private int perPage = 10;
	@Autowired
	private QLyNhiemVuService qLyNhiemVuService;

	@RequestMapping(value = "/view/{ID}", method = RequestMethod.GET)
	public String viewOneChucDanh(@PathVariable("ID") int id, Model model) {
		model.addAttribute("nv", qLyNhiemVuService.findById(id));
		return "QuanLyNhiemVuHieuLP/viewOne";
	}

	// @RequestMapping(value = {"/","/danhsach"})
	// public String danhSach(Model model ) {
	//
	// model.addAttribute("danhsach",qLyNhiemVuService.getAll());
	// return "QuanLyNhiemVuHieuLP/list";
	// }

	@RequestMapping("/")
	public String view(HttpSession session) {
		int currentPage;
		if (session.getAttribute("page") == null) {
			currentPage = 1;
		} else {
			currentPage = (int) session.getAttribute("page");
		}
		return "redirect:/HieuLP/danhsach/" + currentPage;
	}

	@RequestMapping(value = "/danhsach/{page}")
	public String listCustomer(Model model, @PathVariable("page") int page, HttpServletRequest request) {
		// search = " and duAn.maDuan = ??? and nhanVien.maNhanVien = ??? and idLoaiTrangthai.IDtrangthai = ???"
		String maDuanSearch = " and duAn.maDuan = " + request.getParameter("maDuan");
		if (request.getParameter("maDuan") == null || request.getParameter("maDuan").equals("0")) {
			maDuanSearch = "";
		}
		String maNhanVienSearch = " and nhanVien.maNhanVien = " + request.getParameter("maNhanVien");
		if (request.getParameter("maNhanVien") == null || request.getParameter("maNhanVien").equals("0")) {
			maNhanVienSearch = "";
		}
		String IDtrangthaiSearch = " and idLoaiTrangthai.IDtrangthai = " + request.getParameter("IDtrangthai");
		if (request.getParameter("IDtrangthai") == null || request.getParameter("IDtrangthai").equals("0")) {
			IDtrangthaiSearch = "";
		}
		String search = maDuanSearch + maNhanVienSearch + IDtrangthaiSearch;
		
		int start = (page - 1) * perPage;
		List<QLyNhiemVuEntity> list = qLyNhiemVuService.findAll(start, perPage, search);
		model.addAttribute("list", list);
		model.addAttribute("total", totalPage(perPage));
		model.addAttribute("page", page);
		model.addAttribute("trangthai", qLyNhiemVuService.trangThai());
		model.addAttribute("duan", qLyNhiemVuService.duAn());
		model.addAttribute("nhanVienHLP", qLyNhiemVuService.nhanVienHLP());
		return "QuanLyNhiemVuHieuLP/list";
	}

	public int totalPage(int perPage) {
		int totalPage = (int) Math.ceil((double) qLyNhiemVuService.count() / (double) perPage);
		return totalPage;
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpServletRequest request, Model model) {
		QLyNhiemVuEntity entity = qLyNhiemVuService.findById(id);
		entity.setIsDelete(0);
		qLyNhiemVuService.delete(entity);
		return "redirect:/HieuLP/danhsach/1";
	}

	@RequestMapping(value = "/create")
	public String showForm(Model model) {
		model.addAttribute("add", new QLyNhiemVuEntity());
		model.addAttribute("congviec", qLyNhiemVuService.congViec());
		model.addAttribute("duan", qLyNhiemVuService.duAn());
		model.addAttribute("nhanVienHLP", qLyNhiemVuService.nhanVienHLP());
		return "QuanLyNhiemVuHieuLP/create";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createNhiemVu(Model model, @ModelAttribute("add") @Valid QLyNhiemVuEntity nv,
			HttpServletRequest request, BindingResult bindingResult) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "create";
		}
		;
		nv.setIsDelete(1);
		qLyNhiemVuService.add(nv);
		return "redirect:/HieuLP/danhsach/1";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("duAn", qLyNhiemVuService.findById(id));
		model.addAttribute("trangthai", qLyNhiemVuService.trangThai());
		model.addAttribute("congviec", qLyNhiemVuService.congViec());
		return "/QuanLyNhiemVuHieuLP/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("edit") @Valid QLyNhiemVuEntity nv, HttpServletRequest request)
			throws IllegalStateException, IOException {
		nv.setIsDelete(1);
		qLyNhiemVuService.update(nv);
		return "redirect:/HieuLP/danhsach/1";
	}
}
