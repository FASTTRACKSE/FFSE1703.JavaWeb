package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@SuppressWarnings("serial")
@Table(name = "lich_danh_gia")
@Entity
public class LichDanhGia implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_ky_danh_gia", referencedColumnName = "ma_ky_danh_gia", insertable = true, updatable = true)
	@NotNull
	private KyDanhGia kyDanhGia;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_phong_ban", referencedColumnName = "ma_phong_ban", insertable = true, updatable = true)
	@NotNull
	private PhongBan phongBan;

	@NaturalId
	@Column(name = "is_active")
	private int isActive;

	public LichDanhGia() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public KyDanhGia getKyDanhGia() {
		return kyDanhGia;
	}

	public void setKyDanhGia(KyDanhGia kyDanhGia) {
		this.kyDanhGia = kyDanhGia;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
