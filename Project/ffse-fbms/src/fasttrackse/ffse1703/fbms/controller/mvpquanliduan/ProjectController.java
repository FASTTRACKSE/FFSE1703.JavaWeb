package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Database;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Framework;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Status;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Technical;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.DatabaseServices;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.DomainService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.FrameworkService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.KhachHangService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.LanguageService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.StatusService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.TechnicalService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.VendorService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/mvpquanliduan/project")
@SessionAttributes({"khachHang","domain","technical","vendor","framework","database","status"})
public class ProjectController {
	@Autowired
	private KhachHangService khachHangService;

	@Autowired
	private PhongBanService phongBanService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private DomainService domainService;

	@Autowired
	private TechnicalService technicalService;

	@Autowired
	private DatabaseServices databaseService;

	@Autowired
	private FrameworkService frameworkService;

	@Autowired
	private LanguageService LanguaService;

	@Autowired
	private VendorService vendorService;
	
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Projects());
		//model.addAttribute("khachHang", khachHangService.getAll());
		return "MvpQuanLiDuAn/project/addproject";
	}
	@ModelAttribute("khachHang")
	public List<KhachHang> itemKhachHang(){
		return  khachHangService.getAll();
	}
	@ModelAttribute("domain")
	public List<Domain> itemDomain(){
		return  domainService.findAll();
	}
	@ModelAttribute("technical")
	public List<Technical> itemTechnical(){
		return technicalService.findAll();
	}
	@ModelAttribute("vendor")
	public List<Vendor> itemVendor(){
		return vendorService.findAll();
	}
	
	@ModelAttribute("database")
	public List<Database> itemDatabase(){
		return databaseService.findAll();
	}
	@ModelAttribute("status")
	public List<Status> itemStatus(){
		return statusService.findAll();
	}
}
