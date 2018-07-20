package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name= "sinhVien_Controller")
@SessionScoped

public class SinhVien_Controller {
	public double tongSv;
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	public ArrayList<SinhVien_Bean> arrSinhVien = new ArrayList<>();
	public DAO sinhVienDAO = new DAO();
	
	
	@ManagedProperty(value= "#{paginator}")
	Paginator paginator;
	
//	Phân Trang

	public Paginator getPaginator() {
		return paginator;
		
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
	
	public void next() {
		paginator.next();
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
		//System.out.println(paginator.start());
	}
	
	public void prev() {
		paginator.prev();
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
		//System.out.println(paginator.start());
		
	}
	
	public void first() {
		paginator.first();;
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
	}
	
	public void last() {
		paginator.last();
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
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
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
		}
		
		// CRUD
		
		@PostConstruct
		public void init() {
			tongSv = sinhVienDAO.count();
			paginator.pagination(tongSv);
			arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
		}
		
		public ArrayList<SinhVien_Bean> sinhVienList(){
			arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
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
			sinhVienDAO.editSinhVienRecord(maSv);
			System.out.println("Mã sinh viên: " + maSv);
			return "edit?faces-redirect=true";
		}
		
		public String updateSinhVien(SinhVien_Bean sinhVien) throws SQLException {
			sinhVienDAO.update(sinhVien);
			
			return "index?faces-redirect=true";
		}
		
		// validate trùng mã sinh viên
		public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
			int exist = sinhVienDAO.checkExist(value.toString());
			if(exist == 1) {
//				System.out.println(sinhVienDao.checkExist(value.toString()) + "là số lượng");
//				System.out.println(value.toString());
				FacesMessage msg = new FacesMessage("Mã sinh viên đã tồn tại. Vui lòng nhập lại");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		} 		
}



