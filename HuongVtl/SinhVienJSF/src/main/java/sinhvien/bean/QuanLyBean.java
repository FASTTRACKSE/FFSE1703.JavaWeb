package sinhvien.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import sinhvien.service.Paginator;
import sinhvien.service.SinhVien;
import sinhvien.service.SinhVienDB;

@ManagedBean
@SessionScoped
public class QuanLyBean {
	public ArrayList<?> sv;
	private String  hoTen, gioiTinh, email, diaChi, lop, sdt, namSinh;
	private int id;
	@ManagedProperty(value= "#{paginator}")
	Paginator paginator;
	
	//phan trang
	public Paginator getPaginator() {
		return paginator;
		
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
	
	public void next() {
		paginator.next();
		sv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
	}
	
	public void prev() {
		paginator.prev();
		sv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
		
	}
	
	public void first() {
		paginator.first();;
		sv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
	}
	
	public void last() {
		paginator.last();
		sv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String themSV() {
		return "ThemSV";
	}
	public String add() {
		SinhVien sv = new SinhVien(this.hoTen, this.gioiTinh, this.email, this.diaChi, this.lop, this.sdt, this.namSinh);
		int kiemTra=SinhVienDB.themSV(sv);
		if (kiemTra>0) {
			return "index";
		}
		else {
			return "ThemSV";
		}
		
		
	}
	@PostConstruct
	public void init() {
		double tongSv = SinhVienDB.countStudent();
		paginator.pagination(tongSv);
		this.sv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
	}
	
	
	public String editRecord(int id) throws SQLException{
	SinhVienDB.editRecordDB(id);
		return "update?faces-redirect=true";
	}
	
	public String updateSv(QuanLyBean sv) {
	SinhVienDB.updateSv(sv);
		return "index?faces-redirect=true";
	}
	
	public String delete(int id) {
		SinhVienDB.deleteSv(id);
		return "index";
	}
	
	public ArrayList<?> getSv() {
		this.sv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
		return sv;
	}
	public void setSv(ArrayList<?> sv) {	
		this.sv = sv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	
}
