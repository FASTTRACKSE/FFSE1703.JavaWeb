package fasttrackse.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("lopHoc")
@Scope("prototype")
public class LopHoc {
	private String lopHoc;
	private List<MonHoc> monHoc;
	private List<SinhVien> sinhVien;
	private HeDaoTao heDaoTao;
	private HocKy hocKy;
	public LopHoc() {
		super();
	}
	public LopHoc(String lopHoc) {
		super();
		this.lopHoc = lopHoc;
	}

	public LopHoc(String lopHoc, HeDaoTao heDaoTao) {
		super();
		this.lopHoc = lopHoc;
		this.heDaoTao = heDaoTao;
	}
	public String getLopHoc() {
		return lopHoc;
	}
	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
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
	public List<SinhVien> getSinhVien() {
		return sinhVien;
	}
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public HocKy getHocKy() {
		return hocKy;
	}
	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}
	public String mangSachDiHoc() {
	String result =  lopHoc + " " ;
		result += "\n\t- " + "+" + heDaoTao.getDaoTao();
		result += "\n" + "     " + hocKy.getHocKy() + "gồm các môn:" ;
		for(MonHoc x : monHoc) {
			result +=  "\n\t- " + x.getMonHoc() ;
		} 
		result += "\n" + "     Danh sách sinh viên: ";
		for(SinhVien x : sinhVien) {
			result +=   "\n\t- " + x.getHoTen();
			}
		return result;
		
	}
	
	
}
