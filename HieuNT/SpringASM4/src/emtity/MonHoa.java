package emtity;

import org.springframework.stereotype.Component;

@Component
public class MonHoa implements MonHoc {
	public String mangSachDiHoc() {
		return "JAVA CORE!-";
	}
	public String giaoVien() {
		return "CÔ THỦY";
	}
}
