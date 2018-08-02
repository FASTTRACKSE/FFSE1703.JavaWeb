/*package fasttrackse.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sinhvien")
@Scope("prototype")
public class SinhVienVersion {
	
	private List<MonHoc> monHoc;
	private List<Lop> lopHoc;
	private List<HocKy> hocKy;
	private List<SinhVien> sinhVien;
	

	public List<SinhVien> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(List<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}
	public SinhVienVersion(String hoten) {
		this.hoTen = hoten;
		
	}

	public List<HocKy> getHocKy() {
		return hocKy;
	}

	public void setHocKy(List<HocKy> hocKy) {
		this.hocKy = hocKy;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}

	public List<Lop> getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(List<Lop> lopHoc) {
		this.lopHoc = lopHoc;
	}

	public SinhVienVersion() {
		super();
	}

	

	public String monHoc() {
		String kqua = "Ban " + hoTen + ":";

		for (Lop x : lopHoc) {
			kqua += "\n\t* " + x.lopHoc() + ":";

		}

		for (MonHoc x : monHoc) {
			kqua += "\n\t- " + x.monHoc() + x.giangVien();

		}

		
		 * for (HocKy x : hocKy) { kqua += "\n\t- " + x.hocKy();
		 * 
		 * }
		 
		return kqua;

	}
}
*/