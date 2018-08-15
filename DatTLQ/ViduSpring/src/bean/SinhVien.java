package bean;

import java.util.List;

public class SinhVien {
	private String hoTen;
	public List<MonHoc> monHoc;
	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}
	public HeDaoTao heDaoTao;
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	
	
	public SinhVien() {
		//
	}

	public SinhVien(String hoTen) {
		super();
		this.hoTen = hoTen;
	}
	public void mangSachDiHoc() {
		System.out.println("Bạn"+hoTen+":");
		System.out.println(heDaoTao.chonKhoaHoc());
		for(MonHoc monHoc:monHoc) {
			System.out.println("-"+monHoc.mangSachDiHoc());
		}
	}
}
