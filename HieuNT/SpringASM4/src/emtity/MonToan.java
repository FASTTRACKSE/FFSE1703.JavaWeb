package emtity;

import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc {
	public String mangSachDiHoc() {
		return "JAVA SPRING!-";
	}
	public String giaoVien() {
		return "THẦY QUANG";
	}
}
