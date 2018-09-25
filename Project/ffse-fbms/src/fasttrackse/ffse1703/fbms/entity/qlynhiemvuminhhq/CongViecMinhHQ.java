package fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cong_viec")
public class CongViecMinhHQ {
	
	@Id
	@Column(name = "ID")
	@NotNull
	private int ID;

	@Column(name = "ten_cong_viec")
	@NotEmpty
	private String tenCongViec;
	
//	@ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.MERGE)
//	@JoinColumn(name="ma_tinh_trang",referencedColumnName="ma_tinh_trang", insertable=true, updatable=true)
//	@NotNull
//	private TinhTrang tinhTrang ;
	
	@Column(name = "loai_cong_viec")
	@NotEmpty
	private String loaiCongViec;
	
	@Column(name = "mo_ta")
	@NotEmpty
	private String moTa;
	
	@Column(name = "tg_bat_dau")
	@NotEmpty
	private String tgBatDau;
	
	@Column(name = "tg_ket_thuc")
	@NotEmpty
	private String tgKetThuc;
	
	@Column(name = "phan_cong_cho")
	@NotEmpty
	private String phanCong;
	
	@Column(name = "tg_du_kien")
	@NotEmpty
	private String tgDuKien;
	
	@Column(name = "trang_thai")
	@NotEmpty
	private String trangThai;
	
	@Column(name = "du_an")
	@NotEmpty
	private String duAn;
	
	@Column(name = "is_delete")
	@NotNull
	private int isDelete;
	
//	@OneToMany(mappedBy = "congViec")

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTenCongViec() {
		return tenCongViec;
	}

	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}

	public String getLoaiCongViec() {
		return loaiCongViec;
	}

	public void setLoaiCongViec(String loaiCongViec) {
		this.loaiCongViec = loaiCongViec;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTgBatDau() {
		return tgBatDau;
	}

	public void setTgBatDau(String tgBatDau) {
		this.tgBatDau = tgBatDau;
	}

	public String getTgKetThuc() {
		return tgKetThuc;
	}

	public void setTgKetThuc(String tgKetThuc) {
		this.tgKetThuc = tgKetThuc;
	}

	public String getPhanCong() {
		return phanCong;
	}

	public void setPhanCong(String phanCong) {
		this.phanCong = phanCong;
	}

	public String getTgDuKien() {
		return tgDuKien;
	}

	public void setTgDuKien(String tgDuKien) {
		this.tgDuKien = tgDuKien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getDuAn() {
		return duAn;
	}

	public void setDuAn(String duAn) {
		this.duAn = duAn;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
}
