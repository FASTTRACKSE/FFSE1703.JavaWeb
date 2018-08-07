package vn.model;

import org.springframework.stereotype.Component;

@Component
public class HocKy2 implements HocKy {
	public HocKy2() {
		super();
	}
	public String getTenHocKy() {
		 return " Học kỳ 2";
	 }
}
