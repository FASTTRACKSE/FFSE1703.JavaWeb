package entity;

import java.util.List;

public class LopHoc {
	private String tenLop;
	private List<SinhVien> sinhVien;
	private HeDaoTao heDaoTao;
	private HocKy hocKy;
//	private List<MonHoc> monHoc;
//	private List<GiangVien> giangVien;
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public List<SinhVien> getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(List<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public HocKy getHocKy() {
		return hocKy;
	}
	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}
//	public List<MonHoc> getMonHoc() {
//		return monHoc;
//	}
//	public void setMonHoc(List<MonHoc> monHoc) {
//		this.monHoc = monHoc;
//	}
//	public List<GiangVien> getGiangVien() {
//		return giangVien;
//	}
//	public void setGiangVien(List<GiangVien> giangVien) {
//		this.giangVien = giangVien;
//	}
//	public void inThongTin() {
//		System.out.println("Lớp "+tenLop);
//		System.out.println("\t+"+heDaoTao.getTenHeDaoTao());
//		System.out.println("\t+"+hocKy.getTenHocKy());
//		for (int i=0;i<monHoc.size();i++) {
//			System.out.println("\t\t-"+monHoc.get(i).getTenMonHoc() + " - "+ giangVien.get(i).getTenGiangVien()+" ");
//		}
//		System.out.println("\t+Danh sách sinh viên");
//		for (SinhVien x : sinhVien) {
//			System.out.println("\t\t-"+x.getTenSv());			
//		}
//	}
	public void inThong() {
		System.out.println(tenLop);
		System.out.println("\t+"+heDaoTao.getTenHeDaoTao());
		System.out.println("\t+"+hocKy.getTenHocKy());
		System.out.println("\t+Danh sách sinh viên");
		for (SinhVien x : sinhVien) {
			System.out.println("\t\t-"+x.getTenSv());			
		}
	}
}
