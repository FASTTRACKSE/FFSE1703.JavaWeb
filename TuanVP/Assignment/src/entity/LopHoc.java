package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LopHoc {
	public String lopHoc;
	public HeDaoTao heDaoTao;
	public HocKi hocKi;
	public List<MonHoc> monHoc;
	public List<SinhVien> sinhVien;

	public LopHoc() {

	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public HocKi getHocKi() {
		return hocKi;
	}

	public void setHocKi(HocKi hocKi) {
		this.hocKi = hocKi;
	}

	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}

	public List<SinhVien> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(List<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}

	public String thongTinLopHoc() {
		String st = lopHoc + ":\n";
		st += "  " + heDaoTao.thongTinHeDaoTao();
		st += "  Danh sách sinh viên: \n";
		for (SinhVien sv : sinhVien) {
			st += "    - " + sv.getHoTen() + "\n";
		}
		return st;
	}

}
