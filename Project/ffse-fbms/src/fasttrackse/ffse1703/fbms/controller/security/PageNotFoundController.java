package fasttrackse.ffse1703.fbms.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageNotFoundController {
	@RequestMapping("/403")
	public String pageNotAllow() {
		return "QuanTriHeThong/error-403";
	}
	@RequestMapping("/404")
	public String pageNotFound() {
		return "QuanTriHeThong/error-404";
	}
	@RequestMapping("/home")
	public String pageDemo() {
		return "QuanTriHeThong/home";
	}
}