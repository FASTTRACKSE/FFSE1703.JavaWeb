package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping(value = "/quantridanhgia")
public class QuanTriDanhGiaController {
	public UserAccountService accountService;

	@Autowired
	@Qualifier(value = "userAccountServiceImpl")
	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("")
	public String redirectPage(Authentication auth, HttpSession session) {
		String page = "";
		if (!auth.isAuthenticated()) {
			page = "redirect:/login";
		} else {
			String username = auth.getName();
			UserAccount user = accountService.loadUserByUsername(username);
			HoSoNhanVien hoSo = user.getNhanVien();
			session.setAttribute("chucDanh", hoSo.getChucDanh());
			session.setAttribute("nhanVien", hoSo.getMaNhanVien());
			if (hoSo.getPhongBan().equals("PNS") && hoSo.getChucDanh().equals("NV")) {
				page = "redirect:/quantridanhgia/phongnhansu";
			} else if (!hoSo.getChucDanh().equals("NV")) {
				page = "redirect:/quantridanhgia/truongphong";
			} else {
				page = "redirect:/quantridanhgia/nhanvien";
			}
		}
		return page;
	}
}
