package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LopHoc {
	public String tenLopHoc;
	public HeDaoTao heDaoTao;
	public List<SinhVien> sinhVien;

	public LopHoc() {
		super();
	}

	public LopHoc(String tenLopHoc, HeDaoTao heDaoTao, List<SinhVien> sinhVien) {
		super();
		this.tenLopHoc = tenLopHoc;
		this.heDaoTao = heDaoTao;
		this.sinhVien = sinhVien;
	}

	public String thongTinLopHoc() {
		String st = "Lớp học:" + tenLopHoc + "\n";
		st += heDaoTao.khoaDaoTao();
		st+=" Danh sách sinh viên: \n";
		for (SinhVien sV : sinhVien) {
			st += sV.ttSinhVien()+"\n";
		}
		return st;

	}
}
