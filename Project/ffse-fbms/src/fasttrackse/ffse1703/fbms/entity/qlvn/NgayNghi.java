package fasttrackse.ffse1703.fbms.entity.qlvn;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
@Entity
@Table(name="ngay_nghi")
public class NgayNghi{

	@Id
	@Column(name = "ma_nhan_vien")
	private int maNhanVien;
	
	@Column(name="so_ngay_da_nghi")
	private int soNgayDaNghi;
	
	@Column(name="so_ngay_con_lai")
	private int soNgayConLai;


	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
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

	@Override
	public String toString() {
		return "NgayNghi [" + "maNhanVien=" + maNhanVien + ", soNgayDaNghi=" + soNgayDaNghi
				+ ", soNgayConLai=" + soNgayConLai + "]";
	}

	
}
