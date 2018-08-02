package SinhVien.entity;
import org.springframework.stereotype.Component;

@Component
public class MonJavaWeb implements MonHoc {
	public String mangSachDiHoc() {
		return " Môn JavaWeb :";
		
	}

	@Override
	public String tenGiangVien() {
		
		return " do thầy Thành dạy";
	}
}
