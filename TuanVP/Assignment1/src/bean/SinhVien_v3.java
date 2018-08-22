package bean;

import java.util.List;

public class SinhVien_v3 {
	public String hoTen;
	public HeDaoTao heDaoTao;
	public List<MonHoc> monHoc;

	public SinhVien_v3() {
		super();
	}
	
	public SinhVien_v3(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public String heDaoTao() {
		return heDaoTao.thongTinHeDaoTao();
	}

	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}

	public String mangSachDiHoc() {
		String sach = "Bạn "+hoTen+" : \n";
		sach+= heDaoTao.thongTinHeDaoTao()+"\n";
		for (MonHoc mH : monHoc) {
			sach += "- " + mH.mangSachDiHoc()+"\n";
		}
		return sach;
	}
}
