package bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class Student {
	public String hoTen;
	private List<MonHoc> monHoc;
	@Autowired
	@Qualifier("khoaDaiHan")
	private KhoaHoc khoaHoc;
	
	public Student() {
		//
	}
	
	public Student(String hoTen) {
		this.hoTen = hoTen;
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
	
	public KhoaHoc getKhoaHoc() {
		return khoaHoc;
	}
	
	public void setKhoaHoc(KhoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;
	}
	
	public void diHoc() {
		System.out.println("Bạn " + hoTen);
		System.out.println(khoaHoc.chonKhoaHoc());
		for(MonHoc x: monHoc) {
			System.out.println(x.giangVien()+" :");
			System.out.println("           -" + x.mangSachDiHoc());
		}
	}
}
