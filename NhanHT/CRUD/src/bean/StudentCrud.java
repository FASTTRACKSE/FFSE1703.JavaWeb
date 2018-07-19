package bean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class StudentCrud {
	private int id;
	private String hoDem, ten, namSinh, gioiTinh, email, dienThoai, diaChi, lop;
	public StudentDAO studentDAO = new StudentDAO();
	public StudentCrud(int id, String hoDem, String ten, String namSinh, String gioiTinh, String email,
			String dienThoai, String diaChi, String lop) {
		super();
		this.id = id;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.lop = lop;
	}
	public StudentCrud() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
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
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
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
	
	public String deleteStudentRecord(int studentId) {
		return studentDAO.deleteStudentRecordInDB(studentId);
	}

	public String saveStudentDetails(StudentCrud newStudentObj) {
		return studentDAO.insertStudentDetailsInDB(hoDem, ten, namSinh, gioiTinh, email, dienThoai, diaChi, lop);
	}

	public String editStudentRecord(int studentId) throws SQLException {
		return studentDAO.editStudentRecordInDB(studentId);
	}

	public String updateStudentDetails(StudentCrud updateStudentObj) throws SQLException {
		return studentDAO.updateStudentDetailsInDB(updateStudentObj);
	}
}
