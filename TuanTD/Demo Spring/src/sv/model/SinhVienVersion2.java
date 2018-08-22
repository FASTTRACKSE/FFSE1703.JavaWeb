package sv.model;

import java.util.List;

public class SinhVienVersion2 {
	private String hoTen;
	List<MonHoc> monHoc;
	private HeDaoTao heDaoTao;

	public SinhVienVersion2(String hoTen) {
		// TODO Auto-generated constructor stub
		this.hoTen=hoTen;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public List<MonHoc> getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public String mangSachDiHoc() {
		String a="";
		for (MonHoc x : monHoc) {
			a=a+"\n"+x.mangSachDiHoc();
		}
		return a;
	}
	public String diHoc() {
		return "sinh viên tên: "+hoTen+"\n" + heDaoTao.heDaoTao()+"\n"+mangSachDiHoc()+"\n" ;
	}

}
