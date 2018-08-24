package annotation.entity;

import org.springframework.stereotype.Component;

@Component
public class MonLy implements MonHoc {
	public String mangSach() {
		return "mang sach Ly di hoc !";
	}

	@Override
	public String giangVien() {
		return "Thay giao day Ly !";
	}
}
