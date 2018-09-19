package fasttrackse.ffse1703.fbms.entity.QuanLyDuAn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "khach_hang")
public class KhachHang {
	@Id
	@Column(name = "ma_khach_hang")
	@NotEmpty
	 String makh;
	
	@Column(name = "ten_khach_hang")
	@NotEmpty
	 String tenkh;
	
	@Column(name = "dia_chi")
	@NotEmpty
	 String diachi;
	
	@Column(name = "so_dien_thoai")
	@NotEmpty
	 String sdt;
	
	@Column(name = "email")
	@NotEmpty
	 String email;
	
	@Column(name = "is_delete")
	String is_delete;
	
	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}

	public KhachHang() {
		
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
