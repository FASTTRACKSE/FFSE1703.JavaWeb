package fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="loai_cong_viec")
public class LoaiCongViecMinhHQ {

	@Id
	@Column(name = "ID")
	@NotNull
	private int ID;

	@Column(name = "loai")
	@NotEmpty
	private String loaiCongViec;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(String loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
	}
	
}
