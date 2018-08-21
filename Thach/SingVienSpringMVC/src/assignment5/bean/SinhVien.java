package assignment5.bean;

public class SinhVien {
	private int id;
	private String maSv, ten, namSinh, email, sdt, diaChi, lop;

	public SinhVien() {
	}

	public SinhVien(int id, String maSv, String ten, String namSinh, String email, String sdt,
			String diaChi, String lop) {
		super();
		this.id = id;
		this.ten = maSv;
		this.ten = ten;
		this.namSinh = namSinh;
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

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
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
