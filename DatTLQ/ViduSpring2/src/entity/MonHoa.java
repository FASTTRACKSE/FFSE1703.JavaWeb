package entity;

import org.springframework.stereotype.Component;

@Component
public class MonHoa implements MonHoc {

	
	public String mangSachDiHoc() {
		// TODO Auto-generated method stub
		return "Mang sách Hóa đi học";
	}

	@Override
	public String giangVien() {
		// TODO Auto-generated method stub
		return "Thầy Nhân dạy ";
	}

	@Override
	public String hocKi() {
		// TODO Auto-generated method stub
		return "Học Kì I";
	}

	

}
