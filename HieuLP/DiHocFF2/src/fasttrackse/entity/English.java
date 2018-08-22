package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class English implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang sách tiếng anh đi học";
	}
}
