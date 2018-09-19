package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="thongtinhopdong")
public class HopDongPikalong {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaHopDong")
	private int maHopDong;
	
	
	private int maNv;
	
	
	private int maLoaiHopDong;
	
	
	private String ngayKiKet;
	
	
	private String ngayKetThuc;
	
	@NotEmpty(message="Không được để trống!!!")
	private int soNgayNghiTrongNam;
	
	@NotEmpty(message="Không được để trống!!!")
	private String luongThang13;

	private int trangThai;
	
	
	public HopDongPikalong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HopDongPikalong(int maHopDong, int maNv, int maLoaiHopDong, String ngayKiKet, String ngayKetThuc,
			int soNgayNghiTrongNam, String luongThang13, int trangThai) {
		super();
		this.maHopDong = maHopDong;
		this.maNv = maNv;
		this.maLoaiHopDong = maLoaiHopDong;
		this.ngayKiKet = ngayKiKet;
		this.ngayKetThuc = ngayKetThuc;
		this.soNgayNghiTrongNam = soNgayNghiTrongNam;
		this.luongThang13 = luongThang13;
		this.trangThai = trangThai;
	}


	public int getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(int maHopDong) {
		this.maHopDong = maHopDong;
	}
	public int getMaLoaiHopDong() {
		return maLoaiHopDong;
	}
	public void setMaLoaiHopDong(int maLoaiHopDong) {
		this.maLoaiHopDong = maLoaiHopDong;
	}
	public String getNgayKiKet() {
		return ngayKiKet;
	}
	public void setNgayKiKet(String ngayKiKet) {
		this.ngayKiKet = ngayKiKet;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getSoNgayNghiTrongNam() {
		return soNgayNghiTrongNam;
	}
	public void setSoNgayNghiTrongNam(int soNgayNghiTrongNam) {
		this.soNgayNghiTrongNam = soNgayNghiTrongNam;
	}
	public String getLuongThang13() {
		return luongThang13;
	}
	public void setLuongThang13(String luongThang13) {
		this.luongThang13 = luongThang13;
	}
	public int getMaNv() {
		return maNv;
	}

	public void setMaNv(int maNv) {
		this.maNv = maNv;
	}
	
	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

}
	

