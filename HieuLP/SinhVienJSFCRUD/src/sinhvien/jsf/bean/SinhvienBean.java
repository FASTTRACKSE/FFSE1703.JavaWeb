package sinhvien.jsf.bean;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



import sinhvien.jsf.db.operations.DatabaseOperation;
@ManagedBean @RequestScoped
public class SinhvienBean {
	private int id;  
	private String hodem;  
	private String ten;  
	private String namsinh;  
	private String gioitinh;  
	private String email;
	private String dienthoai;
	private String diachi;
	private String lop;
	
	public ArrayList<SinhvienBean> studentsListFromDB;
	
	public int getId() {
		return id;	
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getHodem() {
		return hodem;
	}
	public void setHodem(String hodem) {
		this.hodem = hodem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public void init() {
		studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
	}

	public ArrayList<SinhvienBean> listSinhvien() {
		return studentsListFromDB;
	}
	
	public String saveSV(SinhvienBean newSinhvien) {
		return DatabaseOperation.addSinhvien(newSinhvien);
	}
	
	public String editSV(int studentId) {
		return DatabaseOperation.editSinhvien(studentId);
	}
	
	public String updateSV(SinhvienBean updateStudentObj) {
		return DatabaseOperation.updateSinhvien(updateStudentObj);
	}
	
	public String deleteSV(int studentId) {
		return DatabaseOperation.deleteSinhvien(studentId);
	}
	
	
}
