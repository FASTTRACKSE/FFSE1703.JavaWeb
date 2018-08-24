package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("lopHoc")
public class LopHoc {
	public String tenLopHoc;
	public HeDaoTao heDaoTao;
	public List<SinhVien> sinhVien;

	public String getTenLopHoc() {
		return tenLopHoc;
	}

	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public List<SinhVien> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(List<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}

	public LopHoc() {
		super();
	}

	public String thongTinLopHoc() {
		/*
		 * String result = "Bạn " + hoTen + ": "; result += "\n" + heDaoTao.getGioHoc();
		 * 
		 * for (MonHoc x : monHoc) { result += "\n\t- " + x.mangSachDiHoc()+" "+
		 * x.giaoVien(); }
		 * 
		 * return result;
		 */
		String result = "Lớp: ";
		result += tenLopHoc;
		result += "\n" + heDaoTao.getGioHoc() + "\n";
		result += "DANH SÁCH SINH VIÊN  \n";

		for (SinhVien y : sinhVien) {
			result += y.danhSachSinhVien();
		}
		return result;

	}

}
