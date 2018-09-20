package fasttrackse.ffse1703.fbms.entity.qlvn2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "trang_thai_don_xin_phep")
public class TrangThaiEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trangthai")
   private int trangThai;
	
	@Column(name = "dang_o_trang_thai")
	private String dangOTrangThai;
	
	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public String getDangOTrangThai() {
		return dangOTrangThai;
	}

	public void setDangOTrangThai(String dangOTrangThai) {
		this.dangOTrangThai = dangOTrangThai;
	}

	
}
