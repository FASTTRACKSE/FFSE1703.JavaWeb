package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "danhgianhanvien")
@Entity
public class DanhGiaNhanVien {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "KyDanhGia")
	private String kyDanhGia;

	@Column(name = "PhongBan")
	private String phongBan;

	@Column(name = "NhanVien")
	private String nhanVien;

	@Column(name = "NhanVienDuocDanhGia")
	private String nhanVienDuocDanhGia;

	@Column(name = "KyLuatCongViec")
	private String kyLuatCongViec;

	@Column(name = "TinhThanLamViec")
	private String tinhThanLamViec;

	@Column(name = "KhoiLuongCongViec")
	private String khoiLuongCongViec;

	@Column(name = "KetQuaCongViec")
	private String ketQuaCongViec;

	@Column(name = "KyNangTichLuy")
	private String kyNangTichLuy;

	@Column(name = "DinhHuong")
	private String dinhHuong;

	@Column(name = "DanhGiaTongThe")
	private int danhGiaTongThe;

	@Column(name = "TrangThai")
	private int trangThai;

	@Column(name = "IsDelete")
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

	public String getNhanVienDuocDanhGia() {
		return nhanVienDuocDanhGia;
	}

	public void setNhanVienDuocDanhGia(String nhanVienDuocDanhGia) {
		this.nhanVienDuocDanhGia = nhanVienDuocDanhGia;
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
