package fasttrackse.ffse1703.fbms.controller.qlynhiemvuhieulp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;
import fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp.DatatableServiceCV;
import fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp.QLyNhiemVuService;




@Controller
@RequestMapping("QuanLyNhiemVuHieuLP")
public class QLyNhiemVuController {
	@Autowired
	private QLyNhiemVuService qLyNhiemVuService;
	
	@Autowired
	private DatatableServiceCV datatableServiceCV;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewChucDanh(Model model) {
		return "QuanLyNhiemVuHieuLP/list";
	}
	
	
}
