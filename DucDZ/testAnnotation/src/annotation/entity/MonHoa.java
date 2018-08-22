package annotation.entity;

import org.springframework.stereotype.Component;

@Component
public class MonHoa implements MonHoc {
	public String mangSach() {
		return "mang sach Hoa di hoc !";
	}

	@Override
	public String giangVien() {
		return "Thay giao day Hoa !";
	}
}
