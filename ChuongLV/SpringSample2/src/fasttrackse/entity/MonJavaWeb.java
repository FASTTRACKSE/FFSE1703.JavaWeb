package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonJavaWeb implements MonHoc{

	@Override
	public String chonMonHoc() {
		return "JavaWeb - Cô Thủy";
	}

}