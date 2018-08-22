package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.StudentBean;
import dao.StudentDao;




@ManagedBean(name = "sinhVienController")
@SessionScoped
public class DatabaseOperation {
	private int pageCurrent, pageTotal, pageLimit, pageStart;
	public ArrayList<StudentBean> listSinhVien;

	public DatabaseOperation() throws SQLException {
		this.pageCurrent = 1;
		this.pageTotal = 1;
		this.pageStart = 1;
		this.pageLimit = 1;
		loadStudent();
	}

	public  void loadStudent() throws SQLException {
		// listSinhVien.clear();
		countStudent();
		pageStart = (pageCurrent - 1) * pageLimit;
		listSinhVien = StudentDao.arrSV(pageStart, pageLimit);
	}
	public void countStudent() throws SQLException {
		int totalStudent = StudentDao.count();
		pageTotal = (int) Math.ceil(totalStudent / pageLimit);
		if (pageCurrent > pageTotal) {
			pageCurrent = pageTotal;
		}
	}
//	public void goToPage(int page) throws SQLException {
//		if (page < 1) {
//			pageCurrent = 1;
//		} else if (page > pageTotal) {
//			pageCurrent = pageTotal;
//		} else {
//			pageCurrent = page;
//		}
//		loadStudent();
//	}
	public ArrayList<StudentBean> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(ArrayList<StudentBean> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public void firstPage() throws SQLException {
		pageCurrent = 1;
		loadStudent();
	}

	public void prevPage() throws SQLException {
		if (pageCurrent > 1) {
			pageCurrent -= 1;
		}
		loadStudent();
	}

	public void nextPage() throws SQLException {
		if (pageCurrent < pageTotal) {
			pageCurrent += 1;
		}
		loadStudent();
	}

	public void lastPage() throws SQLException {
		pageCurrent = pageTotal;
		loadStudent();
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public void  deleteStudentRecord(int studentId) throws SQLException {
         StudentDao.deleteStudentRecordInDB(studentId);
		loadStudent();
		
	}
	public String editStudentRecord(int studentId) {
		return StudentDao.editStudentRecordInDB(studentId);
	}
	
	public String updateStudentDetails(StudentBean updateStudentObj) {
		return StudentDao.updateStudentDetailsInDB(updateStudentObj);
	}
	public String saveStudentDetails(StudentBean newStudentObj) {
		return StudentDao.saveStudentDetailsInDB(newStudentObj);
	}
	
}

