package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "danh_gia_nhan_vien")
@Entity
public class DanhGiaNhanVien {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ky_danh_gia")
	private String kyDanhGia;

	@Column(name = "ma_phong_ban")
	private String phongBan;

	@Column(name = "nhan_vien")
	private String nhanVien;

	@Column(name = "nhan_vien_danh_gia")
	private String nhanVienDanhGia;

	@Column(name = "ky_luat_cong_viec")
	private String kyLuatCongViec;

	@Column(name = "tinh_than_lam_viec")
	private String tinhThanLamViec;

	@Column(name = "khoi_luong_cong_viec")
	private String khoiLuongCongViec;

	@Column(name = "ket_qua_cong_viec")
	private String ketQuaCongViec;

	@Column(name = "ky_nang_tich_luy")
	private String kyNangTichLuy;

	@Column(name = "dinh_huong")
	private String dinhHuong;

	@Column(name = "danh_gia_tong_the")
	private int danhGiaTongThe;

	@Column(name = "ma_trang_thai")
	private int trangThai;

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

	public String getKyDanhGia() {
		return kyDanhGia;
	}

	public void setKyDanhGia(String kyDanhGia) {
		this.kyDanhGia = kyDanhGia;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public String getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(String nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getNhanVienDanhGia() {
		return nhanVienDanhGia;
	}

	public void setNhanVienDanhGia(String nhanVienDanhGia) {
		this.nhanVienDanhGia = nhanVienDanhGia;
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

	public int getDanhGiaTongThe() {
		return danhGiaTongThe;
	}

	public void setDanhGiaTongThe(int danhGiaTongThe) {
		this.danhGiaTongThe = danhGiaTongThe;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
