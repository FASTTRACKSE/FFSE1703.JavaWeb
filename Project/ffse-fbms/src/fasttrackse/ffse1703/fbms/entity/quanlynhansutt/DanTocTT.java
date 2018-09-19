package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "dan_toc")
public class DanTocTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_dan_toc", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maDanToc;

	@Column(name = "ten_dan_toc", nullable = false, length = 255)
	@NotEmpty
	private String tenDanToc;

	// bi-directional many-to-one association to HoSoNhanVien
	@OneToMany(mappedBy = "danToc")
	private List<HoSoNhanVienTT> hoSoNhanViens;

	public DanTocTT() {
	}

	public String getMaDanToc() {
		return maDanToc;
	}

	public void setMaDanToc(String maDanToc) {
		this.maDanToc = maDanToc;
	}

	public String getTenDanToc() {
		return tenDanToc;
	}

	public void setTenDanToc(String tenDanToc) {
		this.tenDanToc = tenDanToc;
	}

	public List<HoSoNhanVienTT> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVienTT> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}