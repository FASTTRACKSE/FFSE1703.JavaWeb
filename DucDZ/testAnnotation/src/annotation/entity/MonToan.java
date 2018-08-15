package annotation.entity;

import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc {
	public String mangSach() {
		return "mang sach Toan di hoc !";
	}

	@Override
	public String giangVien() {
		return "Thay giao day Toan !";
	}
}
