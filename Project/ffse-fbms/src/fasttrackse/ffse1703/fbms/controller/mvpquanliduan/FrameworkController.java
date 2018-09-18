package fasttrackse.ffse1703.fbms.controller.mvpquanliduan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.mvpquanliduan.FrameworkService;
@Controller
@RequestMapping("/mvpquanliduan/framework")
public class FrameworkController {
	@Autowired
	private FrameworkService frameworkService;
}
