package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloWorld {
	@RequestMapping(value = { "/", "/home" })
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "index";
	}

	// send redirect
	// @RequestMapping("/redirect")
	// public String redirect() {
	// return "redirect:page2";
	// }
	//
	// @RequestMapping("/page2")
	// public String page2() {
	// return "page2";
	// }

	// VD Redirect truyền tham số
	@RequestMapping("/redirect")
	public RedirectView redirect(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("namepages", name);
		return new RedirectView("page2");

	}

	@RequestMapping("/page2")
	public String page2(@RequestParam("namepages") String name, ModelMap model) {
		model.addAttribute("name", name.toUpperCase());

		return "page2";

	}
}
