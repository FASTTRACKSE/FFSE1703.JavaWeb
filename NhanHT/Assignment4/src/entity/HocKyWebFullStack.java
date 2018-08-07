package entity;

import org.springframework.stereotype.Component;

@Component
public class HocKyWebFullStack implements HocKy {

	public HocKyWebFullStack() {
		super();
	}
	@Override
	public String hocKy() {
		String tenHocKy = "Web Fullstack Development";
		return tenHocKy;
	}
}
