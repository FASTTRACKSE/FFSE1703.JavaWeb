package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonJavaCore implements MonHoc{

	@Override
	public String chonMonHoc() {
		return "JavaCore - Thầy Thắng";
	}

}