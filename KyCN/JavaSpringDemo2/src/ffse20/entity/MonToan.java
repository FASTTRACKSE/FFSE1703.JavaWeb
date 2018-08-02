package ffse20.entity;
import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc {
	public String mangSachDiHoc() {
		return " mang sách Toán đi học";
	}


	public String tenGiangVien() {
		// TODO Auto-generated method stub
		return " ,do thầy Thắng dạy";
	}
}
