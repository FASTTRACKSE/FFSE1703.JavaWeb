package entity;

public class SinhVien {
	private String hoTen;
	private String email;
	private String diaChi;
	private String sdt;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public SinhVien(String hoTen, String email, String diaChi, String sdt) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}
	public SinhVien() {
		
	}
	public String inforSV() {
		return  hoTen + "-"+ email + "-" + diaChi + "-"+sdt;
	}
	
}
