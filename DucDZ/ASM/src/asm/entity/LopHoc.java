package asm.entity;

import java.util.List;

public class LopHoc {
	public String tenLopHoc;
	public HeDaoTao heDaoTao;
	public List<SinhVien> listSV;

	public LopHoc() {
		super();
	}

	public LopHoc(String tenLopHoc, HeDaoTao heDaoTao, List<SinhVien> listSV) {
		this.tenLopHoc = tenLopHoc;
		this.heDaoTao = heDaoTao;
		this.listSV = listSV;
	}

	public String infoLopHoc() {
		String lopHoc = "Lớp Học : " + tenLopHoc + "\n";
		lopHoc += heDaoTao.infoDaoTao();
		lopHoc += " Danh Sách Sinh Viên : \n";
		for (SinhVien sv : listSV) {
			lopHoc += sv.thongtinSV() + "\n";
		}
		return lopHoc;
	}
}
