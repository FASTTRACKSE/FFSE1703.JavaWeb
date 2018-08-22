package bean;

import java.util.ArrayList;

public class LopHoc {
	private String tenLop;
	private HeDaoTao heDaoTao;
	private ArrayList <SinhVien> arrSv;
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public ArrayList<SinhVien> getArrSv() {
		return arrSv;
	}
	public void setArrSv(ArrayList<SinhVien> arrSv) {
		this.arrSv = arrSv;
	}
	public void inThongTin() {
		System.out.println(tenLop);
		System.out.println(heDaoTao.heDaoTao());
		System.out.println("Danh sách sinh viên");
		for(SinhVien x: arrSv) {
			System.out.println(x.getHoTen()+x.getEmail()+x.getDiachi()+x.getSdt());
		}
	}
}
