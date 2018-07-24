package ffse.sinhvien.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import ffse.sinhvien.operations.*;
import pagination.Pagination;

@ManagedBean
@SessionScoped

public class SinhVienBean {
	private int id;
	private String hodem;
	private String ten;
	private String namsinh;
	private String gioitinh;
	private String email;
	private String dienthoai;
	private String diachi;
	private String lop;

	@SuppressWarnings("rawtypes")
	public List<SinhVienBean> ListSinhvienFromDB;

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

	@PostConstruct
//	public void init() {
//		ListSinhvienFromDB = SinhVienOperations.getStudentsListFromDB();
//	}

	public List studentsList() {
		return ListSinhvienFromDB;
	}

	public String saveSinhvien(SinhVienBean newSinhvien) {
		return SinhVienOperations.addSvInDB(newSinhvien);
	}

	public String editSinhvien(int studentId) {
		return SinhVienOperations.editSvInDB(studentId);
	}

	public String updateSinhvien(SinhVienBean updateStudentObj) {
		return SinhVienOperations.updateSvInDB(updateStudentObj);
	}

	public String deleteSinhvien(int studentId) {
		return SinhVienOperations.deleteSvInDB(studentId);
	}
	
	
	
	private List<SinhVienBean> studentList;

	@ManagedProperty(value = "#{DAO}")
	private SinhVienOperations studentDao;

	public List<SinhVienBean> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<SinhVienBean> studentList) {
		this.studentList = studentList;
	}

	public SinhVienOperations getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(SinhVienOperations studentDao) {
		this.studentDao = studentDao;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}



	@ManagedProperty(value = "#{pagination}")
	private Pagination pagination;

	@PostConstruct
	public void init() {
		try {
			int countRecords = studentDao.count();
			pagination.setStudentList(countRecords);
			setStudentList();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<SinhVienBean> studentList() {
		return studentList;
	}

	// Pagination
	public void next() {
		pagination.next();
		setStudentList();
	}

	public void prev() {
		pagination.prev();
		setStudentList();
	}

	public void firstPage() {
		pagination.firstPage();
		setStudentList();
	}

	public void lastPage() {
		pagination.lastPage();
		setStudentList();
	}

	public void setStudentList() {
		this.ListSinhvienFromDB = studentDao.getRecords(pagination.getFromIndex(), pagination.getRecords());
	}

	
	

}
