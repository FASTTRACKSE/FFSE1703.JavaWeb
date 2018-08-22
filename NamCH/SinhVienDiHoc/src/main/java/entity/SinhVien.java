package entity;

import java.util.List;

public class SinhVien {
	private String tenSv;
	private List<MonHoc> monHoc;
	private HeDaoTao heDaoTao;
	
	public SinhVien(String tenSv) {
		this.tenSv=tenSv;
	}
	
	public String getTenSv() {
		return tenSv;
	}
	
	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
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
		return "Sinh Viên Tên : "+tenSv +"\n" + heDaoTao.hedaoTao()+"\n" +mangSachDiHoc();		
	}
}
