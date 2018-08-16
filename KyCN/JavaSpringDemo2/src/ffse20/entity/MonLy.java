package ffse20.entity;
import org.springframework.stereotype.Component;

@Component
public class MonLy implements MonHoc {
	public String mangSachDiHoc() {
		return " mang sách Lý đi học";
		
	}

	@Override
	public String tenGiangVien() {
		
		return " ,do thầy Thành dạy";
	}
}
