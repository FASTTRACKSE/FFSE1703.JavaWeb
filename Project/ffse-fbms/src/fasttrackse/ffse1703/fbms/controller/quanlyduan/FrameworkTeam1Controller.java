package fasttrackse.ffse1703.fbms.controller.quanlyduan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.quanlyduan.FrameworkTeam1Service;

@Controller
@RequestMapping("/qlda/Framework")
public class FrameworkTeam1Controller {
	@Autowired
	FrameworkTeam1Service frameworkService;

	

}
