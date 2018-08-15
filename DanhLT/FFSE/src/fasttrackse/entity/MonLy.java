package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonLy implements MonHoc, GiangVien{
	public String mangSachDiHoc() {
		return "Mang SÃ¡ch LÃ½ Ä‘i há»�c";
	}
	

	public String giaovien() {
			return "Của giảng viên Thành";
		}
}
