package fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tai_lieu")
public class TaiLieu {
	@Id
	@Column(name = "ma_tai_lieu")
	String maTL;
	@Column(name = "Ten_Danh_Muc")
	String tenDM;
	@Column(name = "Hinh_Bieu_Tuong")
	String iconTL;
	@Column(name = "Ten_Tai_Lieu")
	String tenTL;
	@Column(name = "Ma_Phong_Ban")
	String maPhongBan;
	@Column(name = "mo_taTL")
	String motaTL;
	@Column(name = "Link")
	String link;
	@Column(name = "Trang_Thai")
	String trangthai;

	public TaiLieu() {

	}

	public String getMaTL() {
		return maTL;
	}

	public void setMaTL(String maTL) {
		this.maTL = maTL;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

	public String getIconTL() {
		return iconTL;
	}

	public void setIconTL(String iconTL) {
		this.iconTL = iconTL;
	}

	public String getTenTL() {
		return tenTL;
	}

	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getMotaTL() {
		return motaTL;
	}

	public void setMotaTL(String motaTL) {
		this.motaTL = motaTL;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

}
