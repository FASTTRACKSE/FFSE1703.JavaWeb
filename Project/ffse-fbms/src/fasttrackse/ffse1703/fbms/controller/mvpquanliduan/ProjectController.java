package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Database;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Framework;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Language;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.StatusProject;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Technical;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.DatabaseServices;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.DomainService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.FrameworkService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.KhachHangService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.LanguageService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.ProjectService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.StatusService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.TechnicalService;
import fasttrackse.ffse1703.fbms.service.mvpquanliduan.VendorService;
import fasttrackse.ffse1703.fbms.service.security.PhongBanService;

@Controller
@RequestMapping("/mvpquanliduan/project")
@SessionAttributes({"khachHang","domain","technical","vendor","framework","database","status","framework","language","status","phongDuAn"})
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
	private LanguageService languageService;

	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value= "/list-project")
	public String listproject(Model model) {
		List<Projects> list = projectService.findAll();
		model.addAttribute("listProject", list);
		return "MvpQuanLiDuAn/project/listproject";
	}
	
	@RequestMapping("/show-form-add")
	public String showFormAdd(Model model) {
		model.addAttribute("command", new Projects());
		//model.addAttribute("khachHang", khachHangService.getAll());
		return "MvpQuanLiDuAn/project/addproject";
	}
	@RequestMapping(value= "detail-project/{id}")
	public String detailProject(Model model, @PathVariable String id) {
		
		Projects pr = projectService.findById(id);
		System.out.println("technical la"+pr.getDatabase());
		model.addAttribute("project", pr);
		return "MvpQuanLiDuAn/project/detailproject";
	}
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@Valid @ModelAttribute("command") Projects project, BindingResult result,
			final RedirectAttributes redirectAttributes, Model model) {
		
		//validation form 
//		if (result.hasErrors()) {
//			return "MvpQuanLiDuAn/project/addproject";
//		}
		//check trùng nameproject
//		int checkName= projectService.checkNameProjects(project.getNameProject());
//		if(checkName >=1) {
//			model.addAttribute("messageName", "Tên Du an đã được sử dụng");
//			return "MvpQuanLiDuAn/project/addproject";
//		}
//		int checkMa= projectService.checkMaProjects(project.getIdProject());
//		if(checkMa >=1) {
//			model.addAttribute("messageMa", "Mã Du an đã được sử dụng");
//			return "MvpQuanLiDuAn/project/addproject";
//		}
		
		System.out.println("name project la"+project.getNameProject());
		System.out.println("khách hàng là"+ project.getKhachHang());
		System.out.println("end date là"+ project.getEndDate());
		System.out.println("start date là"+ project.getStartDate());
		System.out.println("framework là"+ project.getFramework());
		System.out.println();
		project.setIsDelete(1);
		projectService.addNew(project);
		redirectAttributes.addFlashAttribute("success", "<script>alert('Thêm thành công');</script>");
		return "redirect: list-project";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Technical.class, "technical", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(technicalService.findById(text));
			}
		});
	
		binder.registerCustomEditor(Database.class, "database", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(databaseService.findById(text));
			}
		});
		binder.registerCustomEditor(Framework.class, "framework", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(frameworkService.getById(Integer.parseInt(text)));
			}
		});
		binder.registerCustomEditor(Language.class, "language", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(languageService.getById(Integer.parseInt(text)));
			}
		});
		binder.registerCustomEditor(Vendor.class, "vendor", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(vendorService.findById(text));
			}
		});
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
	@ModelAttribute("framework")
	public List<Framework> itemFramework(){
		return frameworkService.getAll();
	}
	@ModelAttribute("language")
	public List<Language> itemLanguage(){
		return languageService.getAll();
	}
	@ModelAttribute("status")
	public List<StatusProject> itemStatus(){
		return statusService.findAll();
	}
	@ModelAttribute("phongDuAn")
	public List<PhongBan> itemPhongDuAn(){
		return phongBanService.findAll();
	}
}
