package fasttrackse.ffse1703.fbms.entity.quantridanhgia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "phancongdanhgia")
@Entity
public class PhanCongDanhGia {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "KyDanhGia")
	private String kyDanhGia;

	@Column(name = "PhongBan")
	private String phongBan;

	@Column(name = "NhanVienDanhGia")
	private int nhanVienDanhGia;

	@Column(name = "NhanVien")
	private int nhanVien;

	@Column(name = "IsDelete")
	private int isDelete;

	public PhanCongDanhGia() {
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

	public int getNhanVienDanhGia() {
		return nhanVienDanhGia;
	}

	public void setNhanVienDanhGia(int nhanVienDanhGia) {
		this.nhanVienDanhGia = nhanVienDanhGia;
	}

	public int getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(int nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
