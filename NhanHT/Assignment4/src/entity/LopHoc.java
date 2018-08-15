package entity;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LopHoc {
	private String tenLop;
	private HeDaoTaoSV heDaoTaoSV;
	public ArrayList<SinhVien> sinhVien = new ArrayList<>();

	public LopHoc(String tenLop, HeDaoTaoSV heDaoTaoSV, ArrayList<SinhVien> sinhVien) {
		super();
		this.tenLop = tenLop;
		this.heDaoTaoSV = heDaoTaoSV;
		this.sinhVien = sinhVien;
	}

	public ArrayList<SinhVien> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(ArrayList<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}

	public LopHoc() {
		
	}
	public HeDaoTaoSV getHeDaoTaoSV() {
		return heDaoTaoSV;
	}
	public void setHeDaoTaoSV(HeDaoTaoSV heDaoTaoSV) {
		this.heDaoTaoSV = heDaoTaoSV;
	}

	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public void inThongTin() {
		System.out.println("-----------------------------------");
		System.out.println(tenLop);
		System.out.println(heDaoTaoSV.heDaoTao());
		System.out.println("Danh Sách Sinh Viên: ");
		for(SinhVien x: sinhVien) {
			System.out.println("\t"+x.getHoTen()+" - "+x.getDiaChi()+" - "+x.getEmail()+" - "+ x.getDienThoai());
		}
	}
}
