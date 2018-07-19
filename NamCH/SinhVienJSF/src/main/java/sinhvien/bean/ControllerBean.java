package sinhvien.bean;

import java.util.ArrayList;
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

import sinhvien.service.Paginator;
import sinhvien.service.SinhVien;
import sinhvien.service.SinhVienDB;

@ManagedBean
@SessionScoped
public class ControllerBean{
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private String name,sex,email,phone,adress,classes,year;
	private SinhVien sv;
	public ArrayList<SinhVien> arrSv = new ArrayList<SinhVien>();
	public Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	public Locale getLocale() {
		return locale;
	}

	public Map<String, Object> sessionObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	@ManagedProperty(value= "#{paginator}")
	Paginator paginator;
	
	public void changeLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
	
	//phan trang
	public Paginator getPaginator() {
		return paginator;
		
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
	
	public void next() {
		paginator.next();
		arrSv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
	}
	
	public void prev() {
		paginator.prev();
		arrSv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
		
	}
	
	public void first() {
		paginator.first();;
		arrSv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
	}
	
	public void last() {
		paginator.last();
		arrSv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
	}
	
	@PostConstruct
	public void init() {
		locale = new Locale("vi");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		double tongSv = SinhVienDB.countStudent();
		paginator.pagination(tongSv);
		this.arrSv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
	}
	
	public ArrayList<SinhVien> getArrSv() {
		arrSv = SinhVienDB.sinhVienList(paginator.start(),paginator.end);
		return arrSv;
	}

	public void setArrSv(ArrayList<SinhVien> arrSv) {
		this.arrSv = arrSv;
	}
	
	public String delOk(int id) {
		int check = 0;
		check=SinhVienDB.delStudent(id);
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editForm(int id) {
		SinhVien std = new SinhVien();
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		std = SinhVienDB.searchCode(id);
		sessionMapObj.put("editValue", std);
		return "update.xhtml?faces-redirect=true";
	}
	
	public String editOk(SinhVien std) {
		int check=0;
		check = SinhVienDB.updateStudent(std);
		if(check>0) {
			return "index.xhtml?faces-redirect=true";
		}else {
			return "update.xhtml?faces-redirect=true";
		}		
	}
	
	public String addOk() {
		int yearOld = Integer.parseInt(this.year);
		sv=new SinhVien(this.name,yearOld,this.sex,this.email,this.phone,this.adress,this.classes);
		int check=0;
		check = SinhVienDB.addStudent(sv);
		if(check>0) {
			return "index.xhtml?faces-redirect=true";
		}else {
			return "create.xhtml?faces-redirect=true";
		}
	}
	
	public String create() {
		return "create.xhtml?faces-redirect=true";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		int exist = SinhVienDB.checkName(value.toString());
		if(exist >0) {
			FacesMessage msg = new FacesMessage("Đã tồn tại sinh viên");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
