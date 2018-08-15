package entity;

import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc {

	public String mangSachDiHoc() {
		
		return "Mang sách Toán đi học";
	}
	
	public String giangVien() {
		
		return "Thầy Thành dạy ";
	}	

	@Override
	public String hocKi() {
		
		return "Học Kì I";
	}

}
