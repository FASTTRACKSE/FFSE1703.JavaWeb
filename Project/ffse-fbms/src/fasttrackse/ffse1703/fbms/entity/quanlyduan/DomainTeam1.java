package fasttrackse.ffse1703.fbms.entity.quanlyduan;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "nghiep_vu")
public class DomainTeam1 {
	@Id
	@Column(name = "ma_nghiep_vu")
	@NotEmpty
	 String maNghiepVu;
	
	@Column(name = "ten_nghiep_vu")
	@NotEmpty
	 String tenNghiepVu;
	
	@Column(name = "is_delete")
	String is_delete;
	
	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	

	public String getMaNghiepVu() {
		return maNghiepVu;
	}

	public void setMaNghiepVu(String maNghiepVu) {
		this.maNghiepVu = maNghiepVu;
	}

	public String getTenNghiepVu() {
		return tenNghiepVu;
	}

	public void setTenNghiepVu(String tenNghiepVu) {
		this.tenNghiepVu = tenNghiepVu;
	}
	

}
