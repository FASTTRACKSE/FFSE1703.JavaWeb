package emtity;

import org.springframework.stereotype.Component;

@Component
public class MonHoa implements MonHoc {
	public String mangSachDiHoc() {
		return "mang sách Hóa đi học!";
	}
	public String giaoVien() {
		return "cô HỒNG";
	}
}
