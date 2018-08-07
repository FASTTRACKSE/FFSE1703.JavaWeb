package entity;

import org.springframework.stereotype.Component;

@Component
public class HocKiSV implements HocKy {
	private String hocKi;
	public HocKiSV() {
		
	}
	public  HocKiSV (String hocKi) {
		this.hocKi= hocKi;
	}


	public String hocKi() {
		
		return  hocKi;
	}

}
