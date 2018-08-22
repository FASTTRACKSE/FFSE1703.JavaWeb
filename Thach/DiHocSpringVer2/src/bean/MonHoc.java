package bean;

import java.awt.List;

import org.springframework.stereotype.Component;

@Component
public interface MonHoc {
	private List<MonHoc> monHoc = new List();
		public String mangSachDiHoc();
		public String giangVien();
	}
		
