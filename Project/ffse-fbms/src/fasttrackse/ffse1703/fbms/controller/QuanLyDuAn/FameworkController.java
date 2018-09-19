package fasttrackse.ffse1703.fbms.controller.QuanLyDuAn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.QuanLyDuAn.FrameworkService;

@Controller
@RequestMapping("/qlda/Framework")
public class FameworkController {
	@Autowired
	FrameworkService frameworkService;

	

}
