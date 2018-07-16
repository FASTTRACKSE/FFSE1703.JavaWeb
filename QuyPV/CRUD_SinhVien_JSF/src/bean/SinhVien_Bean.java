package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;


@ManagedBean(name= "sinhVien_Bean")
@SessionScoped
public class SinhVien_Bean implements Serializable {
	private String maSv, hoTen, namSinh, queQuan, gioiTinh, email, dienThoai, maLop;
	private double soTrang;
	private int trang, prev, next, start, end;
	public ArrayList<SinhVien_Bean> arrSinhVien = new ArrayList<>();
	public DAO sinhVienDAO = new DAO();

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
	
	public double getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(double soTrang) {
		this.soTrang = soTrang;
	}
	
	

	public int getTrang() {
		return trang;
	}

	public void setTrang(int trang) {
		this.trang = trang;
	}
	
	
	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}
	

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
		        .getRequest();
		this.trang = 1; // mặc định là trang 1
		double tongSinhVien = sinhVienDAO.count(); // lấy số lượng sinh viên
		double soBanGhiMotTrang = 2.0;// xác định số bản ghi trong 1 trang
		
		this.soTrang = Math.ceil(tongSinhVien/soBanGhiMotTrang); // lấy số lượng trang
		
		
		if(request.getParameter("trang") != null) {
			this.trang = Integer.parseInt(request.getParameter("trang"));
		}
		// nút prev
		this.prev = 0;
		if(this.trang == 1){
			this.prev = 1;
		} else {
			this.prev = this.trang - 1;
		}
		// nút next
		this.next = 0;
		if(this.trang < this.soTrang) {
			this.next = this.trang + 1;
		} else if(this.trang >= this.soTrang) {
			this.next = this.trang;
		}
		 
		 start = (this.trang - 1) * 2;
		 end = 2;
		
		arrSinhVien = sinhVienDAO.sinhVienList(start, end);
	}
	
	public ArrayList<SinhVien_Bean> sinhVienList(){
		arrSinhVien = sinhVienDAO.sinhVienList(start, end);
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
