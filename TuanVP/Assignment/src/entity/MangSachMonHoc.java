package entity;

import org.springframework.stereotype.Component;

@Component
public class MangSachMonHoc implements MonHoc {
	public String monHoc;
	public GiangVien giangVien;
	public MangSachMonHoc() {
		super();
	}

	public MangSachMonHoc(String monHoc) {
		super();
		this.monHoc = monHoc;
	}

	@Override
	public String mangSachDiHoc() {
		return "mang sách " + monHoc + " đi học --- ";
	}

}
