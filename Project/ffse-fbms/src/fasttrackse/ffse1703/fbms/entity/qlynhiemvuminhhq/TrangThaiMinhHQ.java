package fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trang_thai")
public class TrangThaiMinhHQ {

	
	@Id
	@Column(name = "ID")
	@NotNull
	private int ID;

	@Column(name = "Trang_thai")
	@NotEmpty
	private String trangThai;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
