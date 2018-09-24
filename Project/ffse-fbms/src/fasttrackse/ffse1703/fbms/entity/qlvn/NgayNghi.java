package fasttrackse.ffse1703.fbms.entity.qlvn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
@Entity
@Table(name="ngay_nghi")
public class NgayNghi{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ngay_nghi")
    private int id;
	
	@Column(name = "ma_nhan_vien")
	private int maNhanVien;
	
	
	@Column(name="so_ngay_da_nghi")
	private int soNgayDaNghi;
	
	@Column(name="so_ngay_con_lai")
	private int soNgayConLai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setSoNgayDaNghi(int soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

	public int getSoNgayConLai() {
		return soNgayConLai;
	}

	public void setSoNgayConLai(int soNgayConLai) {
		this.soNgayConLai = soNgayConLai;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	
	
}
