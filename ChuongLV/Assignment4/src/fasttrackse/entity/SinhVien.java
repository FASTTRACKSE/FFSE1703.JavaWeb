package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class SinhVien {
	
	private String hoTen;
	private String email;
	private String diaChi;
	private String dienThoai;
	
	public SinhVien( String hoTen, String email, String diaChi, String dienThoai) {
		super();
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	
	public String getSinhVien() {
		return hoTen+" \n"
				+ "     + Email: "+email+""
			   +"\n     + Địa chỉ: " + diaChi
			   +"\n     + Sđt: " + dienThoai;
	}

}
