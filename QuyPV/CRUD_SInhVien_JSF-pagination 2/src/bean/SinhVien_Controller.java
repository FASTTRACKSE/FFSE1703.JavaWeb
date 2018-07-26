package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import sessionLogin.*;

@ManagedBean(name = "sinhVien_Controller")
@SessionScoped

public class SinhVien_Controller {
	public double tongSv;
	public ArrayList<SinhVien_Bean> arrSinhVien = new ArrayList<>();
	public DAO sinhVienDAO = new DAO();
	public Locale locale;

	@ManagedProperty(value = "#{paginator}")
	Paginator paginator;

	// Phân Trang

	public Paginator getPaginator() {
		return paginator;

	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public void next() {
		paginator.next();
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(), paginator.end);
		// System.out.println(paginator.start());
	}

	public void prev() {
		paginator.prev();
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(), paginator.end);
		// System.out.println(paginator.start());

	}

	public void first() {
		paginator.first();
		;
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(), paginator.end);
	}

	public void last() {
		paginator.last();
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(), paginator.end);
	}

	// Đa ngữ

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void changeLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	// CRUD

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		tongSv = sinhVienDAO.count();
		paginator.pagination(tongSv);
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(), paginator.end);
	}

	public ArrayList<SinhVien_Bean> sinhVienList() {
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(), paginator.end);
		return arrSinhVien;
	}

	public String deleteSinhVien(String maSv) {
		sinhVienDAO.delete(maSv);
		tongSv = sinhVienDAO.count();
		paginator.pagination(tongSv);
		return "index?faces-redirect=true";
	}

	public String insertSinhVien(SinhVien_Bean sinhVien) throws SQLException {
		sinhVienDAO.insert(sinhVien);
		tongSv = sinhVienDAO.count();
		paginator.pagination(tongSv);
		return "index?faces-redirect=true";
	}

	public String editSinhVienRecord(String maSv) throws SQLException {
		SinhVien_Bean sv = new SinhVien_Bean();
		
		java.util.Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		
		sv = sinhVienDAO.editSinhVienRecord(maSv);
		sessionMapObj.put("editRecordObj", sv);
		
		System.out.println("Mã sinh viên: " + maSv);
		return "edit?faces-redirect=true";
	}

	public String updateSinhVien(SinhVien_Bean sinhVien) throws SQLException {
		sinhVienDAO.update(sinhVien);

		return "index?faces-redirect=true";
	}
	
	// Login
	public String checkLogin(String user, String pass) {
		int kt = sinhVienDAO.checkLogin(user, pass);
		
		if(kt == 1) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("userName", user);
			return "index?faces-redirect=true";
		} else {
			FacesContext faceContext = FacesContext.getCurrentInstance();
			FacesMessage facemessage = new FacesMessage("Sai tên Tài khoản hoặc mật khẩu");
			faceContext.addMessage(null, facemessage);
	
			return "login?faces-redirect=true";
		}
	
	}
	
	public String logout() {
		HttpSession session = SessionUtils.getSession(); // gọi phương thức getSession trong class SessionUtil
		session.invalidate();
		return "login?faces-redirect=true";
	}
	
	

	// validate trùng mã sinh viên
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		int exist = sinhVienDAO.checkExist(value.toString());
		if (exist == 1) {
			// System.out.println(sinhVienDao.checkExist(value.toString()) + "là số lượng");
			// System.out.println(value.toString());
			FacesMessage msg = new FacesMessage("Mã sinh viên đã tồn tại. Vui lòng nhập lại");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

	public void validateNamSinh(FacesContext facesContext, UIComponent component, Object value) {
		int namSinh = Integer.parseInt(value.toString());

		if (namSinh < 1980 || namSinh > Calendar.getInstance().get(Calendar.YEAR)) {
			FacesMessage msg = new FacesMessage("Năm sinh không hợp lệ.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
