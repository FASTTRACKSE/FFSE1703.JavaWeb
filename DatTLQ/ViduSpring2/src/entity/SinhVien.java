package entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class SinhVien {
	@Value("Đạt")
	private String hoTen;
	public List<MonHoc> monHoc;
	
	@Autowired
	@Qualifier("daoTaoDaiHan")
	public HeDaoTao heDaoTao;
	public ClassSV classSV;
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
	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
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
			System.out.println("-"+monHoc.mangSachDiHoc() +  " "+ monHoc.giangVien());
		}
		
	}
}
