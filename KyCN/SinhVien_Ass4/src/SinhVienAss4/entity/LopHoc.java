package SinhVienAss4.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;




@Component

public class LopHoc {
	public String tenLopHoc;
	public HeDaoTao heDaoTao;
	public List<SinhVienAss4> sinhVien;
	public LopHoc() {
		super();
	}

	public LopHoc(String tenLopHoc, HeDaoTao heDaoTao, List<SinhVienAss4> sinhVien) {
		super();
		this.tenLopHoc = tenLopHoc;
		this.heDaoTao = heDaoTao;
		this.sinhVien = sinhVien;
	}
	
	
	public String getLop() {
		String st = "Lớp h�?c:" + tenLopHoc + "\n";
		st += heDaoTao.heDaoTao();
		st+=" Danh sách sinh viên: \n";
		for (SinhVienAss4 sV : sinhVien) {
			st += sV.thongTinSinhVien()+"\n";
		}
		st+= "\n ================================================== \n";
		return st;
	}
}
