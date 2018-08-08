package ffse20.entity;

import org.springframework.stereotype.Component;

@Component
public class MonHoa implements MonHoc{
	public String mangSachDiHoc() {
		return " mang sách Hóa đi học";
		
	}

	@Override
	public String tenGiangVien() {
		// TODO Auto-generated method stub
		return  " ,do thầy Lâm dạy";
	}
}
