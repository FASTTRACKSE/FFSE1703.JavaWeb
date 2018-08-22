package model;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import crud.db.operations.DAOSV;
import pagination.Pagination;

@ManagedBean
@SessionScoped

public class SinhVienBean {

	private List<SinhVienBean> studentList;

	@ManagedProperty(value = "#{DAO}")
	private DAOSV studentDao;

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
		this.studentList = DAOSV.getRecords(pagination.getFromIndex(), pagination.getRecords());
	}

	// @SuppressWarnings("unchecked")
	// public ArrayList<SinhVienBean> getSinhVienList() throws SQLException {
	// sinhVienList = DAOSV.getStudentsListFromDB();
	// return sinhVienList;
	// }

	public String saveStudentDetails(SinhVienBean newStudentObj) throws SQLException {
		return DAOSV.saveStudent(newStudentObj);
	}

	public String deleteStudentRecord(String maSinhVien) throws SQLException {
		if (DAOSV.deleteStudentRecordInDB(maSinhVien)) {
			try {
				int countRecords = studentDao.count();
				pagination.setStudentList(countRecords);
				setStudentList();
			} catch (Exception e) {
				System.out.println(e);
			}
			return "/ListSinhVien.xhtml";
		}
		return "/ListSinhVien.xhtml";
	}

	public String updateStudentDetails(SinhVienBean updateStudentObj) throws SQLException {
		return DAOSV.updateStudentDetailsInDB(updateStudentObj);
	}

	public DAOSV getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(DAOSV studentDao) {
		this.studentDao = studentDao;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String editStudentRecord(String maSinhVien) throws SQLException {
		return DAOSV.editStudentRecordInDB(maSinhVien);
	}

	public SinhVienBean() {

	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getDress() {
		return dress;
	}

	public void setDress(String dress) {
		this.dress = dress;
	}

	private String maSinhVien;
	private String name;
	private String sex;
	private String age;
	private String lop;
	private String dress;

}
