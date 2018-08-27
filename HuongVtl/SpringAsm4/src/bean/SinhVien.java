package bean;

public class SinhVien {
	private String hoTen;
	private String email;
	private String diachi;
	private String sdt;
	
	public SinhVien(String hoTen, String email, String diachi, String sdt) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		this.diachi = diachi;
		this.sdt = sdt;
	}
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
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
}
