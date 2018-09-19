package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="danhgiabanthan")
public class DanhGiaBanThan {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="KyDanhGia")
	@NotEmpty
	private String kyDanhGia;
	
	@Column(name="PhongBan")
	@NotEmpty
	private String phongBan;
	
	@Column(name="NhanVien")
	@NotEmpty
	private String nhanVien;
	
	@Column(name="KyLuatCongViec_DG")
	private int kyLuatCongViec_DG;
	
	@Column(name="KyLuatCongViec_MT")
	@NotEmpty
	private String kyLuatCongViec_MT;

	@Column(name="TinhThanLamViec_DG")
	private int tinhThanLamViec_DG;
	
	@Column(name="TinhThanLamViec_MT")
	@NotEmpty
	private String tinhThanLamViec_MT;
	
	@Column(name="KhoiLuongCongViec_DG")
	@NotEmpty
	private int khoiLuongCongViec_DG;
	
	@Column(name="KhoiLuongCongViec_MT")
	private String khoiLuongCongViec_MT;
	
	@Column(name="KetQuaCongViec_DG")
	@NotEmpty
	private int ketQuaCongViec_DG;
	
	@Column(name="KetQuaCongViec_MT")
	private String ketQuaCongViec_MT;
	
	@Column(name="KyNangTichLuy_DG")
	private int kyNangTichLuy_DG;
	
	@Column(name="KyNangTichLuy_MT")
	@NotEmpty
	private String kyNangTichLuy_MT;
	
	@Column(name="DinhHuong")
	@NotEmpty
	private String dinhHuong;
	
	@Column(name="DanhGiaTongThe")
	private String danhGiaTongThe;
	
	@Column(name="TrangThai")
	@NotEmpty
	private int trangThai;
	
	@Column(name="IsDelete")
	@NotEmpty
	private int isDelete;
	
	public DanhGiaBanThan() {
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

	public int getKyLuatCongViec_DG() {
		return kyLuatCongViec_DG;
	}

	public void setKyLuatCongViec_DG(int kyLuatCongViec_DG) {
		this.kyLuatCongViec_DG = kyLuatCongViec_DG;
	}

	public String getKyLuatCongViec_MT() {
		return kyLuatCongViec_MT;
	}

	public void setKyLuatCongViec_MT(String kyLuatCongViec_MT) {
		this.kyLuatCongViec_MT = kyLuatCongViec_MT;
	}

	public int getTinhThanLamViec_DG() {
		return tinhThanLamViec_DG;
	}

	public void setTinhThanLamViec_DG(int tinhThanLamViec_DG) {
		this.tinhThanLamViec_DG = tinhThanLamViec_DG;
	}

	public String getTinhThanLamViec_MT() {
		return tinhThanLamViec_MT;
	}

	public void setTinhThanLamViec_MT(String tinhThanLamViec_MT) {
		this.tinhThanLamViec_MT = tinhThanLamViec_MT;
	}

	public int getKhoiLuongCongViec_DG() {
		return khoiLuongCongViec_DG;
	}

	public void setKhoiLuongCongViec_DG(int khoiLuongCongViec_DG) {
		this.khoiLuongCongViec_DG = khoiLuongCongViec_DG;
	}

	public String getKhoiLuongCongViec_MT() {
		return khoiLuongCongViec_MT;
	}

	public void setKhoiLuongCongViec_MT(String khoiLuongCongViec_MT) {
		this.khoiLuongCongViec_MT = khoiLuongCongViec_MT;
	}

	public int getKetQuaCongViec_DG() {
		return ketQuaCongViec_DG;
	}

	public void setKetQuaCongViec_DG(int ketQuaCongViec_DG) {
		this.ketQuaCongViec_DG = ketQuaCongViec_DG;
	}

	public String getKetQuaCongViec_MT() {
		return ketQuaCongViec_MT;
	}

	public void setKetQuaCongViec_MT(String ketQuaCongViec_MT) {
		this.ketQuaCongViec_MT = ketQuaCongViec_MT;
	}

	public int getKyNangTichLuy_DG() {
		return kyNangTichLuy_DG;
	}

	public void setKyNangTichLuy_DG(int kyNangTichLuy_DG) {
		this.kyNangTichLuy_DG = kyNangTichLuy_DG;
	}

	public String getKyNangTichLuy_MT() {
		return kyNangTichLuy_MT;
	}

	public void setKyNangTichLuy_MT(String kyNangTichLuy_MT) {
		this.kyNangTichLuy_MT = kyNangTichLuy_MT;
	}

	public String getDinhHuong() {
		return dinhHuong;
	}

	public void setDinhHuong(String dinhHuong) {
		this.dinhHuong = dinhHuong;
	}

	public String getDanhGiaTongThe() {
		return danhGiaTongThe;
	}

	public void setDanhGiaTongThe(String danhGiaTongThe) {
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
