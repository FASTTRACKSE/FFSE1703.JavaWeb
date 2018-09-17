package fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "danh_muc")
public class DanhMuc {
	
	@Column(name ="Ma_Danh_Muc")
	String idDM;
	@Column(name ="Ten_Danh_Muc")
	String tenDM;
	@Column(name="Ma_Phong_Ban")
	String maPhongBan;
	
	public DanhMuc() {
		
	}
	public String getIdDM() {
		return idDM;
	}
	public void setIdDM(String idDM) {
		this.idDM = idDM;
	}
	public String getTenDM() {
		return tenDM;
	}
	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	
}
