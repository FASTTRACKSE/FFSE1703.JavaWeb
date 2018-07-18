package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "studentBean")
@RequestScoped
public class SinhVienBean {

	private int id;
	private String hoDem, ten, namSinh, gioiTinh, email, sdt, diaChi, lop;

	public SinhVienBean() {

	}

	public SinhVienBean(int id) {
		this.id = id;
	}

	public SinhVienBean(String hoDem, String ten, String namSinh, String gioiTinh, String email, String sdt, String diaChi,
			String lop) {
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.lop = lop;
	}

	public SinhVienBean(int id, String hoDem, String ten, String namSinh, String gioiTinh, String email, String sdt,
			String diaChi, String lop) {
		this.id = id;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.lop = lop;
	}

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

}
