package FFSE;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GiangVienChinh implements GiangVien {
	public String hoTen, email;

	public GiangVienChinh() {
		super();
	}

	public GiangVienChinh(String hoTen, String email) {
		super();
		this.hoTen = hoTen;
		this.email = email;
	}
	
	@Override
	public String thongTinGiangVien() {
		return "Giảng viên chính: " + hoTen + " - " + email + "\n";

	}
}
