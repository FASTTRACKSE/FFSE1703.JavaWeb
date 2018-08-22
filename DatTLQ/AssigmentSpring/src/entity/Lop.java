package entity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class Lop  {
	@Value("Đạt")
	private List<SinhVien> sinhVien;
	public List<MonHoc> monHoc;
	
	@Autowired
	@Qualifier("daoTaoDaiHan")
	public HeDaoTao heDaoTao;
	private String lop;
	private HocKiSV hocKi;
	
	public List<SinhVien> getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(List<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
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
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public HocKiSV getHocKi() {
		return hocKi;
	}
	public void setHocKi(HocKiSV hocKi) {
		this.hocKi = hocKi;
	}
	public void diHoc() {
		System.out.println(hocKi.hocKi());
		System.out.println(heDaoTao.chonKhoaHoc());
		for (SinhVien x: sinhVien) {
			System.out.println("Bạn " + x.tenSV());
		}
		System.out.println(lop);
		for (MonHoc monHoc: monHoc) {
			System.out.println(monHoc.diHoc());
		}
		
	}
	public Lop() {
		
	}
}
