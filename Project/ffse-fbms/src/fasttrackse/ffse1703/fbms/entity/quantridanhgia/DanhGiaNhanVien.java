package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

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

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Table(name = "danh_gia_nhan_vien")
@Entity
public class DanhGiaNhanVien {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_ky_danh_gia", referencedColumnName="ma_ky_danh_gia")
	private KyDanhGia kyDanhGia;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ma_phong_ban",  referencedColumnName="ma_phong_ban")
	private PhongBan phongBan;

	@Column(name = "nhan_vien_danh_gia")
	private HoSoNhanVien nhanVienDanhGia;

	@Column(name = "nhan_vien")
	private HoSoNhanVien nhanVien;

	@Column(name = "ky_luat_cong_viec", nullable = false)
	private String kyLuatCongViec;

	@Column(name = "tinh_than_lam_viec", nullable = false)
	private String tinhThanLamViec;

	@Column(name = "khoi_luong_cong_viec", nullable = false)
	private String khoiLuongCongViec;

	@Column(name = "ket_qua_cong_viec", nullable = false)
	private String ketQuaCongViec;

	@Column(name = "ky_nang_tich_luy", nullable = false)
	private String kyNangTichLuy;

	@Column(name = "dinh_huong", nullable = false)
	private String dinhHuong;

	@Column(name = "xep_loai")
	private int xepLoai;

	@Column(name = "is_delete")
	private int isDelete;

	public DanhGiaNhanVien() {
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

	public HoSoNhanVien getNhanVienDanhGia() {
		return nhanVienDanhGia;
	}

	public void setNhanVienDanhGia(HoSoNhanVien nhanVienDanhGia) {
		this.nhanVienDanhGia = nhanVienDanhGia;
	}

	public HoSoNhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(HoSoNhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getKyLuatCongViec() {
		return kyLuatCongViec;
	}

	public void setKyLuatCongViec(String kyLuatCongViec) {
		this.kyLuatCongViec = kyLuatCongViec;
	}

	public String getTinhThanLamViec() {
		return tinhThanLamViec;
	}

	public void setTinhThanLamViec(String tinhThanLamViec) {
		this.tinhThanLamViec = tinhThanLamViec;
	}

	public String getKhoiLuongCongViec() {
		return khoiLuongCongViec;
	}

	public void setKhoiLuongCongViec(String khoiLuongCongViec) {
		this.khoiLuongCongViec = khoiLuongCongViec;
	}

	public String getKetQuaCongViec() {
		return ketQuaCongViec;
	}

	public void setKetQuaCongViec(String ketQuaCongViec) {
		this.ketQuaCongViec = ketQuaCongViec;
	}

	public String getKyNangTichLuy() {
		return kyNangTichLuy;
	}

	public void setKyNangTichLuy(String kyNangTichLuy) {
		this.kyNangTichLuy = kyNangTichLuy;
	}

	public String getDinhHuong() {
		return dinhHuong;
	}

	public void setDinhHuong(String dinhHuong) {
		this.dinhHuong = dinhHuong;
	}

	public int getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(int xepLoai) {
		this.xepLoai = xepLoai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	

}
