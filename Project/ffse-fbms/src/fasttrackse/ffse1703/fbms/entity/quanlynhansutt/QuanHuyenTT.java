package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "quan_huyen")
public class QuanHuyenTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_quan_huyen", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maQuanHuyen;

	@Column(name = "ten_quan_huyen", nullable = false, length = 255)
	@NotEmpty
	private String tenQuanHuyen;

	// bi-directional many-to-one association to HoSoNhanVien
	@OneToMany(mappedBy = "quan")
	private List<HoSoNhanVien> hoSoNhanViens;

	public QuanHuyenTT() {
	}

	public String getMaQuanHuyen() {
		return maQuanHuyen;
	}

	public void setMaQuanHuyen(String maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}

	public String getTenQuanHuyen() {
		return tenQuanHuyen;
	}

	public void setTenQuanHuyen(String tenQuanHuyen) {
		this.tenQuanHuyen = tenQuanHuyen;
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

}
