package fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "danh_muc")
public class DanhMuc {
	@Id
	@Column(name = "Ma_Danh_Muc")
	String idDM;
	@Column(name = "Ten_Danh_Muc")
	String tenDM;

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
}
