package SinhVien.entity;
import org.springframework.stereotype.Component;

@Component
public class MonNhapMon implements MonHoc{

	@Override
	public String mangSachDiHoc() {
		// TODO Auto-generated method stub
		return "Nhập môn:";
	}

	@Override
	public String tenGiangVien() {
		// TODO Auto-generated method stub
		return " do thầy Lâm dạy";
	}

}
