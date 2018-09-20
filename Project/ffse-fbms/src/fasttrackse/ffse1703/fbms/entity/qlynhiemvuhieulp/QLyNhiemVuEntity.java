package fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quan_ly_nhiem_vu")
public class QLyNhiemVuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private int ID;

	@Column(name = "ma_du_an")
	@NotNull
	private int duAn;

	@Column(name = "loai_cong_viec")
	@NotEmpty
	private String loaiCongviec;

	@Column(name = "ten_cong_viec")
	@NotEmpty
	private String tenCongviec;

	@Column(name = "mo_ta")
	@NotEmpty
	private String moTa;

	@Column(name = "tg_bat_dau")
	@NotNull
	private Date tgBatdau;

	@Column(name = "tg_ket_thuc")
	@NotNull
	private Date tgKetthuc;

	@Column(name = "nguoi_duoc_phan_cong")
	@NotEmpty
	private String nguoiDuocphancong;

	@Column(name = "tg_du_kien_hoan_thanh")
	@NotNull
	private String tgDukienhoanthanh;

	@Column(name = "loai_trang_thai")
	@NotEmpty
	private String loaiTrangthai;

	@Column(name = "is_delete")	
	private int isDelete;

	public QLyNhiemVuEntity() {
		super();

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getDuAn() {
		return duAn;
	}

	public void setDuAn(int duAn) {
		this.duAn = duAn;
	}

	public String getLoaiCongviec() {
		return loaiCongviec;
	}

	public void setLoaiCongviec(String loaiCongviec) {
		this.loaiCongviec = loaiCongviec;
	}

	public String getTenCongviec() {
		return tenCongviec;
	}

	public void setTenCongviec(String tenCongviec) {
		this.tenCongviec = tenCongviec;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getTgBatdau() {
		return tgBatdau;
	}

	public void setTgBatdau(Date tgBatdau) {
		this.tgBatdau = tgBatdau;
	}

	public Date getTgKetthuc() {
		return tgKetthuc;
	}

	public void setTgKetthuc(Date tgKetthuc) {
		this.tgKetthuc = tgKetthuc;
	}

	public String getNguoiDuocphancong() {
		return nguoiDuocphancong;
	}

	public void setNguoiDuocphancong(String nguoiDuocphancong) {
		this.nguoiDuocphancong = nguoiDuocphancong;
	}

	public String getTgDukienhoanthanh() {
		return tgDukienhoanthanh;
	}

	public void setTgDukienhoanthanh(String tgDukienhoanthanh) {
		this.tgDukienhoanthanh = tgDukienhoanthanh;
	}

	public String getLoaiTrangthai() {
		return loaiTrangthai;
	}

	public void setLoaiTrangthai(String loaiTrangthai) {
		this.loaiTrangthai = loaiTrangthai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
