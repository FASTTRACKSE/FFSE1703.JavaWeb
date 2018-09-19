package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "tinh_trang_hon_nhan")
public class TinhTrangHonNhanTT {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_tinh_trang_hon_nhan", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maTinhTrangHonNhan;

	@Column(name = "tinh_trang_hon_nhan", nullable = false, length = 255)
	@NotEmpty
	private String tinhTrangHonNhan;

	// bi-directional many-to-one association to HoSoNhanVien
	@OneToMany(mappedBy = "quoctich")
	private List<HoSoNhanVien> hoSoNhanViens;

	public String getMaTinhTrangHonNhan() {
		return maTinhTrangHonNhan;
	}

	public void setMaTinhTrangHonNhan(String maTinhTrangHonNhan) {
		this.maTinhTrangHonNhan = maTinhTrangHonNhan;
	}

	public String getTinhTrangHonNhan() {
		return tinhTrangHonNhan;
	}

	public void setTinhTrangHonNhan(String tinhTrangHonNhan) {
		this.tinhTrangHonNhan = tinhTrangHonNhan;
	}

	public List<HoSoNhanVien> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVien> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TinhTrangHonNhanTT() {
	}

}
