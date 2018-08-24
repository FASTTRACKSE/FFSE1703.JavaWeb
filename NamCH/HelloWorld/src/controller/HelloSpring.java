package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpring {
	@RequestMapping("/welcome")
	public ModelAndView helloW() {
		return new ModelAndView("welcome");
		
	}
}
