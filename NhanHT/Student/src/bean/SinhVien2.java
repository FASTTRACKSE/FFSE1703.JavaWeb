package bean;

import java.util.ArrayList;

public class SinhVien2 {
	public String hoTen;
	public HeDaoTao heDaoTao;
	public MonHoc monHoc;
	ArrayList<HeDaoTao> arrHeDaoTao = new ArrayList<>();
	ArrayList<MonHoc> arrMonHoc = new ArrayList<>();
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public SinhVien2() {
		
	}
	public ArrayList<MonHoc> getMonHoc() {
		return arrMonHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.arrMonHoc.add(monHoc);
	}
	
	public ArrayList<HeDaoTao> getHeDaoTao() {
		return arrHeDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.arrHeDaoTao.add(heDaoTao);
	}
	public void heDaoTao() {
		System.out.print(hoTen);
		for(HeDaoTao x: arrHeDaoTao) {
			System.out.println(" "+x.heDaoTao());
		}
	}
	public void mangSachDiHoc() {
		for(MonHoc x: arrMonHoc) {
			System.out.println(" "+x.mangSachDiHoc());
		}
	}
}
