package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import bean.Paginator;


@ManagedBean(name= "sinhVien_Bean")
@SessionScoped
public class SinhVien_Bean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSv, hoTen, namSinh, queQuan, gioiTinh, email, dienThoai, maLop;
	public ArrayList<SinhVien_Bean> arrSinhVien = new ArrayList<>();
	public DAO sinhVienDAO = new DAO();
	
	@ManagedProperty(value= "#{paginator}")
	Paginator paginator;
	
	public SinhVien_Bean() {
		//		
	}
	
	public SinhVien_Bean(String maSv, String hoTen, String namSinh, String queQuan, String gioiTinh, String email,
			String dienThoai, String maLop) {
		this.maSv = maSv;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.dienThoai = dienThoai;
		this.maLop = maLop;
	}
	
	
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
		System.out.println(paginator.start());
	}
	
	public void prev() {
		paginator.prev();
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
		System.out.println(paginator.start());
		
	}
	
	public void first() {
		paginator.first();;
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
	}
	
	public void last() {
		paginator.last();
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
	}
	
	// CRUD

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSV) {
		this.maSv = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
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

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	
	@PostConstruct
	public void init() {
		double tongSv = sinhVienDAO.count();
		paginator.pagination(tongSv);
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
	}
	
	public ArrayList<SinhVien_Bean> sinhVienList(){
		arrSinhVien = sinhVienDAO.sinhVienList(paginator.start(),paginator.end);
		return arrSinhVien;
	}
	
	public String deleteSinhVien(String maSv) {
		sinhVienDAO.delete(maSv);
		return "index?faces-redirect=true";
	}
	
	public String insertSinhVien(SinhVien_Bean sinhVien) throws SQLException {
		sinhVienDAO.insert(sinhVien);
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
//			System.out.println(sinhVienDao.checkExist(value.toString()) + "là số lượng");
//			System.out.println(value.toString());
			FacesMessage msg = new FacesMessage("Mã sinh viên đã tồn tại. Vui lòng nhập lại");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
	
}
