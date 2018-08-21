package entity;

import java.util.List;

public class SVVersion3 {
	private String hoTen;
	private HeDaoTao heDaoTao;

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

	public List<MonHoc> getListMonHoc() {
		return listMonHoc;
	}

	public void setListMonHoc(List<MonHoc> listMonHoc) {
		this.listMonHoc = listMonHoc;
	}

	public List<MonHoc> listMonHoc;

	public SVVersion3(String hoTen) {

		this.hoTen = hoTen;
	}

	public SVVersion3() {

	}

	public void mangSachDiHoc() {
		
		
		System.out.println("Bạn " + hoTen + " " );
		System.out.println(heDaoTao.chonKhoaHoc());
		for (MonHoc monHoc : listMonHoc) {
		System.out.println("-"+monHoc.mangSachDiHoc());	
		}
		
	}

	
}
