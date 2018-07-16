package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.SinhVien;
import dao.SinhVienDAO;

@ManagedBean(name = "studentController")
@SessionScoped
public class SinhVienController {
	private int pageCurrent, pageTotal, pageLimit, pageStart;
	public ArrayList<SinhVien> listSinhVien;
	private SinhVienDAO studentDAO = new SinhVienDAO();
	public Map<String, Object> sessionObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public SinhVienController() {
		this.pageCurrent = 1;
		this.pageTotal = 1;
		this.pageStart = 1;
		this.pageLimit = 1;
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

	public void goToPage(int page) throws SQLException {
		if (page < 1) {
			pageCurrent = 1;
		} else if (page > pageTotal) {
			pageCurrent = pageTotal;
		} else {
			pageCurrent = page;
		}
		loadStudent();
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageTotal() throws SQLException {
		pageTotal = (int) Math.ceil(studentDAO.rowCount() / pageLimit);
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

	public void loadStudent() throws SQLException {
		pageStart = (pageCurrent - 1) * pageLimit;
		listSinhVien = studentDAO.listSinhVien(pageStart, pageLimit);
	}

	public ArrayList<SinhVien> getListSinhVien() throws SQLException {
		listSinhVien = studentDAO.listSinhVien(pageStart, pageLimit);
		return listSinhVien;
	}

	public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}
	
	public String insertSinhVien(SinhVien sv) throws SQLException {
		studentDAO.insertSinhVien(sv);
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editSinhVien(int id) throws SQLException {
		SinhVien sv = new SinhVien(id);
		SinhVien extSV = studentDAO.getSinhVien(sv);
		sessionObj.put("extSV", extSV);
		return "FormUpdate.xhtml?faces-redirect=true";
	}
	
	public String updateSinhVien(SinhVien sv) throws SQLException {
		studentDAO.updateSinhVien(sv);
		return "index.xhtml?faces-redirect=true";
	}
	
	public String deleteSinhVien(int id) throws SQLException {
		studentDAO.deleteSinhVien(id);
		return "index.xhtml?faces-redirect=true";
	}

}
