package fasttrackse.ffse1703.fbms.entity.qlvn2;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;


@Entity
@Table(name = "don_xin_phep")
public class DonXinPhepEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;

	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien")
	 private HoSoNhanVien maNhanVien;
	
	@Column(name = "ngay_bat_dau")
	 private Date ngayBatDau;
	
	@Column(name = "ngay_ket_thuc")
	private Date ngayKetThuc;
	
	@Column(name = "so_ngay_nghi")
	private int soNgayNghi;
	
	@ManyToOne
	@JoinColumn(name = "ly_do")
	 private LyDoEntity lyDo ;
	
	@Column(name = "ghi_chu")
	private String ghiChu;
	
	@Column(name = "ghi_chu_truong_phong" )
	private String ghiChuTruongPhong;
	
	@Column(name="trang_thai")
	private String trangThai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoSoNhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(HoSoNhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

	public LyDoEntity getLyDo() {
		return lyDo;
	}

	public void setLyDo(LyDoEntity lyDo) {
		this.lyDo = lyDo;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getGhiChuTruongPhong() {
		return ghiChuTruongPhong;
	}

	public void setGhiChuTruongPhong(String ghiChuTruongPhong) {
		this.ghiChuTruongPhong = ghiChuTruongPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}
	

	