package model;

import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang Sách Toán đi học";
	}

	
}
