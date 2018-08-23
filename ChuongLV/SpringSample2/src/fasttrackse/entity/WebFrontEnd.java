package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class WebFrontEnd implements MonHoc{

	@Override
	public String chonMonHoc() {
		return "Web Front-End - Thầy Chương";
	}

}