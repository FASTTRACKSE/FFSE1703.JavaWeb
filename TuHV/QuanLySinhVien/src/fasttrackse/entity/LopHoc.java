package fasttrackse.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LopHoc {
	private List<MonHoc> monHoc;
	private List<SinhVien> sinhVien;
	private String lopHoc;
	private HocKy hocKy;
	private HeDaoTao heDaoTao;
	public List<MonHoc> getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}
	public List<SinhVien> getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(List<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}
	public String getLopHoc() {
		return lopHoc;
	}
	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}
	public HocKy getHocKy() {
		return hocKy;
	}
	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public LopHoc() {
		
	}
	public String getLayDanhSach() {
		String kqua = "_***_"+lopHoc + ":\n";
		kqua +="\n " +"***"+ heDaoTao.getHocKy()+"***";
		kqua +="\n " +"*"+ hocKy.hocKy();
		
		kqua +="\n " + "DANH SÁCH MÔN HỌC :";
		for (MonHoc x : monHoc) {
			kqua += "\n\t* " + x.monHoc()+ x.giangVien() +".SĐT :"+ x.soDienThoai();
		}
		kqua +="\n " + "DANH SÁCH SINH VIÊN :";
		for (SinhVien x : sinhVien) {
			kqua += "\n\t* " + x.getHoTen();
		}
		return kqua;
		
	}
	

}
