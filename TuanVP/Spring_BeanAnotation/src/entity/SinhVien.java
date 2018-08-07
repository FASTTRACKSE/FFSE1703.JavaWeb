package entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SinhVien {
	public String hoTen;
	@Autowired
	@Qualifier("daoTaoDaiHan")
	public HeDaoTao heDaoTao;

	public List<MonHoc> monHoc;
	public HocKi hocKi;
	public GiangVien giangVien;

	public SinhVien() {
		super();
	}

	public SinhVien(String hoTen) {
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

	public HocKi getHocKi() {
		return hocKi;
	}

	public void setHocKi(HocKi hocKi) {
		this.hocKi = hocKi;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public String mangSachDiHoc() {
		String sach = "Bạn " + hoTen + " : \n";
		sach += heDaoTao.thongTinHeDaoTao() + "\n";
		for (MonHoc mH : monHoc) {
			sach += "- " + mH.mangSachDiHoc() + "\n";
		}
		return sach;
	}
}
