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
@Table(name = "xa_phuong")
public class XaPhuongTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_xa_phuong", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maxa;

	@Column(name = "ten_xa_phuong", nullable = false, length = 255)
	@NotEmpty
	private String tenxa;

	// bi-directional many-to-one association to HoSoNhanVien
	@OneToMany(mappedBy = "xaPhuong")
	private List<HoSoNhanVienTT> hoSoNhanViens;

	public XaPhuongTT() {
	}

	public String getMaxa() {
		return maxa;
	}

	public void setMaxa(String maxa) {
		this.maxa = maxa;
	}

	public String getTenxa() {
		return tenxa;
	}

	public void setTenxa(String tenxa) {
		this.tenxa = tenxa;
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
