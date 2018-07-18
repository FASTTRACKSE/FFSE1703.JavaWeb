package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import bean.SinhVienBean;
import dao.SinhVienDAO;

@ManagedBean(name = "studentController")
@SessionScoped
public class SinhVienController {
	private int pageCurrent, pageTotal, pageLimit, pageStart;
	public ArrayList<SinhVienBean> listSinhVien;
	public Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	private SinhVienDAO studentDAO = new SinhVienDAO();
	public Map<String, Object> sessionObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public SinhVienController() throws SQLException {
		listSinhVien = new ArrayList<SinhVienBean>();
		this.pageCurrent = 1;
		this.pageTotal = 1;
		this.pageStart = 1;
		this.pageLimit = 1;
		locale = new Locale("vi");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		loadStudent();
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public void changeLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
	
	public void countStudent() throws SQLException {
		int totalStudent = studentDAO.rowCount();
		pageTotal = (int) Math.ceil(totalStudent / pageLimit);
		if (pageCurrent > pageTotal) {
			pageCurrent = pageTotal;
		}
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

	public void loadStudent() throws SQLException {
		listSinhVien.clear();
		countStudent();
		pageStart = (pageCurrent - 1) * pageLimit;
		listSinhVien = studentDAO.listSinhVien(pageStart, pageLimit);
	}

	public ArrayList<SinhVienBean> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(ArrayList<SinhVienBean> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public String insertSinhVien(SinhVienBean sv) throws SQLException {
		studentDAO.insertSinhVien(sv);
		return "index.xhtml?faces-redirect=true";
	}

	public String editSinhVien(int id) throws SQLException {
		SinhVienBean sv = new SinhVienBean(id);
		SinhVienBean extSV = studentDAO.getSinhVien(sv);
		sessionObj.put("extSV", extSV);
		return "FormUpdate.xhtml?faces-redirect=true";
	}

	public String updateSinhVien(SinhVienBean sv) throws SQLException {
		studentDAO.updateSinhVien(sv);
		return "index.xhtml?faces-redirect=true";
	}

	public void deleteSinhVien(int id) throws SQLException {
		studentDAO.deleteSinhVien(id);
		loadStudent();
	}

}
