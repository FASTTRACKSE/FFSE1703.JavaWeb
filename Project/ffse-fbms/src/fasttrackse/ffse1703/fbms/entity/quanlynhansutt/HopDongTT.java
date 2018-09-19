package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1703.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

/**
 * The persistent class for the hop_dong database table.
 *  e muốn list cái entity ni đsung k
 *  dạ 
 */
@Entity
@Table(name = "hop_dong")
public class HopDongTT implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_hop_dong", unique = true, nullable = false)
	@NotNull
	private int maHopDong;

	// bi-directional many-to-one association to HoSoNhanVien
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien")
	private HoSoNhanVien hoSoNhanVien;

	// bi-directional many-to-one association to LoaiHopDong
	@ManyToOne
	@JoinColumn(name = "ma_loai_hop_dong")
	@NotNull
	private LoaiHopDongTT loaiHopDong;

	// bi-directional many-to-one association to LoaiHopDong
	@ManyToOne
	@JoinColumn(name = "ma_chuc_danh")
	@NotNull
	private ChucDanh chucDanh;

	@Column(name = "luong_thang_13", nullable = false)
	private Integer luongThang13;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_ky", nullable = false)  
	private Date ngayKy;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "hop_dong_tu_ngay", nullable = false)
	private Date hopDongTuNgay;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "hop_dong_den_ngay", nullable = false)
	private Date hopDongDenNgay;

	@Column(name = "so_ngay_phep", nullable = false)
	private Integer soNgayPhep;

	@Column(name = "trang_thai", nullable = false)
	private Integer trangThai;

	public HopDongTT() {
		super();
	}

	public int getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(int maHopDong) {
		this.maHopDong = maHopDong;
	}

	public HoSoNhanVien getHoSoNhanVien() {
		return hoSoNhanVien;
	}

	public void setHoSoNhanVien(HoSoNhanVien hoSoNhanVien) {
		this.hoSoNhanVien = hoSoNhanVien;
	}

	public LoaiHopDongTT getLoaiHopDong() {
		return loaiHopDong;
	}

	public void setLoaiHopDong(LoaiHopDongTT loaiHopDong) {
		this.loaiHopDong = loaiHopDong;
	}

	public ChucDanh getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(ChucDanh chucDanh) {
		this.chucDanh = chucDanh;
	}

	public Integer getLuongThang13() {
		return luongThang13;
	}

	public void setLuongThang13(Integer luongThang13) {
		this.luongThang13 = luongThang13;
	}

	public Date getNgayKy() {
		return ngayKy;
	}

	public void setNgayKy(Date ngayKy) {
		this.ngayKy = ngayKy;
	}

	public Date getHopDongTuNgay() {
		return hopDongTuNgay;
	}

	public void setHopDongTuNgay(Date hopDongTuNgay) {
		this.hopDongTuNgay = hopDongTuNgay;
	}

	public Date getHopDongDenNgay() {
		return hopDongDenNgay;
	}

	public void setHopDongDenNgay(Date hopDongDenNgay) {
		this.hopDongDenNgay = hopDongDenNgay;
	}

	public Integer getSoNgayPhep() {
		return soNgayPhep;
	}

	public void setSoNgayPhep(Integer soNgayPhep) {
		this.soNgayPhep = soNgayPhep;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
