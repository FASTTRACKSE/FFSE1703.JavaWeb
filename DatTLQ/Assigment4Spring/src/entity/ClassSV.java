package entity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class ClassSV {
	@Value("Đạt")
	private List<SinhVien> sinhVien;
	
	@Autowired
	@Qualifier("daoTaoDaiHan")
	public HeDaoTao heDaoTao;
	private String lop;
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
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public ClassSV() {
		System.out.println(lop);
		System.out.println(heDaoTao.chonKhoaHoc());
		for (SinhVien x: sinhVien) {
			System.out.println("Bạn " + x.inforSV());
		}
	}
	
}
