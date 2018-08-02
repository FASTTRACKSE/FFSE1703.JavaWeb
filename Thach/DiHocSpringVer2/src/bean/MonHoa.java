package bean;

import org.springframework.stereotype.Component;

@Component("monHoa")
public class MonHoa implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang sách Hóa đi học";
	}
	public String giangVien() {
		return "  - Cô Hồng";
	}
}
