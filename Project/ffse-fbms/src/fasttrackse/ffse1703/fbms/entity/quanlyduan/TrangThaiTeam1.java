package fasttrackse.ffse1703.fbms.entity.quanlyduan;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tinh_trang")
public class TrangThaiTeam1 {
	@Id
	@Column(name = "ma_tinh_trang")
	@NotEmpty
	 String maTrangThai;
	
	@Column(name = "ten_tinh_trang")
	@NotEmpty
	 String tenTrangThai;
	
	@Column(name = "is_delete")
	String is_delete;

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getTenTrangThai() {
		return tenTrangThai;
	}

	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	

}
