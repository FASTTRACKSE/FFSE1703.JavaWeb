package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "kydanhgia")
@Entity
public class KyDanhGia {

	@Id
	@Column(name = "MaKy")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maKy;

	@Column(name = "TenKy")
	private String tenKy;

	@Column(name = "MoTa")
	private String moTa;

	@Column(name = "IsDelete")
	private int isDelete;

	public KyDanhGia() {
		super();
	}

	public int getMaKy() {
		return maKy;
	}

	public void setMaKy(int maKy) {
		this.maKy = maKy;
	}

	public String getTenKy() {
		return tenKy;
	}

	public void setTenKy(String tenKy) {
		this.tenKy = tenKy;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
