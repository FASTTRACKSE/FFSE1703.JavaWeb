package vn.model;

import org.springframework.stereotype.Component;

@Component
public class HocKy1 implements HocKy {
	public HocKy1() {
		super();
	}
	public String getTenHocKy() {
		 return " Học kỳ 1";
	 }
}
