package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class JavaWeb implements MonHoc{

	@Override
	public String chonMonHoc() {
		return "JavaWeb - Cô Thủy";
	}

}
