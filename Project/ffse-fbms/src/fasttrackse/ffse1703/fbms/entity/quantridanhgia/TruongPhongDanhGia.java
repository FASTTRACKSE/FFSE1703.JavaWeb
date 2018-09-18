package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="truongphongdanhgia")
@Entity
public class TruongPhongDanhGia {
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

	@Column(name = "KyLuatCongViec")
	private int kyLuatCongViec;

	@Column(name = "TinhThanLamViec")
	private int tinhThanLamViec;

	@Column(name = "KhoiLuongCongViec")
	private int khoiLuongCongViec;

	@Column(name = "KetQuaCongViec")
	private int ketQuaCongViec;

	@Column(name = "KyNangTichLuy")
	private int kyNangTichLuy;

	@Column(name = "NhanXet")
	private String nhanXet;

	@Column(name = "XepLoai")
	private int xepLoai;

	@Column(name = "IsActive")
	private int isActive;

	public TruongPhongDanhGia() {
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

	public int getKyLuatCongViec() {
		return kyLuatCongViec;
	}

	public void setKyLuatCongViec(int kyLuatCongViec) {
		this.kyLuatCongViec = kyLuatCongViec;
	}

	public int getTinhThanLamViec() {
		return tinhThanLamViec;
	}

	public void setTinhThanLamViec(int tinhThanLamViec) {
		this.tinhThanLamViec = tinhThanLamViec;
	}

	public int getKhoiLuongCongViec() {
		return khoiLuongCongViec;
	}

	public void setKhoiLuongCongViec(int khoiLuongCongViec) {
		this.khoiLuongCongViec = khoiLuongCongViec;
	}

	public int getKetQuaCongViec() {
		return ketQuaCongViec;
	}

	public void setKetQuaCongViec(int ketQuaCongViec) {
		this.ketQuaCongViec = ketQuaCongViec;
	}

	public int getKyNangTichLuy() {
		return kyNangTichLuy;
	}

	public void setKyNangTichLuy(int kyNangTichLuy) {
		this.kyNangTichLuy = kyNangTichLuy;
	}

	public String getNhanXet() {
		return nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}

	public int getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(int xepLoai) {
		this.xepLoai = xepLoai;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
