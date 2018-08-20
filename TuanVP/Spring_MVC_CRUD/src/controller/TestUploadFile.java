package controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestUploadFile {
	@RequestMapping("/test")
	public String loadFile() {
		return "TestUpload";
	}

	@RequestMapping("/upload")
	public @ResponseBody String uploadFile(@RequestParam("avatar") MultipartFile file) {
		
		String result = "----------"+System.currentTimeMillis()+"--------------\n";
		try {
			String fileName = file.getOriginalFilename();
			File fileUpload = new File("E:\\FFSE1703.JavaWeb\\TuanVP\\Spring_MVC_CRUD\\WebContent\\WEB-INF\\resource\\upload", fileName);
			file.transferTo(fileUpload);
			result += "Name: "+ fileName;
		} catch (Exception e) {
			e.printStackTrace();
			result += "Upload fail";
		}
		return result;
	}
}
