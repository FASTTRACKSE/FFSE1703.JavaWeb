package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LopHoc {
	public String tenLopHoc;
	public HeDaoTao heDaoTao;
	public List<SinhVien> sinhVien;

	public LopHoc(String tenLopHoc, HeDaoTao heDaoTao, List<SinhVien> sinhVien) {
		this.tenLopHoc = tenLopHoc;
		this.heDaoTao = heDaoTao;
		this.sinhVien = sinhVien;
	}


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

	public String thongTinLopHoc() {
		String st = "Lớp học:" + tenLopHoc + "\n";
		st += heDaoTao.thongTinHeDaoTao();
		st += " Danh sách sinh viên: \n";
		for (SinhVien sV : sinhVien) {
			st += sV.thongTin() + "\n";
		}
		st += "\n ================================================== \n";
		return st;

	}
}
