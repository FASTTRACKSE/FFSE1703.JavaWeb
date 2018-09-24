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
	
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien")
	private ThongTinHoSoNhanVien maNhanVien;
	
	@ManyToOne
	@JoinColumn(name="so_ngay_da_nghi")
	private ThongTinHoSoNhanVien soNgayDaNghi;
	
	@ManyToOne
	@JoinColumn(name="so_ngay_con_lai")
	private ThongTinHoSoNhanVien soNgayConLai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ThongTinHoSoNhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(ThongTinHoSoNhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public ThongTinHoSoNhanVien getSoNgayDaNghi() {
		return soNgayDaNghi;
	}

	public void setSoNgayDaNghi(ThongTinHoSoNhanVien soNgayDaNghi) {
		this.soNgayDaNghi = soNgayDaNghi;
	}

	public ThongTinHoSoNhanVien getSoNgayConLai() {
		return soNgayConLai;
	}

	public void setSoNgayConLai(ThongTinHoSoNhanVien soNgayConLai) {
		this.soNgayConLai = soNgayConLai;
	}

	
	
}
