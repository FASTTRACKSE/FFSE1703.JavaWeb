package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.SinhVienDAO;


@ManagedBean(name = "sinhVien")
@RequestScoped
public class SinhVien {
	private int id;
	private String hoDem, ten, namSinh, gioiTinh, email, sdt, diaChi, lop;
	private SinhVienDAO sinhVienDAO = new SinhVienDAO();
	private ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	
	public ArrayList<SinhVien> getListSinhVien() throws SQLException {
		this.listSinhVien = sinhVienDAO.listSinhVien();
		return listSinhVien;
	}

	public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public String editSinhVien(int ID) throws SQLException {
		return sinhVienDAO.getSinhVien(ID); 
	}
	
	public String insertSinhVien(SinhVien sv) throws SQLException {
		String page = "";
		if (sinhVienDAO.insertSinhVien(sv) == true) {
			page = "index?faces-redirect=true";
		}
		return page;
	}
	public String updateSinhVien(SinhVien sv) throws SQLException {
		String page = "";
		if (sinhVienDAO.updateSinhVien(sv) == true) {
			page = "index?faces-redirect=true";
		}
		return page;
	}
	public String deleteSinhVien(int ID) throws SQLException {
		String page = "";
		if (sinhVienDAO.deleteSinhVien(ID) == true) {
			page = "index?faces-redirect=true";
		}
		return page;
	}
	
}
