package spring.entity;

import javax.validation.constraints.NotBlank;

public class SinhVien {

	@NotBlank
	private int ma_sv;

	@NotBlank
	private String ho_ten, nam_sinh, email, dia_chi, lop_hoc;

	public int getMa_sv() {
		return ma_sv;
	}

	public void setMa_sv(int ma_sv) {
		this.ma_sv = ma_sv;
	}

	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}

	public String getNam_sinh() {
		return nam_sinh;
	}

	public void setNam_sinh(String nam_sinh) {
		this.nam_sinh = nam_sinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getLop_hoc() {
		return lop_hoc;
	}

	public void setLop_hoc(String lop_hoc) {
		this.lop_hoc = lop_hoc;
	}
}
