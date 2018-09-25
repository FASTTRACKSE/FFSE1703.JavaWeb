package fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "loai_trang_thai")
public class LoaitrangthaiEntity {
	
	public LoaitrangthaiEntity() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private int ID;
	
	@Column(name = "loai_trang_thai")
	@NotEmpty
	private String loaiTrangthai;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLoaiTrangthai() {
		return loaiTrangthai;
	}

	public void setLoaiTrangthai(String loaiTrangthai) {
		this.loaiTrangthai = loaiTrangthai;
	}
}
