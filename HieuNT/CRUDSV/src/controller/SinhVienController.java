package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import bean.SinhVien;
import dao.SinhVienDao;
@ManagedBean(name = "sinhVienController")
@SessionScoped

public class SinhVienController {
	private int pageCurrent, pageTotal, pageLimit, pageStart;
	public ArrayList<SinhVien> listSinhVien;
	//CRUD
	public String themSinhVien(SinhVien newStudentObj) throws SQLException {
		SinhVienDao.themSV(newStudentObj);
		countStudent();
		pageCurrent = pageTotal;
		loadStudent();
		return "ListSinhVien.xhtml?faces-redirect=true";
		
	}
	public  void xoaSV(String maSinhVien) throws SQLException {
		SinhVienDao.xoaSV(maSinhVien);
		loadStudent();
	}
	public String editSV(String maSinhVien) throws SQLException{
		SinhVien editRecordObj=SinhVienDao.edit(maSinhVien);
		Map<String, Object> sessionObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionObj.put("editRecordObj", editRecordObj);
		return "editSinhVien.xhtml?faces-redirect=true";
	}
	public String updateSinhVien(SinhVien updateStudentObj) throws SQLException {
		SinhVienDao.updateSinhVien(updateStudentObj);
		loadStudent();
		return "ListSinhVien.xhtml?faces-redirect=true";
	}
	
	
	public SinhVienController() throws SQLException {
		this.pageCurrent = 1;
		this.pageTotal = 1;
		this.pageStart = 1;
		this.pageLimit = 1;
		loadStudent();
	}

	public void loadStudent() throws SQLException {
		// listSinhVien.clear();
		countStudent();
		pageStart = (pageCurrent - 1) * pageLimit;
		listSinhVien = SinhVienDao.arrSV(pageStart, pageLimit);
	}
	public void countStudent() throws SQLException {
		int totalStudent = SinhVienDao.rowCount();
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
	//validate
	public void validateEmail(FacesContext fc, UIComponent uc, Object value) throws ValidatorException {
		Pattern pt = Pattern.compile("[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]");
		Matcher mc = pt.matcher(value.toString());
		if (!mc.matches()) {
			FacesMessage msg = new FacesMessage("Vui lòng nhập đúng định dạng email!!~_~");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
	public ArrayList<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
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


}
